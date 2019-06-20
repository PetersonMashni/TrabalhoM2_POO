/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario.nucleo;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import sistemabancario.dados.*;

/**
 *
 * @author Peterson Mashni
 */
public class Contexto {

    static private LogDevice logDevice;
    static private Impressora impressora;
    static private Funcionario funcionarioLogado;
    static private HashMap<Integer, Funcionario> colecaoFuncionarios = new HashMap<Integer, Funcionario>();
    static private HashMap<String, PessoaFisica> colecaoPessoasFisicas = new HashMap<String, PessoaFisica>();
    static private HashMap<String, PessoaJuridica> colecaoPessoasJuridicas = new HashMap<String, PessoaJuridica>();
    static private HashMap<String, Conta> colecaoContas = new HashMap<String, Conta>();
    static private ArrayList<Pessoa> colecaoPessoas = new ArrayList<Pessoa>();
    static public final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static public final SimpleDateFormat mesAnoFormat = new SimpleDateFormat("MM/yy");
    static public final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    static public final SimpleDateFormat datetimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static public DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    public static ArrayList<Pessoa> getColecaoPessoas() {
        return colecaoPessoas;
    }

    public static HashMap<String, Conta> getColecaoContas() {
        return colecaoContas;
    }

    public static HashMap<String, PessoaFisica> getColecaoPessoasFisicas() {
        return colecaoPessoasFisicas;
    }

    public static HashMap<String, PessoaJuridica> getColecaoPessoasJuridicas() {
        return colecaoPessoasJuridicas;
    }

    public static Boolean usuarioEstaAutenticado() {
        return funcionarioLogado != null;
    }

    public static HashMap<Integer, Funcionario> getColecaoFuncionarios() {
        return colecaoFuncionarios;
    }

    public static Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public static void setFuncionarioLogado(Funcionario funcionarioLogado) {
        Contexto.funcionarioLogado = funcionarioLogado;
    }

    static public void registraLogDevice(LogDevice logDevice) {
        Contexto.logDevice = logDevice;
    }

    static public void registraImpressora(Impressora impressora) {
        Contexto.impressora = impressora;
    }

    static public void log(String modulo, String mensagem) {
        if (Contexto.logDevice != null) {
            logDevice.writelog(
                    String.format("%s; %s; %s; %s",
                            datetimeFormat.format(new Date()),
                            Contexto.getFuncionarioLogado().getNome(),
                            modulo,
                            mensagem));
        }
    }

    static public void print(String dados) {
        if (Contexto.impressora != null) {
            impressora.print(dados);
        }
    }

    static public void printLine(String dados) {
        if (Contexto.impressora != null) {
            impressora.printLine(dados);
        }
    }
}
