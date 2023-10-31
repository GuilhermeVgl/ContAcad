package poo.uniderp.contacad.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import poo.uniderp.contacad.DatabaseConnection;
import poo.uniderp.contacad.domain.NotaTrabalho;

public class NotaTrabalhoRepositorio {
    Connection conexao = null;

    public NotaTrabalho getNotaTrabalhoAluno(Integer codigoAluno) {

        NotaTrabalho notaAluno = new NotaTrabalho();
        try {
            conexao = DatabaseConnection.getConnection();

            PreparedStatement rs = conexao.prepareStatement(
                """
                SELECT * 
                FROM NotaTrabalho
                WHERE alunoCodigo = ?
                """);

                rs.setInt(1, codigoAluno);

                ResultSet result = rs.executeQuery();

            while (result.next()) {
                int codigo = result.getInt("codigo");
                int alunoCodigo = result.getInt("alunoCodigo");
                int trabalhoCodigo = result.getInt("trabalhoCodigo");
                Double nota = result.getDouble("nota");
                notaAluno = new NotaTrabalho(codigo, alunoCodigo, trabalhoCodigo, nota);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conexao);
        }
        return notaAluno;
    }

}