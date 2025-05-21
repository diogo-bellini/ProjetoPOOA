package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.RegistrarService;

import java.io.IOException;

@WebServlet("/registrar")
public class RegistrarController extends HttpServlet {

    private RegistrarService registrarService = new RegistrarService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String papel = req.getParameter("papel");
        String especialidade = req.getParameter("especialidade");

        boolean sucesso = registrarService.registrarUsuario(nome, email, senha, papel, especialidade);

        if (sucesso) {
            resp.sendRedirect("index.jsp?msg=Cadastro realizado com sucesso!");
        } else {
            resp.sendRedirect("registrar.jsp?error=Erro ao cadastrar usuário");
        }
    }
}
