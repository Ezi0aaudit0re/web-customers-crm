package com.project.testDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        // setup connection variable
        String user = "springstudent";
        String pass = "springstudent";

        String jdurl = "jdbc:,ysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";

        String driver = "com.mysql.jdbc.Driver";

        // get connection to database

        try{

            PrintWriter out = response.getWriter();
            out.println("Connectoing to database: " + jdurl);

            Connection connection = DriverManager.getConnection(jdurl, user, pass);

            out.println("Success !!");

            connection.close();

        }
        catch (Exception exc){
            exc.printStackTrace();
            throw new ServletException(exc);
        }


    }

}
