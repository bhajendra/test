package bpund.isurakaha.com.test.json.parsing;

/**
 * Created by isuraksha3 on 4/24/2018.
 */

public class Flower {

    String name;
    int flowerCount;


    public Flower() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlowerCount() {
        return flowerCount;
    }

    public void setFlowerCount(int flowerCount) {
        this.flowerCount = flowerCount;
    }

    public Flower(String name, int flowerCount) {
        this.name = name;
        this.flowerCount = flowerCount;
    }
}
