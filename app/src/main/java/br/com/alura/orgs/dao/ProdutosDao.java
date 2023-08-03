package br.com.alura.orgs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.orgs.model.Produto;

public abstract class ProdutosDao {

    private static final List<Produto> produtos = new ArrayList<>();

    public static void adicionaUmProdutoAutomaticamenteParaTeste() {
        Produto primeiroProduto = new Produto("Salada de frutas", "Laranja, Maçã, Mamão", new BigDecimal("19.83"));
        primeiroProduto.setUrlImagem("https://media.istockphoto.com/id/185284489/pt/foto/de-laranja.jpg?s=612x612&w=0&k=20&c=IPTZGtjI4kIj6yKPkdT0BwnwiDsmcmt0M_6Akd8rrUY=");
        produtos.add(primeiroProduto);

    }

    public static void adiciona(Produto produto) {
        produtos.add(produto);
    }

    public static List<Produto> buscaTodos() {
        return produtos;
    }

}
