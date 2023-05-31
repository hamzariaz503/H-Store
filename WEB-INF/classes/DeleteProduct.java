import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class DeleteProduct extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
  HttpSession session=request.getSession(false);
	response.setContentType("text/html");
    
	// get PrintWriter object
	PrintWriter out = response.getWriter();
  if(session!=null)
  {
    
    String name=request.getParameter("name");
    boolean b = InventoryDAO.delete(name);

    if(b)
    {
            out.println("<h1>Product deleted<h1>");
    }
    else
    {
        out.println("<html><head><title>Response</title></head><body><h1>Product not found</h1></body></html>");
    }

  }
  else
    {
      out.println("<h1>not logged in :</h1>");
      request.getRequestDispatcher("login.HTML").include(request, response);
    }

    
    

    
  }

}
