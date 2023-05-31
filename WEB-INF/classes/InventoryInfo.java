import java.util.*;
import javax.swing.*;


public class InventoryInfo{
String id;
String name;
String quantity;
String price;

InventoryInfo()
{
    id = null;
    name = null;
    quantity = null ;
    price = null;
}

InventoryInfo(String i , String n , String q , String p ) {
id = i;
name = n;
quantity = q;
price = p;
}

public String toString( ){ 
return ("Id : " + id + "Name: " + name + " Quantity: " + quantity + " Price: " + price );
}
}
