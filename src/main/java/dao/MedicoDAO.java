package dao;

import model.Medico;
import model.Papel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO extends GenericDAO {

    public List<Medico> buscarPorEspecialidade(String especialidade) {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM Usuario WHERE papel = 'MEDICO' AND especialidade = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, especialidade);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String esp = rs.getString("especialidade");

                Medico medico = new Medico(id, nome, email, senha, Papel.MEDICO, esp);
                medicos.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicos;
    }

    public boolean atualizarEspecialidade(int medicoId, String novaEspecialidade) {
        String sql = "UPDATE Usuario SET especialidade = ? WHERE id = ? AND papel = 'MEDICO'";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novaEspecialidade);
            stmt.setInt(2, medicoId);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
