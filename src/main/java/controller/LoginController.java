package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Usuario;
import service.LoginService;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/"})
public class LoginController extends HttpServlet {
    private LoginService loginService;

    @Override
    public void init() {
        loginService = new LoginService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = loginService.autenticar(email, senha);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            switch (usuario.getPapel()) {
                case MEDICO:
                    response.sendRedirect("medico.jsp");
                    break;
                case PACIENTE:
                    response.sendRedirect("paciente.jsp");
                    break;
                case ADMIN:
                    response.sendRedirect("admin.jsp");
                    break;
                default:
                    response.sendRedirect("erro.jsp");
            }
        } else {
            request.setAttribute("erro", "Email ou senha inválidos.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
