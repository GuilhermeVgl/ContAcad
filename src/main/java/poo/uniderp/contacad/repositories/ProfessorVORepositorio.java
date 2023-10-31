package poo.uniderp.contacad.repositories;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.uniderp.contacad.DatabaseConnection;
import poo.uniderp.contacad.domain.ProfessorVO;

public class ProfessorVORepositorio{

    Connection connection = null;

    public ArrayList<ProfessorVO> listarProfessores() {

        ArrayList<ProfessorVO> professores = new ArrayList<>();

        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/ContAcad", "postgres", "postgres");
            ResultSet rs = conexao.createStatement().executeQuery("SELECT * FROM Professor");

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                Date dataNascimento = rs.getDate("dataNascimento");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                String cargo = rs.getString("cargo");
                professores.add(new ProfessorVO(codigo, nome, dataNascimento, usuario, senha, cargo));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return professores;
    }

    public ProfessorVO getProfessorByCod(Integer professorCodigo) {

        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/ContAcad", "postgres", "postgres");
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM Professor WHERE codigo = ?");

            statement.setInt(1, professorCodigo);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                Date dataNascimento = rs.getDate("dataNascimento");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                String cargo = rs.getString("cargo");
                ProfessorVO professor = new ProfessorVO(codigo, nome, dataNascimento, usuario, senha, cargo);
                return professor;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return null;
    }
}