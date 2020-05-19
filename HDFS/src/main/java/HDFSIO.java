import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-24 13:17
 **/
public class HDFSIO {
    @Test
    public void putFileToHDFS() throws URISyntaxException, IOException, InterruptedException {
        // 获取对象
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos101:9000"), conf, "root");
        // 获取输入流
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/wangyinghao/Projects/IdeaProjects/coding-practise/coding-practise.iml"));
        //获取输出流
        FSDataOutputStream fsDataOutputStream = fs.create(new Path("/coding-practise.iml"));
        // 流的对拷
        IOUtils.copyBytes(fileInputStream, fsDataOutputStream, conf);
        // 关闭资源
        IOUtils.closeStream(fsDataOutputStream);
        IOUtils.closeStream(fileInputStream);
        fs.close();
    }

    @Test
    public void getFileFromHDFS() throws URISyntaxException, IOException, InterruptedException {
        // 获取对象
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos101:9000"), conf, "root");
        // 获取输入流
        FSDataInputStream fsDataInputStream = fs.open(new Path("/coding-practise.iml"));
        //获取输出流
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/wangyinghao/Desktop/coding-practise" +
                ".iml"));
        // 流的对拷
        IOUtils.copyBytes(fsDataInputStream, fileOutputStream, conf);
        // 关闭资源
        IOUtils.closeStream(fileOutputStream);
        IOUtils.closeStream(fsDataInputStream);
        fs.close();
    }

    // 下载第一块
    @Test
    public void readFileSeek1() throws URISyntaxException, IOException, InterruptedException {
        // 获取对象
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos101:9000"), conf, "root");
        // 获取输入流
        FSDataInputStream fsDataInputStream = fs.open(new Path("/user/wangyinghao/input/hadoop-2.7.2.tar.gz"));
        // 获取输出流
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/wangyinghao/Desktop/part1");
        // 流的对拷（128MB）
        byte[] buffer = new byte[1024];
        for (int i = 0; i < 1024 * 128; i++) {
            fsDataInputStream.read(buffer);
            fileOutputStream.write(buffer);
        }
        // 关闭资源
        IOUtils.closeStream(fileOutputStream);
        IOUtils.closeStream(fsDataInputStream);
        fs.close();
    }

    // 下载第二块
    @Test
    public void readFileSeek2() throws URISyntaxException, IOException, InterruptedException {
        // 获取对象
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos101:9000"), conf, "root");
        // 获取输入流
        FSDataInputStream fsDataInputStream = fs.open(new Path("/user/wangyinghao/input/hadoop-2.7.2.tar.gz"));
        // 设置指定读取的起点
        fsDataInputStream.seek(1024 * 1024 * 128);
        // 获取输出流
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/wangyinghao/Desktop/part1");
        // 流的对拷
        IOUtils.copyBytes(fsDataInputStream, fileOutputStream, conf);
        // 关闭资源
        IOUtils.closeStream(fileOutputStream);
        IOUtils.closeStream(fsDataInputStream);
        fs.close();
    }
}
