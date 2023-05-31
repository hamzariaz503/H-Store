import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Signup extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	// get PrintWriter object
	PrintWriter out = response.getWriter();
   
    String p_no=request.getParameter("phone");
    String email=request.getParameter("email");
    String pass=request.getParameter("password");
    
    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");
    if(pass.length() < 8) out.println("lenfth");
    



    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://localhost/student";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();


     
    String query = "INSERT INTO user(p_no,email,password) VALUES('"+ p_no + "','  "  + email + " ','" + pass + "') ";

     System.out.println(query);

      int rs = st.executeUpdate( query );

      if(rs==1){	 out.println("<h1> insertion successful</h1> "); 
      request.getRequestDispatcher("login.html").include(request, response);	
    	}
    else
    {
      	out.println("<h1>Record could not be inserted.</h1>"); 	
  	}
  

     out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e.getStackTrace());
    }

  }

}
