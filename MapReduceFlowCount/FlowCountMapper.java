package phoneData; //?

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * LongWritable =》用于输入文件，其中key为偏移量，表示该行在文件中的位置，而不是行号
 * Text =》 map阶段的输入数据，一行文本信息，字符串类型 String
 * Text =》 map阶段的数据字符串类型 String
 * IntWritable =》map阶段输出的value类型，对应java中的int类型，表示行号
 *
 */
public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean>{
    protected void map(LongWritable key, Text text, Context context) throws IOException, InterruptedException{
        String [] fiedlds = text.toString().split("\t");
        Text phone = new Text(fiedlds[1]);

    }

}
public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    /**
     * map是Mapper中的一个方法
     *
     * map方法的调用频率是按行调用，所以其参数的含义均与行有关
     * 入参：key 表示当前行的起始偏移量
     * text：表示每一行具体的数据内容
     * context：上下文对象，上承接框架底层输入，下启shuffle阶段的输入（通常作为reduce的输入）
     */
    @Override
    protected void map(LongWritable key, Text text, Context context) throws IOException, InterruptedException {
        String [] fields = text.toString().split("\t");
        Text phone = new Text(fields[1]);
        long upFlow = Long.parseLong(fields[7]); //Long.parseLong 将 string 参数解析为有符号十进制 ，返回一个long的result基本类型值
        long downFlow = Long.parseLong(fields[8]);
        context.write(phone,new FlowBean(upFlow,downFlow)); //?如果文件中存在相同phone的两条记录，这个时候相同的phone是对应不同的key - value记录吗？
    }
}