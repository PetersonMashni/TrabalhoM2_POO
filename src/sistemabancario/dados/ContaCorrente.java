/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario.dados;

/**
 *
 * @author Peterson Mashni
 */
public class ContaCorrente extends Conta {

    private Float taxaMensal;

    public Float getTaxaMensal() {
        return taxaMensal;
    }

    public void setTaxaMensal(Float taxaMensal) {
        this.taxaMensal = taxaMensal;
    }

    public ContaCorrente(Pessoa titular, Float taxaMensal) {
        this(titular, taxaMensal, TipoConta.Normal);
    }

    protected ContaCorrente(Pessoa titular, Float taxaMensal, TipoConta tipoConta) {
        super(titular, tipoConta);
        this.taxaMensal = taxaMensal;
    }

}
