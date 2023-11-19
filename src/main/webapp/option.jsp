<%@ page import="vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories.ProductReponsitory" %>
<%@ page import="vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.ProductImage" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Index</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    body {
      font-family: Arial, sans-serif; /* Đặt font chữ */
      font-size: 16px;
      line-height: 1.6;
      color: #333;
      margin: 0;
      padding: 0;
      background-color: #f0f0f0;
      text-align: center;
    }

    .link-container {
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-items: center;
      margin-top: 20px; /* Khoảng cách từ phần trên cùng của màn hình */
    }

    .link-container a {
      text-decoration: none;
      color: #007bff;
      font-size: 20px;
      margin: 10px;
      border: 1px solid #ccc; /* Đóng khung */
      padding: 10px 20px; /* Khoảng cách nội dung từ khung */
      border-radius: 5px; /* Bo góc */
      transition: all 0.3s ease; /* Hiệu ứng chuyển đổi */
    }

    .link-container a:hover {
      color: #0056b3;
      font-weight: bold;
      background-color: #f0f0f0; /* Màu nền khi hover */
    }
    h2{
      justify-content: center;
      align-items: center;
      margin-top: 250px; /* Khoảng cách từ phần dưới cùng của tiêu đề */
    }

  </style>
</head>
<body>
<h2>Mời bạn lựa chọn:</h2>
<div class="link-container">
  <a href="pageEmployee.jsp">Quản Lý Nhân Viên</a>
  <a href="CRUDProduct.jsp">Quản Lý Sản Phẩm</a>
  <a href="pageProduct.jsp">Danh Sách Sản Phẩm</a>
</div>
</body>
</html>


