package poo.uniderp.contacad.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.uniderp.contacad.DatabaseConnection;
import poo.uniderp.contacad.domain.RendimentoEscolar;

public class RendimentoEscolarRepositorio {

    Connection conexao = null;

    public ArrayList<RendimentoEscolar> ReadAll() 
    {
        return null;
    }

    public RendimentoEscolar consultarNotasAluno(Integer codigoAluno) {

        RendimentoEscolar notasAluno = new RendimentoEscolar();

        try {
            conexao = DatabaseConnection.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM rendimentoEscolar where alunocodigo = ?");

            statement.setInt(1, codigoAluno);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int alunoCodigo = rs.getInt("alunoCodigo");
                int turmaCodigo = rs.getInt("turmaCodigo");
                Double primeiraNotaProva = rs.getDouble("primeiraNotaProva");
                Double segundaNotaProva = rs.getDouble("segundaNotaProva");
                Double mediaTrabalhos = rs.getDouble("mediaTrabalhos");
                Double mediaGeralAluno = rs.getDouble("mediaGeralAluno");
                notasAluno = new RendimentoEscolar(codigo, alunoCodigo, turmaCodigo, primeiraNotaProva, segundaNotaProva, mediaTrabalhos, mediaGeralAluno);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conexao);
        }
        return notasAluno;
    }

}