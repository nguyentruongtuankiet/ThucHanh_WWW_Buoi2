<%@ page import="vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories.ProductReponsitory" %>
<%@ page import="vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.ProductImage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Product</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Unit</th>
        <th>Manufacturer</th>
        <th>Status</th>
        <th>Images</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${products}" var="product">
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.unit}</td>
        <td>${product.manufacturerName}</td>
        <td>${product.status}</td>
        <td>
            <ul>
                <c:forEach items="${product.productImageList}" var="image">
                    <li>
                        <img src="${image.path}" alt="${image.alternative}">
                    </li>
                </c:forEach>
            </ul>
        </td>
    </tr>
    </c:forEach>


    </tbody>
</table>
</body>
</html>