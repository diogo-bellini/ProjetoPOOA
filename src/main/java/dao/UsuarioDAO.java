package dao;

import model.*;

import java.sql.*;

public class UsuarioDAO extends GenericDAO {

    public Usuario buscarPorEmailESenha(String email, String senha) {
        String sql = "SELECT * FROM Usuario WHERE email = ? AND senha = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return montarUsuario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nome, email, senha, papel, especialidade) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getPapel().name());

            if (usuario instanceof Medico) {
                stmt.setString(5, ((Medico) usuario).getEspecialidade());
            } else {
                stmt.setNull(5, Types.VARCHAR);
            }

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                return false;
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setId(generatedKeys.getInt(1));
                }
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM Usuario WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return montarUsuario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuario SET nome = ?, email = ?, senha = ?, papel = ?, especialidade = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getPapel().toDatabaseValue());


            if (usuario instanceof Medico) {
                stmt.setString(5, ((Medico) usuario).getEspecialidade());
            } else {
                stmt.setNull(5, Types.VARCHAR);
            }

            stmt.setInt(6, usuario.getId());

            int affectedRows = stmt.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deletarUsuario(int id) {
        String sql = "DELETE FROM Usuario WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int affectedRows = stmt.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private Usuario montarUsuario(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String email = rs.getString("email");
        String senha = rs.getString("senha");
        String papelStr = rs.getString("papel");
        Papel papel = Papel.valueOf(papelStr.toUpperCase());
        String especialidade = rs.getString("especialidade");

        switch (papel) {
            case MEDICO:
                return new Medico(id, nome, email, senha, papel, especialidade);
            case PACIENTE:
                return new Paciente(id, nome, email, senha, papel, null); // consultas podem ser carregadas depois
            case ADMIN:
                return new Admin(id, nome, email, senha, papel);
            default:
                return null;
        }
    }
}
