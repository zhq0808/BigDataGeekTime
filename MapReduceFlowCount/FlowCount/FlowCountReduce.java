package phoneData;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.InWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowCountReduce extends Reducer<Text, FlowBean, Text, InWritable> {
    public void reduce(Text key, Iterable<FlowBean> flowBeans, Context context) throws IOException, InterruptedException {
        long upFlow = 0, downFlow = 0;
        for (FlowBean flowBean : flowBeans) {
            upFlow += flowBean.getUpFlow();
            downFlow += flowBean.getDownFlow();
        }
        context.write(key, new flowBean(upFlow, downFlow));
    }
}