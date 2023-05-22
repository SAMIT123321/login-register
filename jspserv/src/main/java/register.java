import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class mm
 */
@WebServlet("/register")
public class register extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mm() {
        super();
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
			String create ="INSERT INTO `two`.`user` (`name`, `password`) VALUES (?,?);";
//			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/two","root","root");
//			Statement smt=con.createStatement();
//			smt.executeUpdate(create);
			PreparedStatement pr=con.prepareStatement(create);
//	        pr.setInt(1,id);
	        pr.setString(1, name);
	        pr.setString(2, password);
	      
//	    pr.executeUpdate();
	    int count=pr.executeUpdate();
	    
	    
	       if(count==1) {
	    	   pwr.print("register successful");
	    	   RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
	    	   rd.forward(req, res);
	       }
	       else {
	    	   pwr.print("try again!!");
	       }
	        
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
