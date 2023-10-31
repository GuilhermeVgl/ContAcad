package poo.uniderp.contacad.domain;

import java.sql.Date;

public class ProfessorVO extends BasePessoa{
    private String cargo;

    public ProfessorVO(
        Integer codigo, 
        String nome, 
        Date dataNascimento, 
        String usuario, 
        String senha, 
        String cargo
        ) 
    {
        super(codigo, nome, dataNascimento, usuario, senha);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void Imprimir() {
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de Nascimento: " + this.dataNascimento);
        System.out.println("Cargo: " + this.cargo);
        System.out.println(" ");
    }

    public ProfessorVO() {
        
    }
    
}
