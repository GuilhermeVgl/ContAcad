package poo.uniderp.contacad.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.uniderp.contacad.DatabaseConnection;
import poo.uniderp.contacad.domain.DisciplinaVO;

public class DisciplinaVORepositorio{
    Connection conexao = null;

    public ArrayList<DisciplinaVO> listarDisciplinas() {

        ArrayList<DisciplinaVO> disciplinas = new ArrayList<>();

        try {
            conexao = DatabaseConnection.getConnection();
            ResultSet rs = conexao.createStatement().executeQuery("SELECT * FROM Disciplina");

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String ementa = rs.getString("ementa");
                disciplinas.add(new DisciplinaVO(codigo, nome, ementa));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conexao);
        }
        return disciplinas;
    }

    public DisciplinaVO buscarDisciplinaAluno(Integer codigoAluno) {

        DisciplinaVO disciplina = new DisciplinaVO();

        try {
            conexao = DatabaseConnection.getConnection();
            PreparedStatement rs = conexao.prepareStatement("""
                SELECT dis.* 
                FROM Disciplina AS dis 
                JOIN Turma AS tur ON (dis.codigo = tur.disciplinacodigo)
                JOIN RelAlunoTurma AS aluTur ON (tur.codigo = aluTur.turmacodigo)
                WHERE aluTur.alunoCodigo = ?
                """);

                rs.setInt(1, codigoAluno);

                ResultSet result = rs.executeQuery();

            while (result.next()) {
                int codigo = result.getInt("codigo");
                String nome = result.getString("nome");
                String ementa = result.getString("ementa");
                disciplina = new DisciplinaVO(codigo, nome, ementa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conexao);
        }
        return disciplina;
    }
}