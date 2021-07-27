package phoneData;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.ToolRunner;

public class FlowJobber extends Configured implements Tool {
    public int run(String[] args) throws Exception{

    }
}

public class FlowJobber{
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "telescope");

        //指定mapper，reduce类
        job.setJarByClass(FlowJobber.class);
        job.setMapperClass(FlowCountMapper.class);
        job.setReduceClass(FlowCountReduce.class);
        //指定输入数据类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);
        //指定输出数据类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPaths(job, nwe Path(args[1]));

        job.waitForCompletion(true);
    }
}