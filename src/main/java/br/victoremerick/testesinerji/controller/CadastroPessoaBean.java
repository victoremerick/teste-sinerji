package br.victoremerick.testesinerji.controller;

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
public class CadastroPessoaBean implements Serializable {

    private PessoaDAO pessoaController;

    private boolean editar = false;

    private List<Pessoa> pessoas = new ArrayList<>();

    private Pessoa pessoa;

    @PostConstruct
    public void build(){
        pessoaController = new PessoaDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        if (paramMap.containsKey("pessoaId")) {
            Long pessoaId = Long.parseLong(paramMap.get("pessoaId"));
            log.info("Pessoa - Buscando... - ID="+pessoaId);
            pessoa = pessoaController.findById(pessoaId).orElse(new Pessoa());
            log.info("Pessoa - Encontrada - "+pessoa);
            editar = true;
        }else{
            pessoa = new Pessoa();
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void savePessoa(){
        if (pessoa.getId() != null) {
            log.info("Pessoa - Update - "+pessoa);
            pessoaController.update(pessoa);
        }else{
            log.info("Pessoa - Create - "+pessoa);
            pessoaController.create(pessoa);
        }
        pessoa = new Pessoa();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listarPessoas.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
