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
public class PessoaJuridica extends Pessoa {

    private Date dataAbertura;
    private String razaoSocial;
    private String cnpj;
    private RegimeTributarioPesssoaJuridica regimeTributario;

    public RegimeTributarioPesssoaJuridica getRegimeTributario() {
        return regimeTributario;
    }

    public void setRegimeTributario(RegimeTributarioPesssoaJuridica regimeTributario) {
        this.regimeTributario = regimeTributario;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String getNome() {
        return this.razaoSocial;
    }

}
