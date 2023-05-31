import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Update extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session=request.getSession(false);
    PrintWriter out = response.getWriter();
    if(session!=null)
    {
      response.sendRedirect("updateform.jsp");
    }

    else
    {
      out.println("<h1>not logged in :</h1>");
      request.getRequestDispatcher("login.html").include(request, response);
    }
    
  }

}
