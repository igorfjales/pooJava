package Repositorio;

import Modelo.Diretor;
import Modelo.Endereco;

public interface IRepDiretor {
    void inserirDiretor(Diretor diretor);

    boolean existeDiretor(String codigo);

    void removerDiretorCodigo(String codigo);

    void substituirDiretor(String codigo, Diretor novoDiretor);

    void removerEnderecoD(String codigo);

    Diretor PesquisarDiretorCodigo(String codigo, String cpf);

    boolean TrocarEndD(String codigo, Endereco end);

    boolean inserirEnderecoDiretor(Endereco endereco, String codigo);

    void AtualizarSalarioDiretor(String codigo, Double novoSalario);

    void aumentarSalarioD(String codigo);
}
