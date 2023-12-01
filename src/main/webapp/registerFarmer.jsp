<!-- register.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Registration Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #d1e0e0;
        }

        .container {
            max-width: 600px;
            margin-top: 50px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Registration Form</h2>
    <form action=RegisterServlet method="post">
        <!-- Personal Details -->
        <h4>Personal Details</h4>
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" id="firstName" name="firstName" required>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" class="form-control" id="lastName" name="lastName" required>
        </div>
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>

        <!-- Address -->
        <h4>Address</h4>
        <div class="form-group">
            <label for="doorNo">Door No:</label>
            <input type="text" class="form-control" id="doorNo" name="doorNo" required>
        </div>
        <div class="form-group">
            <label for="street">Street:</label>
            <input type="text" class="form-control" id="street" name="street" required>
        </div>
        <div class="form-group">
            <label for="city">City:</label>
            <input type="text" class="form-control" id="city" name="city" required>
        </div>
        <div class="form-group">
            <label for="state">State:</label>
            <input type="text" class="form-control" id="state" name="state" required>
        </div>
        <div class="form-group">
            <label for="postalCode">Postal Code:</label>
            <input type="text" class="form-control" id="postalCode" name="postalCode" required>
        </div>

        <!-- Other Info -->
        <h4>Other Info</h4>
        <div class="form-group">
            <label for="otherInfo">Other Info:</label>
            <textarea class="form-control" id="otherInfo" name="otherInfo" rows="3"></textarea>
        </div>

        <!-- Land Details -->
        <h4>Land Details</h4>
        <div class="form-group">
            <label for="size">Size:</label>
            <input type="text" class="form-control" id="size" name="size" required>
        </div>
        <div class="form-group">
            <label for="type">Type:</label>
            <input type="text" class="form-control" id="type" name="type" required>
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <input type="text" class="form-control" id="status" name="status" required>
        </div>
        <div class="form-group">
            <label for="location">Location:</label>
            <input type="text" class="form-control" id="location" name="location" required>
        </div>

        <button type="submit" class="btn btn-primary">Register</button>
        <button type="reset" class="btn btn-secondary">Reset</button>
    </form>
    
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
