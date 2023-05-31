import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Login extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();

    String email=request.getParameter("email");
    String pass=request.getParameter("password");
    
    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");


    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://localhost/student";

    Connection con=DriverManager.getConnection(url,"root","root");

    Statement st=con.createStatement();
    
    String query="SELECT * FROM user WHERE( email='"+email+"' ) AND password ='"+pass+"'  ";
   
   
     ResultSet rs = st.executeQuery( query );   
     if(rs.next())
     {
    
        HttpSession session=request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("password", pass);
        session.setAttribute("type", rs.getString("type"));
        if(rs.getString("type").equals("admin")) response.sendRedirect("Admin.jsp");
        else{
          response.sendRedirect("User.jsp");
        }
        out.println("Successfully login  as " + rs.getString("type"));
	   }
     
     else
     {
      out.println(query);
      out.println("<h1>login credentials incorrect</h1>");
      out.println("<h1>login again</h1>");
      request.getRequestDispatcher("login.html").include(request, response);
     }


        out.println("</body></html>");
           st.close();
           con.close();

    }
    
    
    catch(Exception e)
    {

      out.println(e.getMessage());
    }

  }

}