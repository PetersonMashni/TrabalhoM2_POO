/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario.nucleo;

/**
 *
 * @author Peterson Mashni
 */
public class SaldoInsuficienteException extends Exception {

    @Override
    public String toString() {
        return String.format("Saldo Insuficiente para a Operação!");
    }
}
