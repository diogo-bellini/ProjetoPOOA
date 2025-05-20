<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>

<form action="login" method="post">
    <label for="email">Email:</label><br>
    <input type="text" id="email" name="email" required><br><br>

    <label for="senha">Senha:</label><br>
    <input type="password" id="senha" name="senha" required><br><br>

    <input type="submit" value="Entrar">
    <a href="registrar.jsp">Registrar-se</a>
</form>
</body>
</html>
