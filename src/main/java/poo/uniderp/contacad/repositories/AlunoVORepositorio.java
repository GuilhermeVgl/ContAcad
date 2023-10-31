package poo.uniderp.contacad.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import poo.uniderp.contacad.DatabaseConnection;
import poo.uniderp.contacad.domain.AlunoVO;

public class AlunoVORepositorio {
    Connection connection = null;

    public ArrayList<AlunoVO> listarAlunos() {

        ArrayList<AlunoVO> alunos = new ArrayList<>();
        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/ContAcad", "postgres", "postgres");
            ResultSet rs = conexao.createStatement().executeQuery("SELECT * FROM Aluno");

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                Date dataNascimento = rs.getDate("dataNascimento");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                int periodo = rs.getInt("periodo");
                alunos.add(new AlunoVO(codigo, nome, dataNascimento, usuario, senha, periodo));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return alunos;
    }

}