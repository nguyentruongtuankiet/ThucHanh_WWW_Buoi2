<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Thêm sản phẩm</h2>
    <form action="UpdateProduct" method="post">
        <div class="form-group">
            <label for="name">Tên sản phẩm:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="description">Mô tả:</label>
            <textarea class="form-control" id="description" name="description" required></textarea>
        </div>
        <div class="form-group">
            <label for="unit">Đơn vị:</label>
            <input type="text" class="form-control" id="unit" name="unit" required>
        </div>
        <div class="form-group">
            <label for="manufacturerName">Tên nhà sản xuất:</label>
            <input type="text" class="form-control" id="manufacturerName" name="manufacturerName" required>
        </div>
        <div class="form-group">
            <label for="status">Trạng thái:</label>
            <select class="form-control" id="status" name="status" required>
                <option value="1">Hoạt động</option>
                <option value="0">Ngừng hoạt động</option>
            </select>
        </div>
        <input type="hidden" name="action" value="add">
        <button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
    </form>
    <br>
    <a href="CRUDProduct.jsp">Quay lại</a>
</div>
</body>
</html>