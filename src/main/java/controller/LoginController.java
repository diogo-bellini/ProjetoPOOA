package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import service.LoginService;

import java.io.IOException;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        LoginService loginService = new LoginService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");


    }
}
