package com.francisco.loja.testes;

import com.francisco.loja.com.francisco.loja.dao.CategoriaDao;
import com.francisco.loja.com.francisco.loja.dao.ProdutoDao;
import com.francisco.loja.com.francisco.loja.util.JpaUtil;
import com.francisco.loja.modelo.Categoria;
import com.francisco.loja.modelo.Produto;

import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProduto();
        var em = JpaUtil.getEntityManager();
        var produtoDao = new ProdutoDao(em);

        var p = produtoDao.buscarPorId(1L);
        System.out.println(p.getPreco());

        var produtos = produtoDao.buscarPorNomeDaCategoria("Celulares");
        produtos.forEach(produto -> System.out.println(produto.getNome()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
        System.out.println("Preço do produto: " + precoDoProduto);
    }

    private static void cadastrarProduto() {
        var celulares = new Categoria("Celulares");
        var celular = new Produto(
                "Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);

        var em = JpaUtil.getEntityManager();
        var produtoDao = new ProdutoDao(em);
        var categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
