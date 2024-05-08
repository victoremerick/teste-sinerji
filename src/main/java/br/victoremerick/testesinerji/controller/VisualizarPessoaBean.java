package br.victoremerick.testesinerji.controller;

import br.victoremerick.testesinerji.facade.EnderecoDAO;
import br.victoremerick.testesinerji.facade.PessoaDAO;
import br.victoremerick.testesinerji.model.Endereco;
import br.victoremerick.testesinerji.model.Pessoa;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Map;

@ManagedBean
@RequestScoped
public class VisualizarPessoaBean implements Serializable {
    private Long pessoaId;
    private PessoaDAO pessoaController;
    private EnderecoDAO enderecoController;
    private Pessoa pessoa = new Pessoa(); // Importe sua classe Pessoa aqui
    private Endereco novoEndereco; // Importe sua classe Endereco aqui

    @PostConstruct
    public void build(){
        pessoaController = new PessoaDAO();
        enderecoController = new EnderecoDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        if (paramMap.containsKey("pessoaId")) {
            pessoaId = Long.parseLong(paramMap.get("pessoaId"));
            pessoa = pessoaController.findById(pessoaId).orElse(new Pessoa());
            novoEndereco = new Endereco();
            novoEndereco.setPessoa(pessoa);
        }
    }

    public void adicionarEndereco() {
        enderecoController.create(novoEndereco);
        novoEndereco = new Endereco();
        novoEndereco.setPessoa(pessoa);
        pessoa = pessoaController.findById(pessoa.getId()).orElse(new Pessoa());
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getNovoEndereco() {
        return novoEndereco;
    }

    public void setNovoEndereco(Endereco novoEndereco) {
        this.novoEndereco = novoEndereco;
    }
}

