package poo.uniderp.contacad;

import java.util.ArrayList;
import java.util.Scanner;

import poo.uniderp.contacad.domain.AlunoVO;
import poo.uniderp.contacad.domain.DisciplinaVO;
import poo.uniderp.contacad.domain.NotaTrabalho;
import poo.uniderp.contacad.domain.ProfessorVO;
import poo.uniderp.contacad.domain.RelAlunoTurma;
import poo.uniderp.contacad.domain.RelProfessorTurma;
import poo.uniderp.contacad.domain.RendimentoEscolar;
import poo.uniderp.contacad.domain.TurmaVO;
import poo.uniderp.contacad.services.AlunoVOService;
import poo.uniderp.contacad.services.DisciplinaVOService;
import poo.uniderp.contacad.services.NotaTrabalhoService;
import poo.uniderp.contacad.services.ProfessorVOService;
import poo.uniderp.contacad.services.RelAlunoTurmaService;
import poo.uniderp.contacad.services.RelProfessorTurmaService;
import poo.uniderp.contacad.services.RendimentoEscolarService;
import poo.uniderp.contacad.services.TurmaVOService;

public class Main {
    public static void main(String[] args) throws Exception {

        String continuar = "";

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println(" ");
            System.out.println("1 - Professor");

            System.out.println("2 - Aluno");
            
            System.out.println("3 - Limpar Menu");

            System.out.println("0 - Encerramento");

            continuar = scan.nextLine();

            switch (continuar) {
                case "1":
                        ProfessorVOService professorService = new ProfessorVOService();
                        ArrayList<ProfessorVO> professores = professorService.Listar();

                        for (ProfessorVO professor : professores)
                        {
                            professor.Imprimir();
                        }
                        desejaListar();
                    break;
            
                case "2":
                    System.out.println("Opções Aluno");
                    AlunoVOService alunoVOService = new AlunoVOService();
                    ArrayList<AlunoVO> alunos = alunoVOService.Listar();

                    for (AlunoVO aluno : alunos) {
                        aluno.Imprimir();
                    }
                    menuAluno();
                    break;

                case "3":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                break;

                case "0":
                    break;

                default:
                    System.out.println("Opção inválida!");
    
            }

        } while (!continuar.equals("0"));

        scan.close();

        System.out.println("### Final de Execução. ###");  

    }

    public static void desejaListar() {

        Scanner scan = new Scanner(System.in);

        String confirmar = "";

        System.out.println("---------------------------------");
        System.out.println("1 - Listar as turmas de um professor");
        System.out.println(" ");
        System.out.println("0 - Voltar");
        
        confirmar = scan.nextLine();

        switch(confirmar) 
        {
            case "1":
                System.out.print("Digite o código do professor que deseja listar:\n");
                Integer professorSelecionado = scan.nextInt();
                listarTurmasProfessor(professorSelecionado);
            break;

            case "0":
            break;

            default:
                System.out.println("Opção inválida!");
        }

    }

    public static void listarTurmasProfessor(Integer codigoProfessor) 
    {
        RelProfessorTurmaService relacionamentoProfessorTurma = new RelProfessorTurmaService();
        ArrayList<RelProfessorTurma> relacionamentos = relacionamentoProfessorTurma.listarTurmasProfessor(codigoProfessor);
        
        ProfessorVO professorSelecionado = new ProfessorVOService().getProfessorByCod(codigoProfessor);

        if (professorSelecionado == null)
        {
            System.out.println("Professor não encontrado!");
        }
        else 
        {
            System.out.print("O professor: " + professorSelecionado.getNome() + " dá aula para as turmas: ");

            for (RelProfessorTurma relacionamento : relacionamentos) {
                System.out.print(relacionamento.getTurma() + ", ");
            }
            System.out.print("\b\b ");
            System.out.println(" ");
            desejaListarAlunos();
        }
    }

    public static void desejaListarAlunos() 
    {
        Scanner scan = new Scanner(System.in);

        String confirmar = "";

        System.out.println("\n---------------------------------");
        System.out.println("1 - Listar os alunos de uma turma");
        System.out.println(" ");
        System.out.println("0 - Voltar");
        
        confirmar = scan.nextLine();

        switch(confirmar) 
        {
            case "1":
                System.out.print("Digite o código da turma que deseja consultar:\n");
                Integer turmaSelecionada = scan.nextInt();
                listarAlunosDaTurma(turmaSelecionada);
            break;

            case "0":
            break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void listarAlunosDaTurma(Integer codigoTurma) 
    {
        RelAlunoTurmaService relacionamentoAlunoTurma = new RelAlunoTurmaService();

        ArrayList<RelAlunoTurma> relacionamentos = relacionamentoAlunoTurma.listarAlunosDaTurma(codigoTurma);

        if(relacionamentos.isEmpty())
        {
            System.out.println("Turma não existe ou não existem alunos matrículados nesta turma!");
        } else 
        {
            System.out.println("Nesta turma estão matrículados os seguintes alunos: ");
            for(RelAlunoTurma relacionamento : relacionamentos) 
            {
                System.out.print(relacionamento.getAlunoCodigo() + ", ");
            }
            System.out.print("\b\b ");
            System.out.println("");
            desejaConsultarNotasAlunos();
        }
    }

    public static void desejaConsultarNotasAlunos()
    {
        Scanner scan = new Scanner(System.in);

        String confirmar = "";

        System.out.println("---------------------------------");
        System.out.println("1 - Consultar notas de um aluno");
        System.out.println(" ");
        System.out.println("0 - Voltar");
        
        confirmar = scan.nextLine();

        switch(confirmar) 
        {
            case "1":
                System.out.print("Digite o código do aluno que deseja consultar:\n");
                Integer alunoSelecionado = scan.nextInt();
                consultarNotasAluno(alunoSelecionado);
            break;

            case "0":
            break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void consultarNotasAluno(Integer codigoAluno)
    {
        RendimentoEscolarService rendimentoEscolar = new RendimentoEscolarService();

        RendimentoEscolar rendimentoEscolarDoAluno = rendimentoEscolar.consultarNotasAluno(codigoAluno);

        if(rendimentoEscolarIsNull(rendimentoEscolarDoAluno))
        {
            rendimentoEscolarDoAluno.Imprimir();
        }
        else 
        {
            System.out.println("Aluno não encontrado");
        }
    }

    public static void menuAluno()
    {
        Scanner scan = new Scanner(System.in);

        String confirmar = "";

        System.out.println("---------------------------------");
        System.out.println("1 - Turma que o aluno pertence");
        System.out.println(" ");
        System.out.println("2 - Disciplinas que o aluno cursa");
        System.out.println(" ");
        System.out.println("3 - Rendimento Escolar do aluno");
        System.out.println(" ");
        System.out.println("0 - Voltar");
        
        confirmar = scan.nextLine();

        switch(confirmar) 
        {
            case "1":
                System.out.println("Informe o código do aluno:");
                Integer alunoSelecionado = scan.nextInt();

                turmaDoAluno(alunoSelecionado);
            break;

            case "2":
                System.out.println("Informe o código do aluno:");
                Integer alunoDisciplina = scan.nextInt();

                DisciplinaVOService disciplinaService = new DisciplinaVOService();
                DisciplinaVO disciplinaSelecionada = disciplinaService.buscarDisciplinaAluno(alunoDisciplina);

                if(disciplinaSelecionada.getCodigo() == null)
                {
                    System.out.println("Aluno não encontrado!");
                }
                else
                {
                    System.out.println("Disciplina que o aluno cursa: " + disciplinaSelecionada.getNome());
                    menuNotasAluno(alunoDisciplina);
                }
            break;

            case "3":
                System.out.println("Informe o código do aluno:");
                Integer aluno = scan.nextInt();

                consultarNotasAluno(aluno);
            break;

            case "0":
                System.out.println("Voltando!");
            break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void turmaDoAluno(Integer alunoSelecionado) {

        String confirmar = "";

        Scanner scan = new Scanner(System.in);

        RelAlunoTurmaService relacionamentoAlunoTurma = new RelAlunoTurmaService();

        RelAlunoTurma turmaAluno = relacionamentoAlunoTurma.getTurmaAluno(alunoSelecionado);

        if(turmaAluno.getTurmaCodigo() == null)
        {
            System.out.println("Aluno não encontrado ou não matrículado em nenhuma turma!");
        } else 
        {
            System.out.println("Turma do aluno selecionado é a seguinte: " + turmaAluno.getTurmaCodigo());

            System.out.println("--------------------------------------");
            System.out.println("1 - Mostrar as informações desta turma");
            System.out.println(" ");
            System.out.println("0 - Voltar");
            
            confirmar = scan.nextLine();
    
            switch (confirmar) {
                case "1":
                    buscarTurma(turmaAluno.getTurmaCodigo());
                break;
    
                case "0":
                break;
    
                default:
                    System.out.println("Opção inválida!");
            }
        }

    }

    public static void buscarTurma(Integer codigoTurma) 
    {
        TurmaVOService turmaService = new TurmaVOService();
        TurmaVO turma = turmaService.buscarTurma(codigoTurma);

        turma.Imprimir();
    }

    public static void menuNotasAluno(Integer aluno) 
    {
        Scanner scan = new Scanner(System.in);

        String confirmar = "";

        System.out.println("------------------------");
        System.out.println("1 - notas do aluno na disciplina selecionada.");
        System.out.println(" ");
        System.out.println("2 - Notas de trabalho do aluno.");
        System.out.println(" ");
        System.out.println("0 - Voltar");

        confirmar = scan.nextLine();

        switch(confirmar)
        {
            case "1":
                RendimentoEscolarService rendimentoEscolar = new RendimentoEscolarService();
        
                RendimentoEscolar rendimentoEscolarDoAluno = rendimentoEscolar.consultarNotasAluno(aluno);
        
                System.out.println("Media do aluno na disciplina: " + rendimentoEscolarDoAluno.getMediaGeralAluno());
            break;

            case "2":
                NotaTrabalhoService notaService = new NotaTrabalhoService();

                NotaTrabalho notaTrabalhoAluno = notaService.getNotaTrabalhoAluno(aluno);

                System.out.println("Nota do aluno no trabalho: " + notaTrabalhoAluno.getTrabalho() + " é: " + notaTrabalhoAluno.getNota());
            break;

            case "0":
            break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    public static boolean rendimentoEscolarIsNull(RendimentoEscolar rendimentoEscolar)
    {
        return rendimentoEscolar.getAluno() != null && rendimentoEscolar.getTurma() != null && rendimentoEscolar.getPrimeiraNotaProva() != null && rendimentoEscolar.getSegundaNotaProva() != null && rendimentoEscolar.getMediaGeralAluno() != null && rendimentoEscolar.getMediaTrabalhos() != null;
    }
}