package Controlador;

import excecoes.SalaException;

interface IControladorSala {

    int alugarSala(int codigo) throws SalaException;

    void devolverSala(int codigo) throws SalaException;
}
