<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuário</title>
    <script>
        function toggleEspecialidade() {
            const papelMedico = document.getElementById('medico').checked;
            document.getElementById('especialidadeDiv').style.display = papelMedico ? 'block' : 'none';
        }
    </script>
</head>
<body>
<h2>Registrar</h2>

<form action="registrar" method="post">
    <label for="nome">Nome:</label><br>
    <input type="text" id="nome" name="nome" required><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" required><br><br>

    <label for="senha">Senha:</label><br>
    <input type="password" id="senha" name="senha" required><br><br>

    <label><input type="radio" id="medico" name="papel" value="MEDICO" onclick="toggleEspecialidade()"> Médico</label><br>
    <label><input type="radio" id="paciente" name="papel" value="PACIENTE" onclick="toggleEspecialidade()"> Paciente</label><br><br>

    <div id="especialidadeDiv" style="display:none;">
        <label for="especialidade">Especialidade:</label><br>
        <input type="text" id="especialidade" name="especialidade"><br><br>
    </div>

    <input type="submit" value="Registrar">
</form>

<p>Já tem conta? <a href="index.jsp">Fazer login</a></p>
</body>
</html>
