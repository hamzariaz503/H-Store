import java.sql.*;
import java.util.*;
import javax.swing.*;

public class InventoryDAO{
    public static InventoryInfo search(String n)
    {
        InventoryInfo i = null;
        try {
                Class.forName("com.mysql.jdbc.Driver");

                String url = "jdbc:mysql://127.0.0.1/student";

                Connection con=DriverManager.getConnection(url,"root","root");

                Statement st=con.createStatement();
            
                String query="SELECT * FROM inventory WHERE name='" + n + "'  ";
        
                ResultSet rs = st.executeQuery(query);

                if (rs.next( ) ) {
                    System.out.println("record found");
                String id = rs.getString("id");
                String name = rs.getString("name");
                String quantity = rs.getString("quantity");
                String price = rs.getString("price");
                
                i = new InventoryInfo(id, name, quantity , price );}
                con.close();
            }

    catch(Exception ex)
    {
    System.out.println(ex);
}

    return i;

    }

public static boolean addproduct(InventoryInfo i1){
    boolean b = false;

	try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/student";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();


     
     String query = "INSERT INTO inventory(id,name,quantity,price) VALUES('"+ i1.id + "','" + i1.name + "','" + i1.quantity + "','" + i1.price + "') ";
      int rs = st.executeUpdate( query );
      
     if(rs==1){	 System.out.println("record found");
		b = true;		}
	else{	
        System.out.println("record not found");	
		b = false;
    	}



    }

catch(Exception ex)
{
    System.out.println(ex);
}

 return b;
}

public static boolean delete(String n)
{
    boolean b = false;
    try
    {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1/student";

        Connection con=DriverManager.getConnection(url, "root", "root");

        Statement st=con.createStatement();

        String query="Delete from inventory where name ='" + n + "'  ";

        int rs = st.executeUpdate(query);

        if (rs==1 )
         {
            b = true;
        }

        else
        {
            b = false;
        }
        con.close();
    }


    catch(Exception ex)
    {
    System.out.println(ex);
}
    return b;
}
public static boolean updateproduct(InventoryInfo i1 , InventoryInfo i2)
    {
        boolean b = false;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1/student";

            Connection con=DriverManager.getConnection(url, "root", "root");

            Statement st=con.createStatement();
            String p = i1.price  ;
            String n = i1.name;
            String q=i1.quantity;


            
            String query = "Update inventory set quantity='" + q + "' , price = '"  + p + "' where name = '" + n + "' ";

            int rs = st.executeUpdate( query );

            if(rs==1)
            {
            b = true;
                    	
        }
            else
            {
        	b = false;
        	}

            System.out.println(b);
            

        }

        catch(Exception ex)
        {
        System.out.println(ex);
    }
        return b;

    }
    

}