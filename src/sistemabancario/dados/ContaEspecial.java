/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario.dados;

import sistemabancario.nucleo.SaldoInsuficienteException;

/**
 *
 * @author Peterson Mashni
 */
public class ContaEspecial extends ContaCorrente {

    private Float taxaJuros;
    private Float limiteConta;

    public Float getLimiteConta() {
        return limiteConta;
    }

    public void setLimiteConta(Float limiteConta) {
        this.limiteConta = limiteConta;
    }

    public Float getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(Float taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public ContaEspecial(Pessoa titular, Float taxaMensal, Float taxaJuros, Float limiteConta) {
        super(titular, taxaMensal, TipoConta.Especial);
        this.taxaJuros = taxaJuros;
        this.limiteConta = limiteConta;
    }

    @Override
    public OperacaoConta Saque(Float valor) throws SaldoInsuficienteException {
        if ((getSaldo() + getLimiteConta()) < valor) {
            throw new SaldoInsuficienteException();
        }

        OperacaoConta op = new OperacaoConta(this, valor, TipoOperacao.Debito, getSaldo() - valor);
        getOperacoes().add(op);
        setSaldo(getSaldo() - valor);
        return op;
    }

}
