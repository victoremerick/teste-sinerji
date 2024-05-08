package br.victoremerick.testesinerji.facade;

import br.victoremerick.testesinerji.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

public class PessoaDAO extends DAO<Pessoa> implements Serializable {

    private EntityManager entityManager;

    public PessoaDAO() {
        super(Pessoa.class);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        entityManager = factory.createEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}

