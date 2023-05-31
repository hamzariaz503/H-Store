<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>ADDING</title>
</head>
<body>
    <center>
        <form  method="post" action="addproduct">
            ID : <input type="text" name = "id" placeholder="input id">
            <br> <br>
            Name : <input type="text" name = "name" placeholder="input product-name">
            <br> <br>
            Quantity : <input type="text" name = "quantity" placeholder="input product quantity">
            <br> <br>
            Price : <input type="text" name = "price" placeholder="input unit price">
            <br> <br>
            <input type="submit" value="Add to inventory">
        </form>
    </center>
</body>
</html>