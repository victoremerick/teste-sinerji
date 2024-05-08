package br.victoremerick.testesinerji.controller;

import br.victoremerick.testesinerji.facade.PessoaDAO;
import br.victoremerick.testesinerji.model.Pessoa;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class ListarPessoasBean implements Serializable {
    private PessoaDAO pessoaController;
    private List<Pessoa> pessoas = new ArrayList<>();

    @PostConstruct
    public void build(){
        pessoaController = new PessoaDAO();
        pessoas = pessoaController.findAll();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public String calcularIdade(Date dataNascimento) {
        if (dataNascimento == null) {
            return "";
        }
        Calendar dataNascimentoCalendar = Calendar.getInstance();
        dataNascimentoCalendar.setTime(dataNascimento);

        Calendar dataAtual = Calendar.getInstance();

        int anos = dataAtual.get(Calendar.YEAR) - dataNascimentoCalendar.get(Calendar.YEAR);
        int meses = dataAtual.get(Calendar.MONTH) - dataNascimentoCalendar.get(Calendar.MONTH);
        int dias = dataAtual.get(Calendar.DAY_OF_MONTH) - dataNascimentoCalendar.get(Calendar.DAY_OF_MONTH);

        // Correção caso a data atual ainda não tenha atingido o aniversário da pessoa este ano
        if (meses < 0 || (meses == 0 && dias < 0)) {
            anos--;
        }

        return anos + " anos";
    }
}

