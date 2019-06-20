/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario.nucleo;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Peterson Mashni
 */
public class Validador {

    private final Color corFundoCamposInvalido;

    public Validador(Color corFundoCamposInvalido) {
        this.corFundoCamposInvalido = corFundoCamposInvalido;
    }
    private ArrayList<ValidadorCampo> campos = new ArrayList<ValidadorCampo>();
    private Boolean camposValidos = false;

    public ArrayList<ValidadorCampo> getCampos() {
        return campos;
    }

    public Boolean isValidado() {
        return camposValidos;
    }

    public Color getCorFundoCamposInvalido() {
        return corFundoCamposInvalido;
    }

    public void add(ValidadorCampo campo) {
        campos.add(campo);
        campo.setCorCampoInvalido(corFundoCamposInvalido);
    }

    public void resetValidacoes() {
        campos.forEach((c) -> {
            c.resetValidacao();
        });
    }

    public Boolean validar() {
        camposValidos = true;
        campos.forEach(c -> {
            Boolean valid = c.validar();
            camposValidos = camposValidos && valid;
        });
        return camposValidos;
    }

}
