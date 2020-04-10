package Controlador;


import Modelo.Aluno;
import Modelo.Trabalho;
import Repositorio.IRepAluno;
import Repositorio.IRepTrabalho;
import Repositorio.RepAluno;
import Repositorio.RepTrabalho;
import excecoes.ProfessorException;

public class ControladorProfessor implements IControladorProfessor {

    private static IRepAluno repAluno;
    private static IRepTrabalho repTrabalho;

    private static ControladorProfessor instancia;

    private ControladorProfessor() {
        repAluno = RepAluno.getInstancia();
        repTrabalho = RepTrabalho.getInstancia();
    }

    public static ControladorProfessor getInstancia() {
        if (instancia == null) {
            instancia = new ControladorProfessor();
        }
        return instancia;
    }

    @Override
    public void alterarNotas(String codigo, double nota, int unidade, int materia) throws ProfessorException {
        if (repAluno.existeAluno(codigo) && nota >= 0 && nota <= 10) {
            repAluno.alterarNotas(codigo, nota, unidade, materia);
        } else {
            throw new ProfessorException("Erro ao alterar nota. ");
        }
    }

    @Override
    public void mandarTrabalho(Trabalho trabalho) throws ProfessorException {
        if (repTrabalho.existeTrabalho(trabalho.getCodigo())) {
            throw new ProfessorException("Trabalho com mesmo código já cadastrado. \n ");
        } else {
            repTrabalho.mandarTrabalho(trabalho);
        }

    }

    @Override
    public void removerTrabalho(String codigo) throws ProfessorException {
        if (RepTrabalho.getInstancia().existeTrabalho(codigo)) {
            repTrabalho.removerTrabalho(codigo);
        } else {
            throw new ProfessorException("Trabalho não existe. \n ");
        }
    }

    @Override
    public void removerTrabalho(int prazo) throws ProfessorException {
        if (RepTrabalho.getInstancia().existeTrabalho(prazo)) {
            repTrabalho.removerTrabalho(prazo);
        } else {
            throw new ProfessorException("Trabalho não existe. \n ");
        }
    }


    @Override
    public Aluno pesquisarAlunoCodigo(String codigo) throws ProfessorException {
        if (repAluno.existeAluno(codigo)) {
            return repAluno.pesquisarAlunoCodigo(codigo);
        } else {
            throw new ProfessorException("Aluno não existe. ");
        }
    }

    @Override
    public void substituirT(Trabalho t) throws ProfessorException {
        if (repTrabalho.existeTrabalho(t.getCodigo())) {
            repTrabalho.substituirT(t);
        } else {
            throw new ProfessorException("Trabalho não existe!");
        }
    }

    public void passarAlunosAno() {
        repAluno.passarAlunosAno();
    }
}

