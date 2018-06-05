package bpund.isurakaha.com.test.sortingarraylist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import bpund.isurakaha.com.test.R;

public class SortingArraylist extends AppCompatActivity {

    CustomAdapter customAdapter;
    ListView listviewtest;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting_arraylist);
        mContext=this;
        listviewtest=(ListView)findViewById(R.id.listviewtest) ;

        ArrayList<Student> students=new ArrayList<>();

        Student student1=new Student(1,"bhajendra");
        Student student2=new Student(2,"ram");
        Student student3=new Student(3,"ajit");
        Student student4=new Student(4,"shuhas");
        Student student5=new Student(5,"arun");
        Student student6=new Student(6,"hardik");
        Student student7=new Student(7,"shyam");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        // sort list before add on adapter

        Collections.sort(students,new Comparators());
        customAdapter =new CustomAdapter(mContext,students);
        listviewtest.setAdapter(customAdapter);
    }

    // comaparator sort multiple objects
    // comaparable  sort single objects
    class Comparators implements java.util.Comparator<Student>
    {
        @Override
        public int compare(Student obj1, Student obj2) {
            return obj1.getName().compareTo(obj2.getName());
        }
    }
}
