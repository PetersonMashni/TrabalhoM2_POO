/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import java.util.Observable;
import sistemabancario.nucleo.Impressora;

/**
 *
 * @author Peterson Mashni
 */
public class ImpressoraTela extends Observable implements Impressora {

    private final StringBuffer buffer = new StringBuffer();

    public StringBuffer getBuffer() {
        return buffer;
    }

    @Override
    public void print(String dados) {
        buffer.append(dados);
        setChanged();
        notifyObservers();
    }

    @Override
    public void printLine(String dados) {
        buffer.append(dados);
        buffer.append("\n");
        setChanged();
        notifyObservers();
    }
}
