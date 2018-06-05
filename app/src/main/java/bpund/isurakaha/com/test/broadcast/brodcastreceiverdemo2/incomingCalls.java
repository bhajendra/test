package bpund.isurakaha.com.test.broadcast.brodcastreceiverdemo2;

/**
 * Created by isuraksha3 on 4/25/2018.
 */

public class incomingCalls {
    int id;
    String number;

    public incomingCalls() {
    }

    public incomingCalls(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
