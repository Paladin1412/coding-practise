package serializable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-31 19:30
 **/
public class Student implements Serializable {
    
    private String name;
    private Integer age;
    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public static void serialize() throws IOException {
        Student student = new Student();
        student.setName("name");
        student.setAge(18);
        student.setScore(100);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream((new FileOutputStream(new File("student.txt"))));
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
    }

    public static void main(String[] args) {
        try {
            Student.serialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
