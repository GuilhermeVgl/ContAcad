package poo.uniderp.contacad.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.uniderp.contacad.DatabaseConnection;
import poo.uniderp.contacad.domain.TurmaVO;

public class TurmaVORepositorio{

    Connection conexao = null;

    public ArrayList<TurmaVO> listarTurmas(){
        
                ArrayList<TurmaVO> turmas = new ArrayList<>();

        try {
            conexao = DatabaseConnection.getConnection();
            ResultSet rs = conexao.createStatement().executeQuery("SELECT * FROM Turma");

            while (rs.next()) {
                Integer codigo = rs.getInt("codigo");
                Integer disciplinaCodigo = rs.getInt("disciplinaCodigo");
                Integer professorCodigo = rs.getInt("professorCodigo");
                Integer capacidadeDaTurma = rs.getInt("capacidadeDaTurma");
                turmas.add(new TurmaVO(codigo, disciplinaCodigo, professorCodigo, capacidadeDaTurma));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conexao);
        }
        return turmas;

    }

    public TurmaVO buscarTurma(Integer codigoTurma){
        
        TurmaVO turma = new TurmaVO();

            try {
                conexao = DatabaseConnection.getConnection();

                PreparedStatement statement = conexao.prepareStatement("SELECT * FROM Turma WHERE codigo = ?");

                statement.setInt(1, codigoTurma);

                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    Integer codigo = rs.getInt("codigo");
                    Integer disciplinaCodigo = rs.getInt("disciplinaCodigo");
                    Integer professorCodigo = rs.getInt("professorCodigo");
                    Integer capacidadeDaTurma = rs.getInt("capacidadeDaTurma");
                    turma = new TurmaVO(codigo, disciplinaCodigo, professorCodigo, capacidadeDaTurma);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DatabaseConnection.closeConnection(conexao);
            }
        return turma;

    }
            
}