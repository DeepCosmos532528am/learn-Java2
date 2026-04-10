<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Login Success</title>
</head>
<body>

<h2>User Details</h2>
<p>Full Name: ${username}</p> <!--Listen to use this JS like syntax $ {...} retrieve the value, I would have to first setAttribute in the Servlet which is redirecting to this .jsp file -->
<p>Email: ${email}</p>
<p>Password: ${password}</p>
<p>Interest: ${interest}</p>
<p>gender: ${gender}</p>



<div style="display: flex; justify-content: center; align-items: center;"> <h1 style="background-color: greenyellow; padding: 20px; border-radius: 20px">User Login Successful</h1> <h1>Welcom ${username}</h1></div>
</body>
</html>