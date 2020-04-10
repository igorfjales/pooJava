package Controlador;

import Modelo.Aluno;
import Modelo.Trabalho;
import excecoes.ProfessorException;

interface IControladorProfessor {

    void alterarNotas(String codigo, double nota, int unidade, int materia) throws ProfessorException;

    void mandarTrabalho(Trabalho trabalho) throws ProfessorException;

    void removerTrabalho(String codigo) throws ProfessorException;

    void removerTrabalho(int prazo) throws ProfessorException;

    Aluno pesquisarAlunoCodigo(String codigo) throws ProfessorException;

    void substituirT(Trabalho t) throws ProfessorException;

    void passarAlunosAno();
}
