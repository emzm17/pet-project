package com.amdocs.petstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	 private static Connection con=null;
	 static
	    {
	        String url = "Jdbc:Oracle:thin:@localhost:1521:orcl";
	        String user = "scott";
	        String pass = "tiger";
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            con = DriverManager.getConnection(url, user, pass);
	        }
	        catch ( SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    public static Connection getConnection()
	    {
	        return con;
	    }
	}
