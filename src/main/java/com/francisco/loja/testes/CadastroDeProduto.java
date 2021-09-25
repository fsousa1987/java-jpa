package com.francisco.loja.testes;

import com.francisco.loja.com.francisco.loja.dao.ProdutoDao;
import com.francisco.loja.com.francisco.loja.util.JpaUtil;
import com.francisco.loja.modelo.Categoria;
import com.francisco.loja.modelo.Produto;

import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        var celular = new Produto(
                "Xiaomi Redmi", "Muito legal", new BigDecimal("800"), Categoria.CELULARES);

        var em = JpaUtil.getEntityManager();
        var dao = new ProdutoDao(em);

        em.getTransaction().begin();
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
