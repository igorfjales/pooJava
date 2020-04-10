package Controlador;

import Repositorio.IRepSala;
import Repositorio.RepSala;
import excecoes.SalaException;

public class ControladorSala implements IControladorSala {
    private static IRepSala repSala;

    private static ControladorSala instancia;

    private ControladorSala() {
        repSala = RepSala.getInstancia();
    }

    public static ControladorSala getInstancia() {
        if (instancia == null) {
            instancia = new ControladorSala();
        }
        return instancia;
    }

    @Override
    public int alugarSala(int codigo) throws SalaException {
        if (codigo >= 1 && codigo <= 3) {
            if (repSala.verificaSala(codigo)) {
                return repSala.alugarSala(codigo);
            } else {
                throw new SalaException("Sala indisponivel. ");
            }
        } else {
            throw new SalaException("Codigo inválido. ");
        }
    }

    @Override
    public void devolverSala(int codigo) throws SalaException {
        if (codigo >= 0 && codigo <= 8) {
            if (!repSala.verificaSala(codigo)) {
                if (codigo >= 0 && codigo <= 2) {
                    repSala.devolverSala(codigo, 1);
                } else if (codigo >= 3 && codigo <= 5) {
                    repSala.devolverSala(codigo, 2);
                } else if (codigo >= 6 && codigo <= 8) {
                    repSala.devolverSala(codigo, 3);
                }
            } else {
                throw new SalaException("Sala indisponivel. ");
            }
        } else {
            throw new SalaException("Codigo inválido. ");
        }
    }
}
