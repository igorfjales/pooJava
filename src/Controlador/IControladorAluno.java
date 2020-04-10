package Controlador;

import Modelo.Boletim;
import Modelo.Professor;
import Modelo.Trabalho;
import excecoes.AlunoException;
import excecoes.ProfessorException;


interface IControladorAluno {

    Boletim checarNotas(int materia, String codigo) throws AlunoException;

    Trabalho mostrarTrabalhos(String codigo) throws AlunoException, ProfessorException;

    Professor pesquisarProfessorCodigo(String codigo) throws AlunoException;
}
