package br.com.alura.orgs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.orgs.model.Produto;

public abstract class ProdutosDao {

    private static final List<Produto> produtos = new ArrayList<>();

    public static void adicionaUmProdutoAutomaticamenteParaTeste() {
        produtos.add(new Produto("Salada de frutas", "Laranja, Maçã, Mamão", new BigDecimal("19.83")));
    }

    public static void adiciona(Produto produto) {
        produtos.add(produto);
    }

    public static List<Produto> buscaTodos() {
        return produtos;
    }

}
