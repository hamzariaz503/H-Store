 import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Logout extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {

    HttpSession session=request.getSession(false);
    PrintWriter out = response.getWriter();
    if(session!=null)
    {
        session.invalidate();
        response.sendRedirect("login.html");
    }
    
  }

}

