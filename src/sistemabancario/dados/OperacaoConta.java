/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario.dados;

import java.util.Date;

/**
 *
 * @author Peterson Mashni
 */
public class OperacaoConta {

    private final Date dataOperacao;
    private final Conta conta;
    private final Float valor;
    private final TipoOperacao tipoOperacao;
    private final Float saldo;

    protected OperacaoConta(Conta conta, Float valor, TipoOperacao tipoOperacao, Float saldo) {
        this.dataOperacao = new Date();
        this.conta = conta;
        this.valor = valor;
        this.tipoOperacao = tipoOperacao;
        this.saldo = saldo;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public Conta getConta() {
        return conta;
    }

    public Float getValor() {
        return valor;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public Float getSaldo() {
        return saldo;
    }

}
