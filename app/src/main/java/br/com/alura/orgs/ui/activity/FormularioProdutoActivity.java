package br.com.alura.orgs.ui.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.alura.orgs.R;
import br.com.alura.orgs.dao.ProdutosDao;
import br.com.alura.orgs.databinding.ActivityFormularioImagemBinding;
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding;
import br.com.alura.orgs.model.Produto;
import br.com.alura.orgs.util.ImageViewUtil;

public class FormularioProdutoActivity extends AppCompatActivity {
    private ActivityFormularioProdutoBinding binding;
    private ActivityFormularioImagemBinding bindingImagemFormulario;
    private String urlImagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produto);
        binding = ActivityFormularioProdutoBinding.inflate(getLayoutInflater());


        binding.produtoItemImageView.setOnClickListener(view -> {
            bindingImagemFormulario = ActivityFormularioImagemBinding.inflate(getLayoutInflater());
            bindingImagemFormulario.formularioImagemBtCarregar.setOnClickListener(view1 -> {
                urlImagem = bindingImagemFormulario.url.getText().toString();
                if (urlImagem != null && !urlImagem.isBlank()) {
                    ImageViewUtil.tentaCarregarImagem(urlImagem, bindingImagemFormulario.formularioImagemImageView);
                }
            });
            new AlertDialog.Builder(this)
                    .setView(bindingImagemFormulario.getRoot()).setPositiveButton("Confirmar", (dialogInterface, i) -> {
                        if (urlImagem != null && !urlImagem.isBlank()) {
                            ImageViewUtil.tentaCarregarImagem(urlImagem, binding.produtoItemImageView);
                        }

                    }).setNegativeButton("Cancelar", (dialogInterface, i) -> {
                        //volta sem fazer nada
                    })
                    .show();
        });


        configuraBotaoSalvar();

        setContentView(binding.getRoot());
    }


    private void configuraBotaoSalvar() {
        binding.btSalvar.setOnClickListener(view -> {
            Produto produto = criaProduto();
            ProdutosDao.adiciona(produto);
            finish();

        });
    }

    @NonNull
    private Produto criaProduto() {
        String nome = binding.textInputLayoutNome.getEditText().getText().toString();
        String descricao = binding.textInputLayoutDescricao.getEditText().getText().toString();
        String precoString = binding.textInputLayoutPreco.getEditText().getText().toString();
        BigDecimal preco;

        if (precoString.isBlank()) {
            preco = BigDecimal.ZERO;
        } else {
            preco = new BigDecimal(precoString);
        }

        Produto produto;
        if (urlImagem == null || urlImagem.isBlank()) {
            produto = new Produto(nome, descricao, preco);
        } else {
            produto = new Produto(nome, descricao, preco, urlImagem);
        }

        return produto;
    }


    @Override
    protected void onResume() {
        super.onResume();


    }
}