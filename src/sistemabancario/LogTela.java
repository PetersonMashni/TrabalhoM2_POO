/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import java.util.Observable;
import sistemabancario.nucleo.LogDevice;

/**
 *
 * @author Peterson Mashni
 */
public class LogTela extends Observable implements LogDevice {

    private final StringBuffer buffer = new StringBuffer();

    public StringBuffer getBuffer() {
        return buffer;
    }

    @Override
    public void writelog(String mensagem) {
        buffer.append(mensagem);
        buffer.append("\n");
        setChanged();
        notifyObservers();
    }
}
