package poo.uniderp.contacad.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.uniderp.contacad.DatabaseConnection;
import poo.uniderp.contacad.domain.RelProfessorTurma;

public class RelProfessorTurmaRepositorio {

    Connection conexao = null;

    public ArrayList<RelProfessorTurma> listarRelacionamentos() {

        ArrayList<RelProfessorTurma> relacionamentos = new ArrayList<>();

        try {
            conexao = DatabaseConnection.getConnection();
            ResultSet rs = conexao.createStatement().executeQuery("SELECT * FROM RelProfessorTurma");

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int professorCodigo = rs.getInt("professorCodigo");
                int turmaCodigo = rs.getInt("turmaCodigo");
                relacionamentos.add(new RelProfessorTurma(codigo, professorCodigo, turmaCodigo));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conexao);
        }
        return relacionamentos;
    }

    public ArrayList<RelProfessorTurma> listarTurmasProfessor(Integer professorCodigo) {
        ArrayList<RelProfessorTurma> relacionamentos = new ArrayList<>();

        try {
            conexao = DatabaseConnection.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM RelProfessorTurma WHERE professorCodigo = ?");

            statement.setInt(1, professorCodigo);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int codigoProfessor = rs.getInt("professorCodigo");
                int turmaCodigo = rs.getInt("turmaCodigo");
                relacionamentos.add(new RelProfessorTurma(codigo, codigoProfessor, turmaCodigo));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conexao);
        }
        return relacionamentos;
    }

}