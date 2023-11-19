<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <!-- Link CSS từ Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* CSS tùy chỉnh */
        body {
            background-color: #f8f9fa;
        }

        .login-container {
            margin-top: 100px;
        }

        .card {
            border-radius: 15px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<%
    String error = (String) request.getAttribute("error");
%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 login-container">
            <div class="card">
                <div class="card-body">
                    <h2 class="text-center mb-4">Đăng nhập</h2>
                    <!-- Phần hiển thị thông báo lỗi nếu có -->
                    <% if (error != null) {
                    %>
                    <div class="alert alert-danger" role="alert">
                        <p><%=error%>
                        </p>
                    </div>
                    <%
                        } %>

                    <!-- Form đăng nhập -->
                    <form action="login" method="post">
                        <div class="form-group">
                            <label for="username">Tên người dùng</label>
                            <input type="text" class="form-control" id="username" name="username"
                                   placeholder="Nhập tên người dùng">
                        </div>
                        <div class="form-group">
                            <label for="password">Mật khẩu</label>
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="Nhập mật khẩu">
                        </div>
                        <input type="hidden" name="action" value="users">
                        <button type="submit" class="btn btn-primary btn-block">Đăng nhập</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Script JS từ Bootstrap (đặt ở cuối body để tăng tốc độ tải trang) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
