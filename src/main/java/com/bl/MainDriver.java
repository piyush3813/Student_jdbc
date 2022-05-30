package com.bl;

import com.bl.controller.UserController;



import java.sql.SQLException;

import java.util.Scanner;

public class MainDriver extends UserController {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int z = 1;
        do {
            try {
                access();
                System.out.println("for continue press 1");
                System.out.println("for exit press 0");
                 z = sc.nextInt();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }while (z!=0);
    }


}
