<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.crop.model.Crop" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Display Images</title>
</head>
<body>

<h2>List of Images</h2>

<%
    List<Crop> cropList = (List<Crop>) request.getAttribute("cropList");
    if (cropList != null && !cropList.isEmpty()) {
        for (Crop crop : cropList) {
            // Display each image using Base64 encoding
            String base64Image = new String(java.util.Base64.getEncoder().encode(crop.getCropData()), "UTF-8");
%>
            <div>
                <img src="data:image/jpeg;base64, <%= base64Image %>" alt="<%= crop.getCropName() %>" />
                <p><strong><%= crop.getCropName() %></strong></p>
            </div>
<%
        }
    } else {
%>
        <p>No images found.</p>
<%
    }
%>

</body>
</html>
