package bpund.isurakaha.com.test.json.parsing;

import java.util.List;

import bpund.isurakaha.com.test.sortingarraylist.Student;

/**
 * Created by isuraksha3 on 4/24/2018.
 */

class NewStudent {
    List<Student> stude;
    String title;

    public NewStudent( String title,List<Student> stude) {
        this.stude = stude;
        this.title = title;
    }
}
