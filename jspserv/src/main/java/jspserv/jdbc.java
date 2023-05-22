package jspserv;

import java.sql.*;

public class jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            String create = "INSERT INTO `two`.`user` (`id`, `name`) VALUES (?,?)";
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/two", "root", "root");
//	            Statement smt = con.createStatement();
//	             smt.executeUpdate(create);
	             PreparedStatement pr=con.prepareStatement(create);
	             pr.setInt(1, 2);
	             pr.setString(2, "jadu");
	            
	             pr.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}


