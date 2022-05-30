package com.bl.controller;

import com.bl.model.Student;
import com.bl.serviceimplementation.DatabaseAccessClass;
import com.bl.validation.Validation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserController {
    static Scanner sc = new Scanner(System.in);
    static DatabaseAccessClass dac = new DatabaseAccessClass();

    public static void access() throws SQLException {
        System.out.println("======enter your choice=======");
        System.out.println("1.add student to database");
        System.out.println("2.read single student data from database");
        System.out.println("3.read all  studentdata from database");
        System.out.println("4.update student to database");
        System.out.println("5.delete student from database");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("you want to add student");
//                Student stu = new Student();
                System.out.println("enter name");

                String nam = sc.next();

//                stu.setStu_name(nam);
                System.out.println("enter address");
                String add = sc.next();
//                stu.setStu_address(add);

                if(Validation.validateName(nam)){
                    Student st = new Student(nam,add);
                    dac.add(st);
                }

                break;
            case 2:
                System.out.println("you have selected to read specific data");
                System.out.println("enter id you want data for");
                int i = sc.nextInt();
                Student s = dac.getStudent(i);
                System.out.println(s.getStu_id() + " " + s.getStu_name() + " " + s.getStu_address());
                break;

            case 3:
                System.out.println("you have entered to show all data ");
                List<Student> ls = dac.getStudents();
                for (Student allStu : ls) {
                    System.out.println(allStu);
                }
                break;
            case 4:
                System.out.println("you want to update the data");
                System.out.println("enter student id you want to update for");
                int id = sc.nextInt();
                Student stu2 = dac.getStudent(id);
                System.out.println("what you want to update");
                System.out.println("1.name");
                System.out.println("2.address");
                System.out.println("3.name & address both");

                int cho = sc.nextInt();
                switch (cho) {
                    case 1:
                        System.out.println("you want to update name");
                        System.out.println("enter name");
                        String nameUp = sc.next();
                        stu2.setStu_name(nameUp);
                        dac.update(stu2);
                        break;
                    case 2:
                        System.out.println("you want to update address");
                        System.out.println("enter address");
                        String addUp = sc.next();
                        stu2.setStu_address(addUp);
                        dac.update(stu2);
                        break;
                    case 3:
                        System.out.println("you want to update name");
                        System.out.println("enter name");
                        nameUp = sc.next();
                        stu2.setStu_name(nameUp);
                        System.out.println("you want to update address");
                        System.out.println("enter address");
                        addUp = sc.next();
                        stu2.setStu_address(addUp);
                        dac.update(stu2);
                        break;
                }
                break;

            case 5:
                System.out.println("you have entered to delete the data");
                System.out.println("enter the id you want to delete");
                int i2 = sc.nextInt();
                dac.delete(i2);
                break;




        }
    }

}
