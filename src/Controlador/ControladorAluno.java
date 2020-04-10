package Controlador;

import Modelo.Aluno;
import Modelo.Boletim;
import Modelo.Professor;
import Modelo.Trabalho;
import Repositorio.*;
import excecoes.AlunoException;


public class ControladorAluno implements IControladorAluno {

    private static IRepTrabalho repTrabalho;
    private static IRepAluno repAluno;
    private static IRepProfessor repProfessor;

    private static ControladorAluno instancia;

    private ControladorAluno() {
        repTrabalho = RepTrabalho.getInstancia();
        repAluno = RepAluno.getInstancia();
        repProfessor = RepProfessor.getInstancia();
    }

    public static ControladorAluno getInstancia() {
        if (instancia == null) {
            instancia = new ControladorAluno();
        }

        return instancia;
    }

    @Override
    public Boletim checarNotas(int materia, String codigo) throws AlunoException {
        if (repAluno.existeAluno(codigo)) {
            Aluno a = repAluno.checarNotas(codigo);
            return a.getBoletim();
        } else {
            throw new AlunoException("Aluno não encontrado.");
        }
    }

    @Override
    public Trabalho mostrarTrabalhos(String codigo) throws AlunoException {

        if (repTrabalho.existeTrabalho(codigo)) {
            return repTrabalho.mostrarTrabalho(codigo);
        } else {
            throw new AlunoException("Trabalho não existe.");
        }
    }

    @Override
    public Professor pesquisarProfessorCodigo(String codigo) throws AlunoException {
        if (repProfessor.existeProfessor(codigo)) {
            return repProfessor.pesquisarProfessorCodigo(codigo);
        } else {
            throw new AlunoException("Professor não existe. ");
        }
    }
}
