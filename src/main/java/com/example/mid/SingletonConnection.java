package com.example.mid;

import java.sql.Connection;
import java.sql.DriverManager;
public class SingletonConnection {
    public static Connection cnnx;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnnx = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mid", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        public static Connection getConnection () {
            return cnnx;
        }
    }