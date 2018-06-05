package bpund.isurakaha.com.test.json.parsing;

/**
 * Created by isuraksha3 on 4/24/2018.
 */

class StudeBean {
    int id;
    String name;

    public StudeBean() {
    }

    public StudeBean(int id, String name) {
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
