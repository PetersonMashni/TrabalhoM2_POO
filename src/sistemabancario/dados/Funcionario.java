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
public class Funcionario {

    private Integer codigo;
    private String nome;
    private CargoFuncionario cargo;
    private String senha;
    private Date dataCadastro;

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Funcionario() {
    }

    public Funcionario(Integer codigo, String nome, CargoFuncionario cargo, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.senha = senha;
        this.dataCadastro = new Date();
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CargoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(CargoFuncionario cargo) {
        this.cargo = cargo;
    }
   
    @Override
    public String toString() {
        return nome;
    }

}
