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
public class ContaPoupanca extends Conta {

    private Float taxaRendimento;

    public Float getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(Float taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public ContaPoupanca(Pessoa titular, Float taxaRendimento) {
        super(titular, TipoConta.Poupanca);
        this.taxaRendimento = taxaRendimento;
    }

}
