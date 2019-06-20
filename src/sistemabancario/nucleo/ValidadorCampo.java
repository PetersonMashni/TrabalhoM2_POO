/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario.nucleo;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import static sistemabancario.nucleo.ValidadorTipo.RadioGroup;

/**
 *
 * @author Peterson Mashni
 */
public class ValidadorCampo {

    private JComponent campo;
    private ValidadorTipo tipo;
    private Color corCampoOriginal;
    private Color corCampoInvalido;
    private Boolean opcional;
    private Boolean campoValido = false;
    private String nomeCampo;
    private final DecimalFormat decimalFormat = new DecimalFormat("0.#");

    public String getNomeCampo() {
        return nomeCampo;
    }

    public Boolean isCampoValido() {
        return campoValido;
    }

    public ValidadorCampo(JComponent campo, String nomeCampo, ValidadorTipo tipo) {
        this(campo, nomeCampo, tipo, false);
    }

    public ValidadorCampo(JComponent campo, String nomeCampo, ValidadorTipo tipo, Boolean opcional) {
        this.campo = campo;
        this.tipo = tipo;
        this.opcional = opcional;
        this.nomeCampo = nomeCampo;
        this.corCampoOriginal = getColorCampo();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(symbols);
    }

    public void resetValidacao() {
        campoValido = false;
        setColorCampo(corCampoOriginal);
    }

    public Color getCorCampoInvalido() {
        return corCampoInvalido;
    }

    public void setCorCampoInvalido(Color corCampoInvalido) {
        this.corCampoInvalido = corCampoInvalido;
    }

    public Boolean getOpcional() {
        return opcional;
    }

    public void setOpcional(Boolean opcional) {
        this.opcional = opcional;
    }

    public JComponent getCampo() {
        return campo;
    }

    public void setCampo(JComponent campo) {
        this.campo = campo;
    }

    public ValidadorTipo getTipo() {
        return tipo;
    }

    public void setTipo(ValidadorTipo tipo) {
        this.tipo = tipo;
    }

    private Color getColorCampo() {
        if (campo instanceof JTextField) {
            return ((JTextField) campo).getBackground();
        } else if (campo instanceof JToggleButton) {
            return ((JToggleButton) campo).getBackground();
        } else if (campo instanceof JComboBox) {
            return ((JComboBox) campo).getBackground();
        } else
        return new Color(0);
    }

    public void setColorCampo(Color cor) {
        if (campo instanceof JTextField) {
            ((JTextField) campo).setBackground(cor);
        } else if (campo instanceof JToggleButton) {
            ((JToggleButton) campo).setBackground(cor);
        }  else if (campo instanceof JComboBox) {
            ((JComboBox) campo).setBackground(cor);
        }
    }

    public Boolean validar() {
        if (opcional && eVazio()) {
            campoValido = true;
        } else {
            switch (tipo) {
                case NaoVazio:
                    campoValido = validarNaoVazio();
                    break;
                case FormatadoSemEspacos:
                    campoValido = validarFormatadoSemEspacos();
                    break;
                case Cpf:
                    campoValido = validarCpf();
                    break;
                case Cnpj:
                    campoValido = validarCnpj();
                    break;
                case UF:
                    campoValido = validarUF();
                    break;
                case RadioGroup:
                    campoValido = validarRadioGroup();
                    break;
                case NumeroPositivo:
                    campoValido = validarNumeroPositivo();
                    break;
                case Data:
                    campoValido = validarData();
                    break;
                case Email:
                    campoValido = validarEmail();
                    break;
                default:
                    campoValido = true;
            }
        }
        setColorCampo(campoValido ? corCampoOriginal : corCampoInvalido);
        return campoValido;
    }

    private Boolean eVazio() {
        if (campo instanceof JTextField) {
            return ((JTextField) campo).getText().trim().length() == 0;
        } else if (campo instanceof JComboBox) {
            return ((JComboBox) campo).getSelectedIndex() == -1;
        } else {
            return false;
        }
    }

    private Boolean validarNaoVazio() {
        return !eVazio();
    }

    private Boolean validarCpf() {
        if (!(campo instanceof JTextField)) {
            return false;
        }

        String CPF = ((JTextField) campo).getText().trim().replace(".", "").replace("-", "");
        //************************************************************************************************************
        // Trecho de código extraído de https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097
        //************************************************************************************************************

        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0         
                // (48 eh a posicao de '0' na tabela ASCII)         
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            return ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)));
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    private Boolean validarCnpj() {
        if (!(campo instanceof JTextField)) {
            return false;
        }

        String CNPJ = ((JTextField) campo).getText().trim().replace(".", "").replace("-", "").replace("/", "");
        //************************************************************************************************************
        // Trecho de código extraído de https://www.devmedia.com.br/validando-o-cnpj-em-uma-aplicacao-java/22374
        //************************************************************************************************************

        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111")
                || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333")
                || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
                || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777")
                || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999")
                || (CNPJ.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            return ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)));
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    private Boolean validarUF() {
        if (!(campo instanceof JTextField)) {
            return false;
        }
        return (((JTextField) campo).getText().length() == 2)
                && (((JTextField) campo).getText() != "__")
                && "AC__AL__AM__AP__BA__CE__DF__ES__GO__MA__MG__MS__MT__PA__PB__PE__PI__PR__RJ__RN__RO__RR__RS__SC__SE__SP__TO".indexOf(((JTextField) campo).getText()) > -1;
    }

    private Boolean validarRadioGroup() {
        if (!(campo instanceof JRadioButton)) {
            return false;
        }

        return true;
        //((JRadioButton)campo).
    }

    private Boolean validarNumeroPositivo() {
        if (!(campo instanceof JTextField)) {
            return false;
        }

        try {
            Float num = decimalFormat.parse(((JTextField) campo).getText()).floatValue();
            return num >= 0;
        } catch (Exception erro) {
            return false;
        }
    }

    private Boolean validarData() {
        if (!(campo instanceof JTextField)) {
            return false;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            Date data = dateFormat.parse(((JTextField) campo).getText());
            return true;
        } catch (ParseException erro) {
            return false;
        }
    }

    private Boolean validarEmail() {
        if (!(campo instanceof JTextField)) {
            return false;
        }

        String email = ((JTextField) campo).getText();

        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        return false;
    }

    private Boolean validarFormatadoSemEspacos() {
        if (!(campo instanceof JTextField)) {
            return false;
        }
        return !((JTextField) campo).getText().contains(" ");
    }

}
