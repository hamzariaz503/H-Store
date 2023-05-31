import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class ViewRecords extends HttpServlet {
  
  //Process the HTTP Get request
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
  	// get PrintWriter object
	PrintWriter out = response.getWriter();
    
 HttpSession Sess= request.getSession(false);
  if(Sess==null)
  {
    response.sendRedirect("login.html");
    return;
  }
  String g= (String)Sess.getAttribute("email");
  String f=(String)Sess.getAttribute("password" );
     


    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/student";

    Connection con=DriverManager.getConnection(url, "root", "root");


     String query="SELECT * FROM inventory ";
  
     Statement st=con.createStatement();
    
     ResultSet rs = st.executeQuery(query);
     ResultSetMetaData rmsd = rs.getMetaData();
     out.println("<h1 style=font-family:calibri> All records</h1> <br><br> ");
    out.println("<table border = '1' style=font-size:30px>");
    out.println("<tr>");
    int columns = rmsd.getColumnCount();
    String cName;
    for (int i=1; i <= columns; i++)
    {
        cName = rmsd.getColumnName(i);
        out.println("<th>" + cName +"</th>");
    }
    out.println("</tr>");
  
   
     while(rs.next()){
             int id= rs.getInt("id");
            String name= rs.getString("name");
            int  quantity= rs.getInt("quantity");
            int price= rs.getInt("price");
            out.println("<tr>");
            out.println("<td>" + id + "</td>");
            out.println("<td>" + name + "</td>");
            out.println("<td>" + quantity + "</td>");
            out.println("<td>" + price+ "</td>");
            out.println("</tr>");
            }
            out.println("</table>");
      

     out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e)
    
    {

      out.println(e);
    }

  }

}
