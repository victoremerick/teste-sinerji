package br.victoremerick.testesinerji.controller;

import br.victoremerick.testesinerji.facade.EnderecoDAO;
import br.victoremerick.testesinerji.facade.PessoaDAO;
import br.victoremerick.testesinerji.model.Endereco;
import br.victoremerick.testesinerji.model.Pessoa;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean
@RequestScoped
@Slf4j
public class CadastroEnderecoBean implements Serializable {

    private EnderecoDAO enderecoController;
    private PessoaDAO pessoaController;

    private Endereco endereco = new Endereco();
    private Long pessoaId = null;
    private Long enderecoId = null;

    @PostConstruct
    public void build(){
        enderecoController = new EnderecoDAO();
        pessoaController = new PessoaDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        if (paramMap.containsKey("pessoaId")) {
            pessoaId = Long.parseLong(paramMap.get("pessoaId"));
        }else{
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("listarPessoas.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (paramMap.containsKey("enderecoId")) {
            enderecoId = Long.parseLong(paramMap.get("enderecoId"));
            endereco = enderecoController.findById(enderecoId).get();
        }
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void saveEndereco(){
        log.error("Teste chamada");
        if(endereco.getId() != null){
            log.info("Endereco - Update - "+endereco);
            Pessoa p = pessoaController.findById(pessoaId).get();
            endereco.setPessoa(p);
            enderecoController.update(endereco);
        }else{
            log.info("Endereco - Create - "+endereco);
            Pessoa p = pessoaController.findById(pessoaId).get();
            endereco.setPessoa(p);
            enderecoController.create(endereco);
        }

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("visualizarPessoa.xhtml?pessoaId="+pessoaId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
