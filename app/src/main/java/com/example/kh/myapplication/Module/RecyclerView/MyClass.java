package com.example.kh.myapplication.Module.RecyclerView;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by kh on 6/23/2017.
 */

public class MyClass implements Parcelable {
    private String name;
    private Date data;

    public MyClass(String name, Date data){
        this.name = name;
        this.data = data;
    }

    public MyClass(Parcel input){
        name  = input.readString();
      data = new java.sql.Date(input.readLong());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(data.getTime());
    }

    public static final Parcelable.Creator<MyClass> CREATOR = new Creator<MyClass>() {
        @Override
        public MyClass createFromParcel(Parcel source) {
            return new MyClass(source);
        }

        @Override
        public MyClass[] newArray(int size) {
            return new MyClass[size];
        }
    };
}
