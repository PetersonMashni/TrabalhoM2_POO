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
public class PessoaFisica extends Pessoa {

    private String cpf;
    private String Nome;
    private Date dataNascimento;
    private GeneroPessoaFisica genero;

    public GeneroPessoaFisica getGenero() {
        return genero;
    }

    public void setGenero(GeneroPessoaFisica genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
