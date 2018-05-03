package com.dave.roomdbsample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dave.roomdbsample.dao.EmployeeDAO;
import com.dave.roomdbsample.dbtable.Employee;

/**
 * Created by Dave on 28-03-2018.
 */

@Database(entities = {Employee.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EmployeeDAO getEmployeeDAO();
}
