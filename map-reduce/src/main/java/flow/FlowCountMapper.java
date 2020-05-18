package flow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-13 14:54
 **/
public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    FlowBean v = new FlowBean();
    Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String[] fields = line.split("\t");

        String phoneNum = fields[0];

        long upFlow = Long.parseLong(fields[fields.length - 3]);
        long downFlow = Long.parseLong(fields[fields.length - 2]);

        k.set(phoneNum);
        v.setUpFlow(upFlow);
        v.setDownFlow(downFlow);

        context.write(k, v);
    }
}
