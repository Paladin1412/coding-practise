package keyValueTextInputFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueLineRecordReader;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-14 17:30
 **/
public class KVTextDriver{
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        String resourcePath = KVTextDriver.class.getResource("/").getPath();
        Configuration conf = new Configuration();
        conf.set(KeyValueLineRecordReader.KEY_VALUE_SEPERATOR," ");

        Job job = Job.getInstance(conf);

        job.setJarByClass(KVTextDriver.class);
        job.setMapperClass(KVTextMapper.class);
        job.setReducerClass(KVTextReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(job, new Path(resourcePath + "KVInput"));
        job.setInputFormatClass(KeyValueTextInputFormat.class);
        FileOutputFormat.setOutputPath(job, new Path(resourcePath + "KVOutput"));

        job.waitForCompletion(true);
    }
}
