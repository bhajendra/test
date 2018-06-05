package bpund.isurakaha.com.test.sqlit.model;

/**
 * Created by isuraksha3 on 4/19/2018.
 */

public class LoginRegister {

    int id;
    String name;
    String password;
    String timeStamp;

    public LoginRegister() {
    }

    public LoginRegister(int id, String name, String password, String timeStamp) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
