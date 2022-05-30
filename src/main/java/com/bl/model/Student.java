package com.bl.model;

public class Student {
      int stu_id;
    String stu_name;
    String stu_address;

    public Student(){}

    public Student(String stu_name, String stu_address)
    {
        this.stu_name = stu_name;
        this.stu_address = stu_address;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_address() {
        return stu_address;
    }

    public void setStu_address(String stu_address) {
        this.stu_address = stu_address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_address='" + stu_address + '\'' +
                '}';
    }
}
