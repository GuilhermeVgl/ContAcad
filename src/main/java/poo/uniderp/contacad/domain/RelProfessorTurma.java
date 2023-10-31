package poo.uniderp.contacad.domain;

public class RelProfessorTurma implements IImpressao{

    private Integer codigo;
    private Integer professor;
    private Integer turma;

    public RelProfessorTurma(
        Integer codigo,
        Integer professor, 
        Integer turma
        ) 
    {
        this.codigo = codigo;
        this.professor = professor;
        this.turma = turma;
    }

    public Integer getProfessor() {
        return professor;
    }
    public void setProfessor(Integer professor) {
        this.professor = professor;
    }
    public Integer getTurma() {
        return turma;
    }
    public void setTurma(Integer turma) {
        this.turma = turma;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public void Imprimir() {
    }
}
