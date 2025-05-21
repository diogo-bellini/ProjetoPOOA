package service;

import dao.UsuarioDAO;
import model.Medico;
import model.Paciente;
import model.Papel;
import model.Usuario;

public class RegistrarService {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean registrarUsuario(String nome, String email, String senha, String papelStr, String especialidade) {
        Papel papel;
        try {
            papel = Papel.valueOf(papelStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            return false;
        }

        Usuario usuario;

        switch (papel) {
            case MEDICO:
                if (especialidade == null || especialidade.trim().isEmpty()) {
                    return false;
                }
                usuario = new Medico(0, nome, email, senha, papel, especialidade);
                break;

            case PACIENTE:
                usuario = new Paciente(0, nome, email, senha, papel, null);
                break;

            default:
                return false;
        }

        return usuarioDAO.inserirUsuario(usuario);
    }
}
