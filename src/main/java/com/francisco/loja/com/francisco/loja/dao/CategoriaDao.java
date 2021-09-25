package com.francisco.loja.com.francisco.loja.dao;

import com.francisco.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private final EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }
}
