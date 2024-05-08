package br.victoremerick.testesinerji.controller;

import br.victoremerick.testesinerji.facade.PessoaDAO;
import br.victoremerick.testesinerji.model.Pessoa;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class PessoaBean {

    private PessoaDAO pessoaController;

    List<Pessoa> pessoas = new ArrayList<>();

    private Pessoa pessoa = new Pessoa();

    @PostConstruct
    public void build(){
        pessoaController = new PessoaDAO();
        pessoas = pessoaController.findAll();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void savePessoa(){
        pessoaController.create(pessoa);
        pessoa = new Pessoa();
    }
}
