package com.dave.roomdbsample.dbtable;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Dave on 28-03-2018.
 */

@Entity(tableName = "employee")
public class Employee {
    private String name;
    private String address;

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

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

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
