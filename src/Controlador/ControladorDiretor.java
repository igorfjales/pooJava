package Controlador;

import Modelo.Aluno;
import Modelo.Endereco;
import Modelo.Professor;
import Repositorio.IRepAluno;
import Repositorio.IRepProfessor;
import Repositorio.RepAluno;
import Repositorio.RepProfessor;
import excecoes.DiretorException;

public class ControladorDiretor implements IControladorDiretor {

    private static IRepAluno repAluno;
    private static IRepProfessor repProfessor;

    private static ControladorDiretor instancia;

    private ControladorDiretor() {
        repAluno = RepAluno.getInstancia();
        repProfessor = RepProfessor.getInstancia();
    }

    public static ControladorDiretor getInstancia() {
        if (instancia == null) {
            instancia = new ControladorDiretor();
        }
        return instancia;
    }

    @Override
    public void inserirAluno(Aluno a) throws DiretorException {
        if (repAluno.existeAluno(a.getCodigo())) {
            throw new DiretorException("Aluno com mesmo código já cadastrado!");
        }
        if (repAluno.checarSerie(a)) {
            throw new DiretorException("Série invalida!");
        } else {
            repAluno.inserirAluno(a);
        }
    }

    @Override
    public void removerAlunoCodigo(String codigo) throws DiretorException {
        if (repAluno.existeAluno(codigo)) {
            repAluno.removerAlunoCodigo(codigo);
        } else {
            throw new DiretorException("Aluno não existe!");
        }
    }

    @Override
    public Aluno pesquisarAlunoCodigo(String codigo, String cpf) throws DiretorException {
        if (repAluno.existeAluno(codigo)) {
            return repAluno.pesquisarAlunoCodigo(codigo, cpf);

        } else {
            throw new DiretorException("Aluno não existe. ");
        }
    }

    @Override
    public void inserirProfessor(Professor p) throws DiretorException {
        if (repProfessor.existeProfessor(p.getCodigo())) {
            throw new DiretorException("Professor com mesmo código já cadastrado!");
        } else {
            repProfessor.inserirProfessor(p);
        }
    }

    //OVERLOAD
    public Professor pesquisarProfessorCodigo(String codigo, String cpf) throws DiretorException {

        if (repProfessor.existeProfessor(codigo)) {
            return repProfessor.pesquisarProfessorCodigo(codigo, cpf);
        } else {
            throw new DiretorException("Professor não existe. ");
        }

    }

    public void removerProfessorCodigo(String codigo) throws DiretorException {
        if (repProfessor.existeProfessor(codigo)) {
            repProfessor.removerProfessorCodigo(codigo);
        } else {
            throw new DiretorException("Professor não existe. ");
        }
    }

    @Override
    public void aumentarSalarioP(String codigo) throws DiretorException {
        if (repProfessor.existeProfessor(codigo)) {
            repProfessor.aumentarSalario(codigo);
        } else {
            throw new DiretorException("Professor não existe. ");
        }
    }

    @Override
    public void aumentarSalarioP(String codigo, double quantidade) throws DiretorException {
        if (repProfessor.existeProfessor(codigo)) {
            repProfessor.aumentarSalario(codigo, quantidade);
        } else {
            throw new DiretorException("Professor não existe. ");
        }
    }

    public void trocarProfessor(String codigo, Professor novoProfessor) throws DiretorException {
        if (repProfessor.existeProfessor(codigo)) {
            repProfessor.trocarProfessor(codigo, novoProfessor);
        } else {
            throw new DiretorException("Professor não existe!");
        }
    }

    public void removerEnderecoP(String codigo) throws DiretorException {
        if (repProfessor.existeProfessor(codigo)) {
            repProfessor.removerEnderecoP(codigo);
        } else {
            throw new DiretorException("Professor não existe!");
        }
    }

    public void removerEnderecoA(String codigo) throws DiretorException {
        if (repAluno.existeAluno(codigo)) {
            repAluno.removerEnderecoA(codigo);
        } else {
            throw new DiretorException("Aluno não existe!");
        }
    }

    @Override
    public void trocarEnderecoA(String codigo, Endereco endereco) throws DiretorException {
        if (repAluno.existeAluno(codigo)) {
            if (repAluno.trocarEnderecoA(codigo, endereco)) {
            } else {
                throw new DiretorException("Endereço do aluno não cadastrado.");
            }
        } else {
            throw new DiretorException("Aluno não existe!");
        }
    }

    @Override
    public void trocarEnderecoP(String codigo, Endereco endereco) throws DiretorException {
        if (repProfessor.existeProfessor(codigo)) {
            if (repProfessor.trocarEnderecoP(codigo, endereco)) {
            } else {
                throw new DiretorException("Endereço do professor não cadastrado.");
            }
        } else {
            throw new DiretorException("Professor não existe!");
        }
    }

    @Override
    public void inserirEnderecoAluno(Endereco endereco, String codigo) throws DiretorException {
        if (repAluno.inserirEnderecoAluno(endereco, codigo)) {
        } else {
            throw new DiretorException("Endereço já cadastrado!");
        }
    }

    @Override
    public void inserirEnderecoProfessor(Endereco endereco, String codigo) throws DiretorException {
        if (repProfessor.inserirEnderecoProfessor(endereco, codigo)) {
        } else {
            throw new DiretorException("Endereço já cadastrado!");
        }
    }

}
