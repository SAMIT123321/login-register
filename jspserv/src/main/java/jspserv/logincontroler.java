package jspserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logincontroler
 */
@WebServlet("/logincontroler")
public class logincontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public logincontroler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		PrintWriter pwr =res.getWriter();
//		html setup
		res.setContentType("text/html");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
//		int id =Integer.parseInt(req.getParameter("id"));
		
		
		
		
//		response.getWriter().println(request.getParameter("name"));
		
		try {
			String find ="SELECT * FROM two.user where name=? and password=?;";
//			SELECT * FROM two.user where name="web" and password="5";
			
			
//			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/two","root","root");
//			Statement smt=con.createStatement();
//			smt.executeUpdate(create);
			PreparedStatement pr=con.prepareStatement(find);
//	        pr.setInt(1,id);
	        pr.setString(1, name);
	        pr.setString(2, password);
	      
//	    pr.executeUpdate();
	    ResultSet rs=pr.executeQuery();
//	    rs.next();
	    
//	    
	    if(rs.next()) {
	    	String oname=rs.getString("name");
	    	pwr.print("I am login name : "+oname);

	    	
	    }
	    else {
	    	pwr.print("wrong input");
	    }
	    
	    
	    con.close();
      
	        
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
