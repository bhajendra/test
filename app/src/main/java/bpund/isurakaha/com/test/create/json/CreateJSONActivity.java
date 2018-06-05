package bpund.isurakaha.com.test.create.json;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import bpund.isurakaha.com.test.R;

public class CreateJSONActivity extends AppCompatActivity {

    Context context;
    ArrayList<Students> arraylist;
    ListView listview_json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_json);
        listview_json = (ListView) findViewById(R.id.listview_json);
        context = this;
        arraylist = new ArrayList<>();

        // gsonConverter();
     /*   createJson();
        CustomJsonArrayAdapter customJsonArrayAdapter = new CustomJsonArrayAdapter(context, arraylist);
        listview_json.setAdapter(customJsonArrayAdapter);*/

    }

    private void gsonConverter() {

        JSONObject main = new JSONObject();

        JSONArray jsonPhoneNumbers = new JSONArray();
        jsonPhoneNumbers.put(123456);
        jsonPhoneNumbers.put(123456);

        JSONArray jsonCities = new JSONArray();
        jsonCities.put("Los Angeles");
        jsonCities.put("New York");

        JSONObject jsonProperties = new JSONObject();
        try {
            jsonProperties.put("age", "28 years");
            jsonProperties.put("salary", "1000 Rs");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonAddress = new JSONObject();
        try {
            jsonAddress.put("street", "BTM 1st Stage");
            jsonAddress.put("city", "Bangalore");
            jsonAddress.put("zipcode", 560100);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            main.put("empID", 100);
            main.put("name", "David");
            main.put("permanent", false);
            main.put("role", "Manager");

            main.put("address", jsonAddress);
            main.put("phoneNumbers", jsonPhoneNumbers);
            main.put("cities", jsonCities);
            main.put("properties", jsonProperties);
            Log.d("emptJsonData", main.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObjectParse = new JSONObject(String.valueOf(main));
            Employee employee = new Employee();
            employee.setEmpId(jsonObjectParse.getInt("empID"));
            employee.setName(jsonObjectParse.getString("name"));
            employee.setPermanent(jsonObjectParse.getString("permanent"));
            employee.setRole(jsonObjectParse.getString("role"));
            JSONObject addressJSON = jsonObjectParse.getJSONObject("address");

            Address addressObje = new Address();
            addressObje.setStreet(addressJSON.getString("street"));
            addressObje.setCity(addressJSON.getString("city"));
            addressObje.setZipcode(addressJSON.getLong("zipcode"));
            employee.setAddress(addressObje);

            JSONArray phone = jsonObjectParse.getJSONArray("phoneNumbers");
            for (int i = 0; i < phone.length(); i++) {
                long phoneNumber = phone.getLong(i);
              //  employee.setPhoneNumber(phoneNumber);
            }

            JSONArray city = jsonObjectParse.getJSONArray("cities");
            for (int i = 0; i < city.length(); i++) {
                String cites = city.getString(i);
                employee.setCites(cites);
            }
            JSONObject propety = jsonObjectParse.getJSONObject("properties");

            Properties properties = new Properties();
            properties.setAge(propety.getString("age"));
            properties.setSalary(propety.getString("salary"));

            employee.setProperties(properties);
            Log.d("EmpParseData", employee.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    class Employee {

        public Employee() {
        }

        int empId;
        String name;
        String permanent;
        String role;
        Address address;
        long[] phoneNumber;

        public long[] getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(long[] phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        String cites;

        public String getCites() {
            return cites;
        }

        public void setCites(String cites) {
            this.cites = cites;
        }

        Properties properties;

        public int getEmpId() {
            return empId;
        }


        public void setEmpId(int empId) {
            this.empId = empId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPermanent() {
            return permanent;
        }

        public void setPermanent(String permanent) {
            this.permanent = permanent;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }



        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empId=" + empId +
                    ", name='" + name + '\'' +
                    ", permanent='" + permanent + '\'' +
                    ", role='" + role + '\'' +
                    ", address=" + address +
                    ", phoneNumber=" + phoneNumber +
                    ", cites='" + cites + '\'' +
                    ", properties=" + properties +
                    '}';
        }
    }


    // formats { [{}] }
    private void createJson() {

        JSONObject jsonObject1 = new JSONObject();
        try {
            jsonObject1.put("id", 110);
            jsonObject1.put("name", "isuraksha");
            jsonObject1.put("address", "pund");
            jsonObject1.put("pin", 411017);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject2 = new JSONObject();
        try {
            jsonObject2.put("id", 111);
            jsonObject2.put("name", "isuraksha");
            jsonObject2.put("address", "pund");
            jsonObject2.put("pin", 411017);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray();

        jsonArray.put(jsonObject1);
        jsonArray.put(jsonObject2);

        JSONObject jsonObject3 = new JSONObject();
        try {
            jsonObject3.put("student", jsonArray);
            Log.d("formatsa", jsonObject3.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObject4 = new JSONObject(String.valueOf(jsonObject3));
            Log.d("jsonObject4", jsonObject4.toString());
            JSONArray jsonArray2 = jsonObject4.getJSONArray("student");
            for (int i = 0; i < jsonArray2.length(); i++) {
                JSONObject jsonObject5 = jsonArray2.getJSONObject(i);

                Students students = new Students();

                students.setId(jsonObject5.getInt("id"));
                students.setName(jsonObject5.getString("name"));
                students.setAddress(jsonObject5.getString("address"));
                students.setPin(jsonObject5.getInt("pin"));
                Log.d("showobject", students.toString());
                arraylist.add(students);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

class Students {

    int id;
    String name;
    String address;
    int pin;

    public Students() {

    }

    public Students(int id, String name, String address, int pin) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pin = pin;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}

class CustomJsonArrayAdapter extends BaseAdapter {

    Context context;
    ArrayList<Students> arraylist;

    public CustomJsonArrayAdapter(Context context, ArrayList<Students> arraylist) {
        this.context = context;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.json_item_layout, parent, false);
        TextView id = (TextView) view.findViewById(R.id.json_id);
        TextView name = (TextView) view.findViewById(R.id.json_name);
        TextView address = (TextView) view.findViewById(R.id.json_address);
        TextView pin = (TextView) view.findViewById(R.id.json_pin);

        Students studObje = arraylist.get(position);
        id.setText(String.valueOf(studObje.getId()));
        name.setText(studObje.getName());
        address.setText(studObje.getAddress());
        pin.setText(String.valueOf(studObje.getPin()));
        return view;
    }
}

class Address {
    String street;
    String city;
    long zipcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}

class Properties {
    String age;
    String salary;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}