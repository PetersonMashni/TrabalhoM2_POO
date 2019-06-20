/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario.dados;

import java.util.ArrayList;
import java.util.Date;
import sistemabancario.nucleo.SaldoInsuficienteException;

/**
 *
 * @author Peterson Mashni
 */
public abstract class Conta {

    private String agencia;
    private String numeroConta;
    private Date dataAbertura;
    private final Pessoa titular;
    protected final TipoConta tipoConta;
    private Float saldo;
    private String senha;
    private ArrayList<OperacaoConta> operacoes;
    private StatusConta status;

    public StatusConta getStatus() {
        return status;
    }

    public void setStatus(StatusConta status) {
        this.status = status;
    }
    
    public ArrayList<OperacaoConta> getOperacoes() {
        return operacoes;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public OperacaoConta Saque(Float valor) throws SaldoInsuficienteException{
        if (saldo < valor)
            throw new SaldoInsuficienteException();
        
        OperacaoConta op = new OperacaoConta(this, valor, TipoOperacao.Debito, saldo - valor);
        operacoes.add(op);
        saldo -= valor;
        return op;
    }
    

    public OperacaoConta Deposito(Float valor){
        OperacaoConta op = new OperacaoConta(this, valor, TipoOperacao.Credito, saldo + valor);
        operacoes.add(op);
        saldo += valor;
        return op;
    }

    public Float getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta{" + "agencia=" + agencia + ", numeroConta=" + numeroConta + '}';
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Conta(Pessoa titular, TipoConta tipoConta) {
        this.titular = titular;
        this.tipoConta = tipoConta;
        this.operacoes = new ArrayList<OperacaoConta>();
        this.saldo = 0F;
        this.dataAbertura = new Date();
        this.status = StatusConta.Ativa;

        titular.getContas().add(this);
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }
    
    public Date getDataUltimoMovimento()
    {
        if (operacoes.isEmpty())
            return null;
        
        return operacoes.get(operacoes.size()-1).getDataOperacao();
    }

}
