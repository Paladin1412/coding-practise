import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-23 19:33
 **/
public class HDFSClient {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://centos101:9000");

        // 获取HDFS客户端对象
        FileSystem fs =
                FileSystem.get(new URI("hdfs://centos101:9000"), conf, "root");

        // 在HDFS创建路径
        fs.mkdirs(new Path("/javaHDFSClient/mkdirTest"));

        // 关闭资源
        fs.close();
    }

    // 文件上传
    @Test
    public void testCopyFromLocalFile() throws URISyntaxException, IOException, InterruptedException {

        // 获取fs对象
        Configuration conf = new Configuration();
        conf.set("dfs.replication", "2");
        FileSystem fs = FileSystem.get(new URI("hdfs://centos101:9000"), conf, "root");
        // 获取fs对象
        fs.copyFromLocalFile(new Path("/Users/wangyinghao/Projects/IdeaProjects/coding-practise/coding-practise.iml"),
                new Path("/coding-practiseCopyCopyCopy.iml"));
        // 关闭资源
        fs.close();
    }

    // 文件下载
    @Test
    public void testCopyToLocalFile() throws URISyntaxException, IOException, InterruptedException {
        // 获取fs对象
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos101:9000"), conf, "root");
        // 执行下载操作
        fs.copyToLocalFile(new Path("/coding-practise.iml"), new Path("/Users/wangyinghao/Desktop/coding-practise.iml"));
        // 关闭资源
        fs.close();
    }

    // 文件删除
    @Test
    public void testDelete() throws IOException, URISyntaxException, InterruptedException {
        // 获取fs对象
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos101:9000"), conf, "root");
        // 文件删除
        fs.delete(new Path("/coding-practiseCopyCopyCopy.iml"), false);
        // 关闭资源
        fs.close();
    }

    // 文件更名
    @Test
    public void testRename() throws IOException, URISyntaxException, InterruptedException {
        // 获取fs对象
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos101:9000"), conf, "root");
        // 文件更名
        fs.rename(new Path("/coding-practise.iml"), new Path("/coding-practiseNew.iml"));
        // 关闭资源
        fs.close();
    }

    // 文件详情查看
    @Test
    public void testListFiles() throws IOException, URISyntaxException, InterruptedException {
        // 获取fs对象
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos101:9000"), conf, "root");
        // 查看文件详情
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next();

            // 查看文件名称、权限、长度、块信息
            System.out.println(fileStatus.getPath().getName()); // 文件名称
            System.out.println(fileStatus.getPermission()); //文件权限
            System.out.println(fileStatus.getLen()); //文件长度
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            for (BlockLocation blockLocation : blockLocations) {
                String[] hosts = blockLocation.getHosts();
                for (String host : hosts) {
                    System.out.println(host);
                }
            }
            System.out.println("-------------");
        }
        // 关闭资源
        fs.close();
    }

    // 判断是文件还是文件夹
    @Test
    public void testListStatus() throws IOException, URISyntaxException, InterruptedException {
        // 获取fs对象
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos101:9000"), conf, "root");
        // 判断操作
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (FileStatus fileStatus : fileStatuses) {
            if (fileStatus.isFile()) {
                System.out.println("f:" + fileStatus.getPath().getName());
            } else {
                System.out.println("d:" + fileStatus.getPath().getName());
            }
        }
        // 关闭资源
        fs.close();
    }
}
