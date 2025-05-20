<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuário</title>
</head>
<body>
<h2>Registrar novo usuário</h2>

<form action="registro" method="post">
    <label for="nome">Nome:</label><br>
    <input type="text" id="nome" name="nome" required><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" required><br><br>

    <label for="senha">Senha:</label><br>
    <input type="password" id="senha" name="senha" required><br><br>

    <label for="medico">Médico:</label><br>
    <input type="radio" id="medico" name="papel" value="Medico"><br><br>

    <label for="paciente">Paciente:</label><br>
    <input type="radio" id="paciente" name="papel" value="Paciente"><br><br>

    <input type="submit" value="Registrar">
</form>

<p>Já tem conta? <a href="index.jsp">Fazer login</a></p>
</body>
</html>

