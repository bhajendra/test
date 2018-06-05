package bpund.isurakaha.com.test.testing;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import bpund.isurakaha.com.test.R;
/*https://mobikul.com/android-studio-github-integration/*/
public class TestingActivity extends AppCompatActivity implements ClickInterface {


    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        activity = this;


        Pattern pattern = new Pattern();
        pattern.pattern11();
        //Q When a dialog is displayed on top of your activity, is your activity in foreground state or visible state?
        /*SingleToneDemo f = new SingleToneDemo();
        f.showOneInstance();
        SingleToneDemo f1 = new SingleToneDemo();
        f1.showOneInstance();*/


        /*StaticDemos.setClg("Mit");
        StaticDemos s=new StaticDemos("bhajendra");
        StaticDemos s1=new StaticDemos("bhajendra1");
        s.getStude();
        s1.getStude();*/

       /* InnerClassAnymousClassLevel ii=new InnerClassAnymousClassLevel(){

        };
        ii.run();

        InnerClassAnymousInterfaceLevel iii=new InnerClassAnymousInterfaceLevel() {
            @Override
            public void run() {
                Log.d("MemberInnerClass", "InnerClassAnymousInterfaceLevel class   called ");

            }
        };
        iii.run();
*/
      /*  MemberInnerClass m=new MemberInnerClass();
        MemberInnerClass.Inner i=m.new Inner();
        m.show();*/
        // InstacneInitializeBlock i = new InstacneInitializeBlock();


      /*  SuperKeyWordImpmentation s = new SuperKeyWordImpmentation();
        s.test();
        s.run();*/
        // new CoveriantTypesImplemnts().message();

   /*     ICICI ic = new ICICI();
        float icRate = ic.interstRate();
        Log.d("MethodOverLoadingDemo", String.valueOf(icRate));

        AXIS ax = new AXIS();
        float icRate1 = ax.interstRate();
        Log.d("MethodOverLoadingDemo", String.valueOf(icRate1));

        SBI sb = new SBI();
        float icRate2 = sb.interstRate();
        Log.d("MethodOverLoadingDemo", String.valueOf(icRate2));*/


        //stringCompare();
        //Searchinglastoccurance();
        //Deletingacharacter();
        //ReplacingString();
        //StringReverse();
        //SearchinaString();
        //SplitingaString();

        String name = "bhajednra";
        //findDuplicate1(name);
        //splitecharAndString(name);
        //removeDuplicateFromString(name);
        // removeDuplicate();
        //  findMaxNumber();
        // splitecharAndString(null);
        // removeWhiteSpaces();
        //checkValideNumber();
        //StringtoCharacterArray();
        // searchString();

      /*  Base bb=new child();
        child bbb=new child();
*/
     /*  *//* doPrint(b); // create object of base   b
        doPrint(bb); // create object of child  c
        doPrint(bbb);// crea*//*te object of child   v*/


    }


    private void checkedExecptionExamp() throws IOException {

        FileInputStream fileInputStream = null;
        fileInputStream = new FileInputStream("F:\\readFileExample.txt");

        int k;
        while ((k = fileInputStream.read()) != -1) {
            Log.d("op", "" + (char) k);

        }
        fileInputStream.close();

    }

   /* public static void doPrint(Base b) {
        b.show();
    }*/

        /*public void show(){  // can not override final
            Log.d("StringtoCharacterArray", " Base  called "); //

        }*/

    private void searchString() {


    }

    private void StringtoCharacterArray() {
        String str = "bhajendra";
        // convet string into character array
        char[] ch = str.toCharArray();
        for (Character c : ch) {
            Log.d("StringtoCharacterArray", " word " + c); //
        }
    }

    private void checkValideNumber() {

        String[] str = new String[]{"123456", "12.52", "bhajendra123"};
        for (int i = 0; i < str.length; i++) {

            if (str[i].indexOf(".") > 0) {  // get decimal number
                try {
                    Double.parseDouble(str[i]);// parse string to decimal;
                    Log.d("checkValideNumber12", " word " + str[i]); //
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Integer.parseInt(str[i]); // convet string into integer...
                    Log.d("checkValideNumber123", " word " + str[i]); //
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void removeWhiteSpaces() {
        String name = " bhajenddra dfsdfd sdfdsfds     dsfdsfd sdfdfsd  ";
        String str = name.replaceAll("\\s", "");
        Log.d("removeWhiteSpaces", " word " + str); //
    }

    private void findMaxNumber() {

        int[] str = {1, 13, 4, 8, 9};
        int max = str[0];
        for (int i = 1; i < str.length; i++) {

            if (str[i] > max) {
                max = str[i];
            }

        }
        Log.d("findMaxNumber", " word " + max); //
    }

    private void removeDuplicate() {
        String name = "bhajenddra";

        char[] ch = name.toCharArray();
        Set<Character> set = new LinkedHashSet<>(); //Maintains insertion order.
        for (Character chs : ch) {
            set.add(chs);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Character c : set) {
            stringBuffer.append(c);
        }
        Log.d("splitecharAndString", " word " + stringBuffer.toString()); //
    }

    private void removeDuplicateFromString(String name) {

        String input = new String("bhajendra");
        String output = new String();

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < output.length(); j++) {
                if (input.charAt(i) != output.charAt(j)) {
                    output = output + input.charAt(i);
                }
            }
        }
        Log.d("splitecharAndString", " word " + output); //
    }

    private void splitecharAndString(String name1) {

        // remove comma from string
        String name = "155655kkfjdklsfj";
        String str = name.replace("_", "");
        char[] fullString = str.toCharArray();
        String alpha = "";
        String numaric = "";
        int sum = 0;
        for (Character st : fullString) {
            if (Character.isDigit(st)) {
                numaric = numaric + st;
                sum = sum + Integer.parseInt(st.toString());
            } else {
                alpha = alpha + st;
            }
        }
        Log.d("splitecharAndString1", " word " + alpha + " count " + numaric + " sum " + sum); //
    }

    private void findDuplicate1(String name) {

        // create hash map to store count
        HashMap<Character, Integer> characterStringHashMap = new HashMap<>();
        char[] chr = name.toCharArray();
        for (Character ch : chr) {
            if (characterStringHashMap.containsKey(ch)) {
                characterStringHashMap.put(ch, characterStringHashMap.get(ch) + 1);
            } else {
                characterStringHashMap.put(ch, 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entrySet = characterStringHashMap.entrySet(); // set remove duplitcate element
        for (Map.Entry<Character, Integer> val : entrySet) {
            Log.d("Duplicate", " word " + val.getKey() + " count " + val.getValue()); //
        }

    }

    private void SplitingaString() {

        String name = "b h a j e n d r a p u n d";
        String[] str = name.split("\\s");
        for (String s : str) {
            Log.d("StringReverse", " " + s);
        }
    }

    private void SearchinaString() {
        String name = "bhajendra pund";
        int index = name.indexOf("pund");
        if (index == -1) {
            Log.d("StringReverse", " " + ("Hello not found")); //
        } else {
            Log.d("StringReverse", " " + "found " + index); //
        }
    }

    private void StringReverse() {
        String name = "bhajendra";
        String str = "";
        // convert string to char arrray
        char[] cha = name.toCharArray();
        //iterate
        for (int i = cha.length - 1; i >= 0; i--) {
            Log.d("StringReverse", " " + cha[i]); //
            str += cha[i];
        }
        Log.d("StringReverse", " " + str); //

    }

    private void ReplacingString() {
        String name = "bhajendra chandrakant pund";
        String name1 = "sonibhajendra chandrakant pund";


        Log.d("Searchinglastoccurance", " " + name.replace("b", "s")); //
        Log.d("Searchinglastoccurance", " " + name.replaceFirst("bha", "sha")); //
        Log.d("Searchinglastoccurance", " " + name.replaceAll(name, name1)); //


    }

    private void Deletingacharacter() {
        String name = "bhajendra chandrakant pund";
        Log.d("Searchinglastoccurance", "" + removeAt(name, 3)); //


    }

    private String removeAt(String name, int i) {
        return name.substring(0, i) + name.substring(i + 1);
    }

    private void Searchinglastoccurance() {

        String name = "bhajendra chandrakant pund";
        Log.d("Searchinglastoccurance", "" + name.lastIndexOf("pund")); //
        Log.d("Searchinglastoccurance", "" + name.lastIndexOf("p")); //

    }

    private void stringCompare() {

        Toast.makeText(this, "toast", Toast.LENGTH_LONG).show();
        String str = "bhajendra";
        String str1 = "Bhajendra";
        Object obj = str;
        Log.d("output", "********** compareTo "); //
        Log.d("output", "" + str.compareToIgnoreCase(str1)); //
        Log.d("output", "" + str.compareTo(obj.toString())); //
        Log.d("output", "" + str1.compareTo(obj.toString())); //

        Log.d("output", "********** compareTo "); // compare conly text
        Log.d("output", "" + str.equals(str1)); //
        Log.d("output", "" + str.equalsIgnoreCase(str1)); //
        String strs = new String("pund");
        String strs1 = new String("bhajendra");  // if we create new string and content are same then it return ture
        Log.d("output", "" + str.equals(strs1)); //

        Log.d("output", "********** == "); // compare conly text
        String name1 = "bhajenra";
        String name2 = "bhajenra";
        String name3 = new String("bhajenra");
        Log.d("output", "" + (name1 == name2)); //true
        Log.d("output", "" + (name1 == name3)); //true


    }

    @Override
    public int display() {
        int a = 20, b = 30, c;
        return c = a + b;
    }

    @Override
    public int hide() {
        int a = 20, b = 30, c;
        return c = a + b;

    }

    class AbstractDemo extends AbstracClassDemo {
        int id;

        public AbstractDemo(int id, String name, String address) {
            super(name, address);
            this.id = id;
        }

        @Override
        void work() {
            if (id == 0) {
                Log.d("test", name);
            }
        }
    }
}


class Base {

    static int a;

    static {  // 1 // static blick called before constor call.
        a = 4;
        Log.d("static10001", " static" + a);
    }

    public Base() {  // 2 this will called after static block.
        a = 10;
        Log.d("static10001", " Base construtor" + a);

    }

    static void incrementVal() { // 3 after construtor is called
        a = 20;
        Log.d("static10001", " Base incrementVal" + a);
    }

    /* public Base() {
        this(100, 200); // called paramerter construtor from default construtor
        // using this we can call parameterize construtor...
    }

    int xx, yy;

    public Base(int x, int y) {
        xx = x;
        yy = y;
    }

    int getVal() {
        return xx;
    }

    @Override
    public String toString() {
        return "Base{" +
                "xx=" + xx +
                '}';
    }

    public void show() {
        Log.d("StringtoCharacterArray", " child  called ");
    }*/
}
/*

class child extends Base {
    public void show() {
        Log.d("StringtoCharacterArray", " child  called ");
    }
}*/


class Job {

    int jobId;
    float salary;

    public Job() {
    }

    public Job(int jobId, float salary) {
        this.jobId = jobId;
        this.salary = salary;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}

class Person {
    // composiont achived using instance variables

    Job job;

    public Person() {
        this.job = new Job();
        job.setSalary(25000);
    }

    public float getSal() {
        return job.getSalary();
    }
}

interface A {
    void show1();
}

interface B {
    void show1();
}

interface C extends A, B  // ONE interfcae can extend mulitple interfaces
{

}

interface InterfaceA {

}

interface InterfaceB {

}

interface InterfaceC {

}

interface InterfaceD {

}

interface Interface extends InterfaceA, InterfaceB, InterfaceC, InterfaceD {


}

abstract class InterfaceImP1 implements InterfaceA, InterfaceB, InterfaceC, InterfaceD {
}

class Bicycle {
    public int cadem;
    public int geat;
    public int speed;
    private String love;

    public Bicycle() {
    }
    // construtor

    public Bicycle(int cadem, int geat, int speed) {
        this.cadem = cadem;
        this.geat = geat;
        this.speed = speed;
    }

    public void setCadem(int cadem) {
        this.cadem = cadem;
    }

    public void setGeat(int geat) {
        this.geat = geat;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void appyBreak(int decremnt) {
        this.speed -= decremnt;
    }
}


// subclass
class MoundtainBike extends Bicycle {

    public int height;

    public MoundtainBike() {

    }

    public MoundtainBike(int cadem, int geat, int speed) {
        super(cadem, geat, speed);
    }


    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
}
// multilevel inheritance

class AA {
    void showAA() {
        Log.d("Bpund1000", " Base showAA");

    }
}

class BB extends AA {
    void showBB() {
        Log.d("Bpund1000", " Base showBB");

    }
}

class CC extends BB {
    void showCC() {
        Log.d("Bpund1000", " Base showCC");
    }
}

// hirachical inheritance
// more than one class extents super class is called hirachcle inheritance

class Fruits {
    void fruts() {
        Log.d("Bpund1000", " fruts");
    }
}

class Apple extends Fruits { // extendt super class
    void frutsApple() {
        Log.d("Bpund1000", "  frutsApple");
    }
}

class Bannan extends Fruits {
    void frutsBannan() {
        Log.d("Bpund1000", " Bannan");
    }
}

// aggrgation
// class have entity refrence.

class Address {
    int id;
    String city;

    public Address(int id, String city) {
        this.id = id;
        this.city = city;
    }
}

class Persons {

    String name;
    Address address;  // person has entity refrence with address class....

    public Persons(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    void showDetails() {
        Log.d("Persons", name);
        Log.d("Persons address ", address.id + "" + address.city);

    }

}

// method overloading

class MethodOverLoadingDemo {
    // same clss
    // with differ parameters
    // changing datatyps
    // can not do chaning retun type of method

    void add(int a, int b) {
        int result = 0;
        result = a + b;
        Log.d("MethodOverLoadingDemo", String.valueOf(result));


    }

    void add(int a, int b, int c) {

        int result = 0;
        result = a + b + c;
        Log.d("MethodOverLoadingDemo", String.valueOf(result));

    }
    /*int add(int a, int b, int c) { // method is alrady define if change return types

        int result = 0;
        result = a + b + c;
    }*/
}
/*

class MethodOverLoadingDemo1 {

    int add(int a, int b) {
        int result = 0;
        result = a + b;
        Log.d("MethodOverLoadingDemo", String.valueOf(result));
        return result;

    }

    float add(int a, int b) { // method is already defince in the class

        int result = 0;
        result = a + b;
        Log.d("MethodOverLoadingDemo", String.valueOf(result));
        return result;
    }

    //if creat object of class and accesss method which ll create ambiguity
    //ext obje.add() ---<
}
*/

class Bank {

    float interstRate() {
        return 0;
    }
}

class ICICI extends Bank {
    @Override
    float interstRate() {
        return 10;
    }
}


class AXIS extends Bank {
    @Override
    float interstRate() {
        return 20;
    }
}


class SBI extends Bank {
    @Override
    float interstRate() {
        return 30;
    }
}

class CoveriantTypes {

    CoveriantTypes getInstance() {
        return this;
    }
}

class CoveriantTypesImplemnts extends CoveriantTypes {

    CoveriantTypesImplemnts getInstance() {  // coveriant return types...
        return this;
    }

    void message() {
        Log.d("MethodOverLoadingDemo", "CoveriantTypesImplemnts");

    }
}

class SuperKeyWord {

    int num = 100;

    public SuperKeyWord() {
        Log.d("SuperKeyWord", "SuperKeyWord Construtor 111");
    }

    void test() {
        Log.d("SuperKeyWord", "SuperKeyWord method called from child class");
    }
}

class SuperKeyWordImpmentation extends SuperKeyWord {

    int num1 = 100;  // if we acccess parent class instance variable then var name should be same

    SuperKeyWordImpmentation() {
        // if we not use super compiler implicityly provde super.
        super(); // 3) super is used to invoke parent class constructor.
        super.test();
        // 1) super is used to refer immediate parent class instance variable.
        Log.d("SuperKeyWord", "SuperKeyWord method" + super.num);
    }

    void run() {
        super.test(); //2) super can be used to invoke parent class method
    }
}

class InstacneInitializeBlock {

    // to initialize intance variable
    int speed = 200;

    public InstacneInitializeBlock() {
        Log.d("InstacneInitializeBlock", "InstacneInitializeBlock  construt called ");
    }

    {
        speed = 100;
        Log.d("InstacneInitializeBlock", "InstacneInitializeBlock  called ");
    }
}
/*

class FinalDemo {

    static final int a;

    static {
        a = 100;

    }
}

class StaticBinding {

    void show() {
        Log.d("StaticBinding", "StaticBinding  called ");
    }
}

class RunTimeBinding {
    void run() {
        Log.d("StaticBinding", "StaticBinding  called ");
    }
}

class RunTimeBindingImpl extends RunTimeBinding {
    void show() {
        Log.d("StaticBinding", "StaticBinding  called ");
    }
}
}



    // object is determine at run time ex
    RunTimeBinding rb = new RunTimeBindingImpl(); //
         rb.show();

*/

// java memeber inner class

class MemberInnerClass {

    int a = 200;

    public MemberInnerClass() {
    }

    class Inner {
        // inner class
        void show() {
            Log.d("MemberInnerClass", "inner class   called " + a);
        }
    }

    void show() {
        Log.d("MemberInnerClass", "MemberInnerClass class   called " + a);

    }
}

// class level

abstract class InnerClassAnymousClassLevel {

    void run() {
        Log.d("MemberInnerClass", "MemberInnerClass class   called ");
    }
}

// interface lever
interface InnerClassAnymousInterfaceLevel {

    void run();
}

class LocalInnerClass {

    int a = 200;

    void display() {
        class LocalClass {
            void local() {
                Log.d("LocalInnerClass", "MemberInnerClass class   called " + a);
            }
        }
        LocalClass l = new LocalClass();
        l.local();
    }
}

class StaticDemos {

    private static String name;

    static int count;
    static int rollNumer;
    static String clg;

    public StaticDemos(String name) {
        this.name = name;
        this.rollNumer = getRollNum();
    }

    public static int getRollNum() {
        count++;
        return count;
    }

    static void setClg(String c) {
        clg = c;
    }

    static void getStude() {
        Log.d("details", "" + name + "" + getRollNum() + "" + clg);
    }

}


class ThredDemoDemo extends Thread {

    public void run() {

        doSomeTask();
        doSomeTask();
        doSomeTask();
        doSomeTask();
    }

    private void doSomeTask() {
        for (int i = 0; i < 5; i++) {
            Log.d("Thread Examp", "" + i);

        }
    }
}

// runable interface 1
class RunableInterfaceImple implements Runnable {

    String[] countryName = {"a", "b", "c", "a", "b", "c", "a", "b", "c", "a", "b", "c", "a", "b", "c", "a", "b", "c"};

    @Override
    public void run() {

        for (int i = 0; i < countryName.length; i++) {
            try {
                Thread.sleep(2000);
                Log.d("runable interface", countryName[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class RunableDemo2 implements Runnable {

    // make static instance varibale
    static int count = 0;

    @Override
    public void run() {
        /// loop throw all data
        while (RunableDemo2.count <= 10) {
            Log.d("RunableDemo2 interface", "" + ++RunableDemo2.count);
        }
    }
}


/*
  class SampleThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; 0 < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ThreadJoion.name.add(getName())
    }

}
*/

/*public  class ThreadJoion {

  static List<String> name = new ArrayList<String>();

   void execute() throws InterruptedException {
       List<SampleThread> list;
       for (int i = 0; 0 < 10; i++) {
           list = new ArrayList<SampleThread>();

           SampleThread sampleThread = new SampleThread();
           list.add(sampleThread);
           sampleThread.start();
       }

       for (SampleThread s : list) {
           try{
               s.join();
           }catch (Exception e){
               e.printStackTrace();
           }

       }
       Log.d("joion method ",""+ name);

   }


}*/
interface InterfaceDemo1 {

}

interface InterfaceDemo2 {

}

interface InterfaceDemo extends InterfaceDemo1, InterfaceDemo2 {
    //d1 all method are abstract by defautl and all fields are final
    //d2 it declare only method method signature not implimention
    public void run1(); // only declaration
// can not create object
// we can access method to create refrence of thiat class
    // it is slow becase it requre extrac indirecion to find curspoinding method
    // ingerfacea can extend mulitple interface
    // or class can implemnt mulipleinterfceas

    // intefcae can not have prive and protedted
    //protected void mm(); // modifier not allowd here
    // private int a;  // modifier private  not allowd here
    // all method and filed by default final if we not declare as finls compiler assing to it
    // if we decalre any method in interfece we should track doubm all method
    public void sad();
    //InterfaceDemo();

}

abstract class AbstractDemo1 {

}

abstract class AbstractDemo2 {

}

abstract class AbstractDemo extends AbstractDemo1 {
    AbstractDemo() {

    }

    //d1 not neccessary
    final int b = 0;
    int a;
    //d2 it conatains concrete and non concrete method

    abstract void run(); // concrete method

    void play() {
        // non concreate method
    }

    void sing() {  // if we declare withoud abstract we shoudl imple body to it

    }

    // can not creat object
    // we can access method to create refrence of thiat class
    // it is fast be it si actual classesS
    // abstract class can extend only one abstract class
    // abstract clas can have any visbility
    public int xx;
    private int xxxx;
    protected int bbbbb;

    // but abstrct class dont need to track
}

class abs extends AbstractDemo implements InterfaceDemo {

    @Override
    void run() {

    }


    // interface method
    @Override
    public void run1() {

    }

    @Override
    public void sad() {

    }
    // class must be declare ad abstract or implemtn inteface new method

    // no need to implemtn akk methods

}


class ExemptionDemo {

    void run() throws NullPointerException, ArithmeticException {

        throw new NullPointerException("throw error");


    }
}

//custom exception
class CustomExeption extends Exception {
    // this is checked exception
}

class CustomExeption1 extends IOException {
    // this is checkd exception
}

class CustomExeption2 extends NullPointerException {
    // this is runtime exception...
    void raa() {

        int[] a = new int[5]; // 1
        int aa[] = new int[5]; //
        int aaaa[] = new int[]{1, 2, 3, 4, 5, 6}; //3

        try {

        } catch (Exception e) {
            e.printStackTrace();//This method prints the stack trace information to the standard error stream.
            e.getMessage(); //This method returns the message String about the exception
            e.toString(); //This method returns the information in String format
            e.getCause(); //This method returns the cause of the exception
            e.getStackTrace();//This method returns an array containing each element on the stack trace

        }
    }
}

class MulitiDimention {

    static void multi() {

        // decalre mutltidimenion array

        int a[][] = new int[4][5];  // 4 row 5 colm
        int b[][] = new int[4][5];  // 4 row 5 colm

        int i, j, k = 0;

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++) {
                a[i][j] = k;
                k++;
            }
        }
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++) {
                Log.d("print multidiment", "" + a[i][j]);
            }
        }


    }
}

class MemoryDemo {
}

class MemoryImp extends MemoryDemo {
    // two memory stack and heap
    int instanceVariable;  // instance varibale store in heap area
    static int staticVar; // static variable store in heap area
    String stringLitral = "bhajednra"; // this store in permGen in heap area
    String stringLitralq = "bhajednra"; // this store in permGen in heap area
    // stringLitral & stringLitral1 point to same object in string pool
    String string = new String("bhajendra"); // this store in heap area.

    void memorys() {  //
        // whole method code stored in heap area
        int localVar; // local var store in  stack
    }

    // object creatoin
    MemoryDemo md = new MemoryImp(); // md is refrence of MemoryDemo class which store in stack area as well
    MemoryDemo md1 = new MemoryImp(); // md1 is refrence of MemoryDemo class which store in stack as well
    MemoryDemo md2 = new MemoryImp();// md2 is refrence of MemoryDemo class which store in stack as well
    // md.memorys() // method calling stored in stack area
    // object md md1 md2 are stored in heap area
    // hare md refence pointe to refrence of md object in heap area
    // md ----> refrence to md object in heap area
}
// locat variable and reference variable stored in stack area
// instance var,static varibale ,object store in heap area
// summery
//1 stack :- local var, reference var,method call..
//2 heap : - instance var,static var, object ,method code.


// 1) Java_Program Fibonacci series
class Fibonaci {

    int f1 = 0, f2 = 1, f3;

    void fibo() {
        Log.d("fibonic1", String.valueOf(f1 + "" + f2));  //op 0 1 1 2 3 5 11
    }

    void fibo1() {
        for (int i = 2; i < 5; i++) {
            Log.d("fibonic ", String.valueOf(f3));  //123 5 8
            f3 = f1 + f2; //1 2 5
            f1 = f2; //1,1 2 3
            f2 = f3; //1,2 3 5
        }
    }
}

//Java_Program  finbonaci series using recersion


class Fibonaci1 {

    int f1 = 0, f2 = 1, f3;

    void fibo() {
        Log.d("fibonic1", String.valueOf(f1 + "" + f2));  //op 0 1 1 2 3 5 11
    }

    void fibo1(int count) {
        if (count > 0) { // 8
            Log.d("fibonic ", String.valueOf(f3));  //0 1  1 2 3 5 8 13 21 34
            f3 = f1 + f2; //  1 2 3 5 8 13 21  34 56
            f1 = f2; //  1 1 2 3 5 8 13 21 34
            f2 = f3; // 1 2 3 5 8 13 21 34 54

            fibo1(count - 1); // 7 6 5 4 3 2 1     13
        }


    }
}

//Java_Program  check give nuber prime or not
class PrimeNumber {

    int m, flag = 0;

    void prime(int n) {
        m = n / 2;
        if (n == 0 || n == 1) {
            Log.d("PrimeNumber1 ", String.valueOf(n) + "is not primae number");
        } else {
            for (int i = 2; i <= 3; i++) {
                if (n % i == 0) {
                    Log.d("PrimeNumber2 ", String.valueOf(n) + "is not primae number");
                    flag = 1;
                    break; // break whole loop...
                }
            }
            if (flag == 0) {
                Log.d("PrimeNumber3 ", String.valueOf(n) + " is  primae number");
            }
        }

    }
}

//Java_Program prnit 1 to 100 prime nuber

class Prime100 {

    int num;
    String addToPrime = "";

    void prime100() {

        for (int i = 1; i < 100; i++) { // for 100 time
            int count = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {    // note 8
                    count = count + 1;
                }
            }

            if (count == 2) {
                addToPrime = addToPrime + "," + +i; // append number to prime
            }
        }
        Log.d("1 to 100 prim number ", addToPrime);

    }
}

//Java_Program  prime number n muber
class PrimeNnuber {

    String nFoPrimeNum;

    void primeNnuber(int n) {
        int num;
        for (int i = 1; i <= n; i++) {

            int count = 0;
            for (num = i; num >= i; num--) {
                if (i % num == 0) {
                    count = count + 1;
                }
            }
            if (count == 2) {
                // append to string
                nFoPrimeNum = nFoPrimeNum + "," + i;
            }
        }
        Log.d("1 to 100 prim number ", nFoPrimeNum);

    }

}


/*
java compiler ==> convet java fiel to class file
dex tool or compile convet class file into .dex file and aapt package create apk and that apk finally run on device suing dvm*/
// adb
// adb is android debug bridge which is command line tool to communicate with device
//Java Program to reverse words in a String
class ReversString {
    String name = "bhajendra";

    void revString() {
        Log.d("ReversString ", name);
        for (int i = name.length() - 1; i >= 1; i--) {
            Log.d("ReversString ", " " + name.charAt(i));
        }
    }
}

//Java_Program to check Even or Odd number done
//Program to find the average of numbers using array
class AvgFromArray {

    int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int total = 0;
    int avg;

    void avg() {
        for (int i = 0; i < a.length; i++) {
            total = total + a[i];
        }
        avg = total / a.length;
        Log.d("AvgFromArray ", String.valueOf(avg));
    }
}
//Java_Program to display first 100 prime numbers done
//Java Program to display prime numbers between 1 and 100 or 1 and n done
// check prime num

class PrimeNum {

    void prime() {
        int num = 18;
        int checkPrime;
        boolean isPrime = true;
        for (int i = 2; i < num / 2; i++) {
            checkPrime = num % 2;
            if (checkPrime == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            Log.d("AvgFromArray ", String.valueOf(num) + "is prime");
        } else {
            Log.d("AvgFromArray ", String.valueOf(num) + "not prime");
        }
    }
}
//Java Program to display  revrese Number using while loop
//login
//int remin
/*
num=num%10;  // get reminder
revreseNum=reversNum+numZ%10
num=num/10*/


class ReverseNum {

    int rev = 0;
    int num = 123;

    void rev() {
        while (num > 0) {
            rev = (rev * 10) + (num % 10);  // 0*10=0 +
            num = num / 10;
        }
    }
}

//Java_Program to display  revrese Number using while loop
class ReverseParameter {

    int revser = 0;

    int revPerm(int num) {
        // get last digit
        // get remain num

        while (num > 0) {
            //step 1 get last digit  ex 3
            revser = revser * 10 + num % 10;
            //step 2 get remaing digit ex 12
            num = num / 10;
        }
        return revser;
    }
}

//Java_Program 3: Reverse a number using recursion

class ReverseRecursion {

    int revser = 0;

    void reRecursion(int num) {

        if (num < 10) {
            Log.d("AvgFromArray ", "Revrese is " + String.valueOf(num));
        } else {
            // calling method itself ic called recursion
            revser = num % 10;  // give us last numer
            Log.d("AvgFromArray ", String.valueOf(revser) + "not prime");
            reRecursion(num / 10); // give us remaing number
        }
    }
}
//Java_Program Program to check whether the given number is positive or negative

class PostiveNegativeNum {

    int num;

    void posNeg() {
        if (num > 0) {
            //positive
        } else if (num < 0) {
            // not gevative or positive
        } else {
            //negative
        }
    }
}

// Java_Program use same login for revrese number...
class PalindromNum {
    int rer = 0;
    int num = 454;
    int temp = num;

    void palin() {
        //step 1 get last digit
        //step  2 get raaming digit
        while (num > 0) {
            rer = rer * 10 + num % 10;
            num = num / 10;
        }
        if (rer == temp) {
            Log.d("AvgFromArray ", String.valueOf(rer) + "is palindrom");
        } else {
            Log.d("AvgFromArray ", String.valueOf(rer) + "is not palindrom");
        }
    }

}
// Java_Program to check give string is palindrom of not

class PalinString {

    String name = "aba"; // this is palindrom string
    String temp = name;
    String rev = "";

    void palinString() {

        //step i revrese the string
        //step 2  check that number with temp variable ;
        for (int i = name.length() - 1; i >= 0; i--) {
            rev = rev + name.charAt(i);
        }
        if (temp.equals(rev)) {  // user quals method of string which check the string content are equal or not
            Log.d("AvgFromArray ", String.valueOf(temp) + "string is palindrom");
        } else {
            Log.d("AvgFromArray ", String.valueOf(temp) + "string is not palindrom");
        }
    }
}

class ReverseStringBuildMethod {
    String name = "bhajendra";

    void reverseStringBuildMethod() {

        StringBuffer stringBuffer = new StringBuffer(name);
        Log.d("ReverseStringBui ", String.valueOf("revrese string " + stringBuffer.reverse()));
    }
}
//Java_Program to check string occurance.

// Set
class StringOccuraneDuplicateString {

    // step 1 store all char and courence in hashamp
    // convet string to char array;
    //user for loop to iterate all string char
    // check that contain in map or not
    // check if that alrady contain then increat by one
    // obtain the key using set
    // iterat over key and get all char and theire occurrance

    //1
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    //2
    String name = "bhajendra";

    void stringOccuraneDuplicateString() {

        //3 convet string to char
        char[] c = name.toCharArray();

        // 4 loop over
        for (Character cha : c) {
            // 5
            if (map.containsKey(cha)) {
                map.put(cha, map.get(cha) + 1); //  if conatain increae count by one
            } else {
                map.put(cha, 1); //  if conatain increae count by one
            }
        }
        //6
        Set<Character> set = map.keySet();  // made mistake
        //7
        for (Character setVal : set) {
            //8
            if (map.get(setVal) > 1) {
                Log.d("ReverseStringBui ", String.valueOf("char " + setVal + " occurance " + map.get(setVal)));
            }
        }
    }
}


// stop https://beginnersbook.com/2017/09/java-examples/
// main use : create only one object of that class
// single tone class in java
//1 create cureent calss class refrence sith private and static
//2 make constructor as private
////3 retun current class object with public static refrence

//example
class SingleToneDemo {

    //1
    private static SingleToneDemo singleToneDemoObje; // current class ref..

    //2
    SingleToneDemo() {
    }


    public static SingleToneDemo getInstance() {

        if (singleToneDemoObje == null) {
            singleToneDemoObje = new SingleToneDemo();
        }
        return singleToneDemoObje;
    }

    void showOneInstance() {
        Log.d("ReverseStringBui ", "showOneInstance");

    }


}

// program pattern

class Pattern {
/*
1
    12
    123
    1234
    12345*/

    void pattern1() {

        for (int i = 1; i <= 0; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println(" ");
        }

    }

    /*
    *
    **
    ***
    ****
    ******/

    void pattern2() {

        for (int i = 5; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

    }

    /*12345
    1234
    123
    12
    1*/
    void pattern3() {

        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println(" ");
        }

    }

    /*
     *****
     ****
     ***
     **
     *
     */
    void pattern4() {

        for (int i = 5; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

    }


//180 degress
       /*  *
        **
       ***
      ****
     ******/

    void pattern5() {

        // loop1 main loop for number of row
        // into loop2 for spaces
        // loop3 fro print the pattenr
        int n = 5;
        int k = n - 1;
        for (int i = 0; i < n; i++) {

            // loop2 for spaces
            for (int j = 0; j < k; j++) {
                System.out.print(" ");
            }
            k = k - 1;
            //loop3 to print patten
            for (int m = 0; m <= i; m++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    /*1
      23
      456
      78910*/
    void pattern6() {

        int i, j, num = 1, n = 5;
        for (i = 0; i < n; i++) {
            // print numbers
            for (j = 0; j <= i; j++) {
                System.out.print(num);
                num = num + 1;
            }
            System.out.println(" ");
        }

    }
    /*0
    01
    0123
    01234
    012345*/

    void pattern7() {

        int i, j, n = 5;
        for (i = 0; i < n; i++) {
            // print numbers
            for (j = 0; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println(" ");
        }
    }

    /*1
    22
    33
    444
    55555*/

    void pattern8() {

        int i, j, n = 5;
        for (i = 1; i <= n; i++) {
            // print numbers
            for (j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println(" ");
        }
    }

    /*
    1
    12
    123
    1234
    12345
    1234
    123
    12
    1
    */
    void pattern9() {

        int i, j, n = 5;
        for (i = 1; i <= n; i++) {
            // print numbers
            for (j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println(" ");
        }
        int x, y;
        for (x = n - 1; x >= 0; x--) {

            for (y = 1; y <= x; y++) {
                System.out.print(y);

            }
            System.out.println(" ");


        }

    }

    /*
    1
   1 2
  1 2 3
 1 2 3 4
1 2 3 4 5
 1 2 3 4
  1 2 3
   1 2
    1
    */

    void pattern10() {
        System.out.println(" Jai Shree Ram ");

        int i, j, n = 5;
        int k = n - 1;
        int innerSpaces;

        for (i = 1; i <= n; i++) {
            // for loop for spacess
            for (int space = 0; space <= k; space++) {
                System.out.print(" ");
            }
            k = k - 1;
            // print numbers
            for (j = 1; j <= i; j++) {
                System.out.print(j);
                // for inner spaces
                for (innerSpaces = 1; innerSpaces <= 1; innerSpaces++) {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
        int x, y;
        int row = n - 4;
        int p;
        for (x = n - 1; x >= 0; x--) {

            for (p = row; p >= 0; p--) {
                System.out.print(" ");
            }
            row = row + 1;

            for (y = 1; y <= x; y++) {
                System.out.print(y);
                // for inner spaces
                for (innerSpaces = 1; innerSpaces <= 1; innerSpaces++) {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }

      /*

      *
     * *
    * * *
   * * * *
  * * * * *
   * * * *
    * * *
     * *
      *

      */

    void pattern11() {
        System.out.println(" Jai Shree Ram11 ");
        int n = 5;
        int i, j, space = n - 1;
        for (i = 0; i < 5; i++) {
            for (i = 0; i < space; i++) {
                System.out.print(" ");
            }
            space--;
            for (j = 0; j < i; j++) {
                System.out.print(j);
            }
        }
    }
    /*olly for push*/
}








