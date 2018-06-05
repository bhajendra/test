package bpund.isurakaha.com.test.sqlit.crudExamp1.android.database.sqlite;

/**
 * Created by isuraksha3 on 5/23/2018.
 */

public class Stud {
    int id;
    String name;

    public Stud() {
    }

    public Stud(int id, String name) {
        this.id = id;
        this.name = name;
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
