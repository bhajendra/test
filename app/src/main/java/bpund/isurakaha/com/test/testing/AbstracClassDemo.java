package bpund.isurakaha.com.test.testing;

/**
 * Created by isuraksha3 on 4/18/2018.
 */

public abstract class AbstracClassDemo {

    String name;
    String address;
    abstract void work();

    public AbstracClassDemo(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
