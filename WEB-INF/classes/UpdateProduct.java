import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class UpdateProduct extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  

  HttpSession session=request.getSession(false);
	response.setContentType("text/html");
    
	// get PrintWriter object
	PrintWriter out = response.getWriter();

  if(session!=null)
  {
    String id=request.getParameter("id");
    String name=request.getParameter("name");
    String quantity= request.getParameter("quantity");
    String price= request.getParameter("price");
    InventoryInfo i1 = new InventoryInfo(id,name,quantity,price);
    InventoryInfo i2 = new InventoryInfo();
    i2 = InventoryDAO.search(name);
    boolean b = InventoryDAO.updateproduct(i1,i2);
    response.sendRedirect("main.jsp");
  }

  else
    {
      out.println("<h1>not logged in :</h1>");
      request.getRequestDispatcher("login.html").include(request, response);
    }

    
  }


}
