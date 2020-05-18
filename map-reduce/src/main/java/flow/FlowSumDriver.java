package flow;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-13 15:25
 **/
public class FlowSumDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        String resourcePath = FlowSumDriver.class.getResource("/").getPath();
        Configuration configuration = new Configuration();

        Job job = Job.getInstance(configuration);

        job.setJarByClass(FlowSumDriver.class);

        job.setMapperClass(FlowCountMapper.class);
        job.setReducerClass(FlowCountReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        FileInputFormat.setInputPaths(job, new Path(resourcePath + "flowInput"));
        FileOutputFormat.setOutputPath(job, new Path(resourcePath + "flowOutput"));

        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
