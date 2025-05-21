package service;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginService {

    private UsuarioDAO usuarioDAO;

    public LoginService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario autenticar(String email, String senha) {
        if (email == null || senha == null || email.isEmpty() || senha.isEmpty()) {
            return null;
        }

        return usuarioDAO.buscarPorEmailESenha(email, senha);
    }
}
