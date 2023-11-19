<%@ page import="vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.ProductServices" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Product" %>
<%@ page import="vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.EmployeeServices" %>
<%@ page import="vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Quản lý sản phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            font-size: 16px;
            line-height: 1.6;
            color: #333;
        }

        .table-container {
            margin-top: 50px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f5f5f5;
        }

        th a {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }

        th a:hover {
            text-decoration: underline;
        }

        td a {
            color: #333;
            text-decoration: none;
            margin-right: 10px;
        }

        td a:hover {
            color: #007bff;
        }
    </style>
</head>
<body>
<%
    EmployeeServices employeeServices = new EmployeeServices();
    List<Employee> lst = employeeServices.getActiveEmployee();
    System.out.println(lst.size());
%>
<h2 style="text-align: center; margin-bottom: 20px;">Danh Sách Các Nhân viên</h2>
<div class="container table-container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Address</th>
            <th>Date of Birth</th>
            <th>Email</th>
            <th>Full Name</th>
            <th>Phone</th>
            <th>Status</th>
            <th colspan="2"><a href="insertProduct.jsp">Thêm Nhân Viên</a></th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Employee e : lst) {
                long id = e.getId();
                String delete = "UpdateProduct?action=delete&id=" + id;
        %>
        <tr>
            <td><%=id%></td>
            <td><%=e.getAddress()%></td>
            <td><%=e.getDob()%></td>
            <td><%=e.getEmail()%></td>
            <td><%=e.getFullName()%></td>
            <td><%=e.getPhone()%></td>
            <td><%=e.getStatus()%></td>
            <td style="color: firebrick !important;"><a href=<%=delete%>>Xóa</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
