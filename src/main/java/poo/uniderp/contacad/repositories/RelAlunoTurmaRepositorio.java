package poo.uniderp.contacad.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.uniderp.contacad.DatabaseConnection;
import poo.uniderp.contacad.domain.RelAlunoTurma;

public class RelAlunoTurmaRepositorio {

    Connection conexao = null;

    public ArrayList<RelAlunoTurma> listarAlunosTurma(Integer codigoTurma) {

        ArrayList<RelAlunoTurma> alunosTurma = new ArrayList<>();

        try {
            conexao = DatabaseConnection.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM RelAlunoTurma WHERE turmaCodigo = ?");

            statement.setInt(1, codigoTurma);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int alunoCodigo = rs.getInt("alunoCodigo");
                int turmaCodigo = rs.getInt("turmaCodigo");
                alunosTurma.add(new RelAlunoTurma(codigo, alunoCodigo, turmaCodigo));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conexao);
        }
        return alunosTurma;
    }

    public RelAlunoTurma getTurmaAluno(Integer codigoAluno) {

        RelAlunoTurma turmaAluno = new RelAlunoTurma();

        try {
            conexao = DatabaseConnection.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM RelAlunoTurma WHERE alunoCodigo = ?");

            statement.setInt(1, codigoAluno);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int alunoCodigo = rs.getInt("alunoCodigo");
                int turmaCodigo = rs.getInt("turmaCodigo");
                turmaAluno = new RelAlunoTurma(codigo, alunoCodigo, turmaCodigo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conexao);
        }
        return turmaAluno;
    }

}