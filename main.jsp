<!DOCTYPE html>
<%@ page session="false" %>
    <% HttpSession session=request.getSession(false); 
    if(session==null)
     { response.sendRedirect("login.html"); 
    }
      %>

        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
            <title>Main page</title>
        </head>

        <body>
            <center>

            <form method="post" action="Add">
                <input type="submit" value="Add item">
            </form>
            <br>
            <form method="post" action="DeleteProduct">
                Product name: <input type="text" name="name">
                <input type="submit" value="Delete item">
            </form>
            <br>
            <form method="post" action="Update">
                <input type="submit" value="Update item">
            </form>
            <br>
            <form method="get" action="ViewRecords">
                <input type="submit" value="View Records">
            </form>
            <br>
        
                <form method="post" action="Logout">
                    <input type="submit" value="Logout">
                </form>
            </center>
        
        </body>

        </html>