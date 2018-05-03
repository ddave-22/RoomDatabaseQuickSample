package com.dave.roomdbsample.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.dave.roomdbsample.dbtable.Employee;

import java.util.List;

/**
 * Created by Dave on 28-03-2018.
 */
@Dao
public interface EmployeeDAO {

    @Insert
    public void insert(Employee... employees);

    @Update
    public void update(Employee... employees);

    @Delete
    public void delete(Employee employee);

    @Query("SELECT * FROM employee")
    public List<Employee> getEmployees();

    @Query("SELECT * FROM employee WHERE id = :number")
    public Employee getEmployee(String number);
}
