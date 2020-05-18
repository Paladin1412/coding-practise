package wholeFile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 15:10
 **/
public class WholeRecordReader extends RecordReader<Text, BytesWritable> {

    private FileSplit fileSplit;
    private Configuration configuration;
    private boolean isProgress = true;
    private BytesWritable value = new BytesWritable();
    private Text k = new Text();

    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        fileSplit = (FileSplit) inputSplit;
        configuration = taskAttemptContext.getConfiguration();
    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        if (isProgress) {
            byte[] contests = new byte[(int) fileSplit.getLength()];
            FileSystem fs = null;
            FSDataInputStream fis = null;
            try {
                Path path = fileSplit.getPath();
                fs = path.getFileSystem(configuration);

                fis = fs.open(path);

                IOUtils.readFully(fis, contests, 0, contests.length);

                value.set(contests, 0, contests.length);

                String name = fileSplit.getPath().toString();

                k.set(name);
            } catch (Exception e) {
            } finally {
                IOUtils.closeStream(fis);
            }
            isProgress = false;
            return true;
        }
        return false;
    }

    @Override
    public Text getCurrentKey() throws IOException, InterruptedException {
        return k;
    }

    @Override
    public BytesWritable getCurrentValue() throws IOException, InterruptedException {
        return value;
    }

    @Override
    public float getProgress() throws IOException, InterruptedException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
