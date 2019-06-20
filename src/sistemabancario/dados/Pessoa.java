/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario.dados;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Peterson Mashni
 */
public abstract class Pessoa {

    private Date dataCadastro;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String email;
    private String telefone;
    private StatusPessoa status;
    private ArrayList<Conta> contas = new ArrayList<Conta>();

    public boolean temContasAtivas() {
        for (Conta c : contas) {
            if (c.getStatus() == StatusConta.Ativa) {
                return true;
            }
        }
        return false;
    }

    public TipoPessoa getTipoPessoa() {
        return this instanceof PessoaFisica ? TipoPessoa.Fisica : TipoPessoa.Juridica;
    }

    public StatusPessoa getStatus() {
        return status;
    }

    public void setStatus(StatusPessoa status) {
        this.status = status;
    }

    public abstract String getNome();

    public Pessoa() {
        this.status = StatusPessoa.Ativa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    private String cep;

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
