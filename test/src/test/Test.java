package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-08 14:41
 **/
public class Test {
    public static void main(String[] args) {
        Person aaaaaa = new Person("aaaaa", "aaaaaa");
        Person dsadasd = new Person("bbbbb", "dsadasd");
        Person dsadasdd = new Person("bbbbb", "dsasssdasd");
        Person dsadasdddd = new Person("abbbbb", "dsadasd,dsadasdd");
        List<Person> people = Arrays.asList(aaaaaa, dsadasd,dsadasdd,dsadasdddd);
        people = people.stream().sorted(Comparator.comparing(Person::getId)).collect(Collectors.toList());
    }
}
class Person{
    public String id;
    public String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if(Objects.equals(id, person.id)){
            this.name+=person.name;
            return Objects.equals(id, person.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
