package poo.uniderp.contacad.domain;

import java.sql.Date;

public class AlunoVO extends BasePessoa{
    
    private Integer periodo;

    public AlunoVO(
        Integer codigo, 
        String nome, 
        Date dataNascimento, 
        String usuario, 
        String senha, 
        Integer periodo
        ) 
    {
        super(codigo, nome, dataNascimento, usuario, senha);
        this.periodo = periodo;
    }

    public AlunoVO() {}

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    @Override
    public void Imprimir() {
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de Nascimento: " + this.dataNascimento);
        System.out.println("Período: " + this.periodo);
        System.out.println(" ");
    }

}
