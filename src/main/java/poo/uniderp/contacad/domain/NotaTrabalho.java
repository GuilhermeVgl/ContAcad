package poo.uniderp.contacad.domain;

public class NotaTrabalho extends BaseDadosComuns{
    
    private Integer aluno;
    private Integer trabalho;
    private Double nota;

    public NotaTrabalho(
        Integer codigo, 
        Integer aluno, 
        Integer trabalho, 
        Double nota
        ) 
    {
        super(codigo);
        this.aluno = aluno;
        this.trabalho = trabalho;
        this.nota = nota;
    }

    public NotaTrabalho () {}
    
    public Integer getAluno() {
        return aluno;
    }
    public void setAluno(Integer aluno) {
        this.aluno = aluno;
    }
    public Integer getTrabalho() {
        return trabalho;
    }
    public void setTrabalho(Integer trabalho) {
        this.trabalho = trabalho;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }
}
