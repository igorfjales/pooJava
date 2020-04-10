package Controlador;


import Modelo.Diretor;
import Modelo.Endereco;
import Repositorio.IRepDiretor;
import Repositorio.RepDiretor;
import excecoes.DonoException;

public class ControladorDono implements IControladorDono {

    private static IRepDiretor repDiretor;

    private static ControladorDono instancia;

    private ControladorDono() {
        repDiretor = RepDiretor.getInstancia();
    }

    public static ControladorDono getInstancia() {
        if (instancia == null) {
            instancia = new ControladorDono();
        }
        return instancia;
    }

    @Override
    public void inserirDiretor(Diretor diretor) throws DonoException {
        if (repDiretor.existeDiretor(diretor.getCodigo())) {
            throw new DonoException("Diretor com o mesmo código já cadastrado!");
        } else {
            repDiretor.inserirDiretor(diretor);
        }
    }

    public void removerDiretorCodigo(String codigo) throws DonoException {
        if (repDiretor.existeDiretor(codigo)) {
            repDiretor.removerDiretorCodigo(codigo);
        } else {
            throw new DonoException("Diretor não existe!");
        }
    }

    public void substituirDiretor(String codigo, Diretor novoDiretor) throws DonoException {
        if (repDiretor.existeDiretor(codigo)) {
            repDiretor.substituirDiretor(codigo, novoDiretor);
        } else {
            throw new DonoException("Diretor não existe!");
        }
    }

    public void removerEnderecoD(String codigo) throws DonoException {
        if (repDiretor.existeDiretor(codigo)) {
            repDiretor.removerEnderecoD(codigo);
        } else {
            throw new DonoException("Diretor não existe!");
        }
    }

    public Diretor pesquisarDiretorCodigo(String codigo, String cpf) throws DonoException {

        if (repDiretor.existeDiretor(codigo)) {
            return repDiretor.PesquisarDiretorCodigo(codigo, cpf);
        } else {
            throw new DonoException("Diretor não existe. ");
        }

    }

    @Override
    public void trocarEndD(String codigo, Endereco endereco) throws DonoException {
        if (repDiretor.existeDiretor(codigo)) {
            if (repDiretor.TrocarEndD(codigo, endereco)) {
            } else {
                throw new DonoException("Endereço do diretor não cadastrado.");
            }
        } else {
            throw new DonoException("Diretor não existe!");
        }
    }

    public void inserirEnderecoDiretor(Endereco endereco, String codigo) throws DonoException {
        if (repDiretor.inserirEnderecoDiretor(endereco, codigo)) {
        } else {
            throw new DonoException("Endereço já cadastrado!");
        }
    }

    public void AtualizarSalarioDiretor(String codigo, Double novoSalario) throws DonoException {
        if (repDiretor.existeDiretor(codigo)) {
            repDiretor.AtualizarSalarioDiretor(codigo, novoSalario);

        } else {
            throw new DonoException("Diretor Inexistente. ");
        }
    }

    @Override
    public void aumentarSalarioD(String codigo) throws DonoException {
        if (repDiretor.existeDiretor(codigo)) {
            repDiretor.aumentarSalarioD(codigo);
        } else {
            throw new DonoException("Diretor não existe. ");
        }
    }
}

