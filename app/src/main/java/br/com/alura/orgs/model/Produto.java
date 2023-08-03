package br.com.alura.orgs.model;

import java.math.BigDecimal;

public class Produto {

    private final String nome;
    private final String descricao;
    private final BigDecimal preco;
    private String urlImagem;

    public Produto(String nome, String descricao, BigDecimal preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto(String nome, String descricao, BigDecimal preco, String urlImagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.urlImagem = urlImagem;
    }


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
