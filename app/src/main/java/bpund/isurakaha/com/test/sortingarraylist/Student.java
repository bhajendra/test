package bpund.isurakaha.com.test.sortingarraylist;

import java.util.List;

/**
 * Created by isuraksha3 on 4/12/2018.
 */

public class Student {

    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String s, List<Student> stude) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
