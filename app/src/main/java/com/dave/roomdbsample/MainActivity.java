package com.dave.roomdbsample;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dave.roomdbsample.dao.EmployeeDAO;
import com.dave.roomdbsample.dbtable.Employee;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvFirst, tvList, tvResult, tvInsert;
    EmployeeDAO employeeDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "db-contacts")
                .allowMainThreadQueries()   //Allows room to do operation on main thread
                .build();

        employeeDAO = database.getEmployeeDAO();


        tvFirst.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Employee employee = employeeDAO.getEmployee("1");
                tvResult.setText(employee.getId() + " " + employee.getName() + " " + employee.getAddress());
            }
        });
        tvList.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                //Fetching all contacts
                List<Employee> contactList = employeeDAO.getEmployees();
                tvResult.setText("");
                for (Employee emp : contactList) {
                    tvResult.append(emp.getId() + " " + emp.getName() + " " + emp.getAddress() + "\n");
                }
            }
        });
        tvInsert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                //Inserting a contact
                Employee employee = new Employee();
                employee.setName("Gurleen");
                employee.setAddress("Punjab");
                employeeDAO.insert(employee);
            }
        });
    }

    private void initUI() {
        tvInsert = findViewById(R.id.tvInsert);
        tvFirst = findViewById(R.id.tvFirst);
        tvList = findViewById(R.id.tvList);
        tvResult = findViewById(R.id.tvResult);
    }
}
