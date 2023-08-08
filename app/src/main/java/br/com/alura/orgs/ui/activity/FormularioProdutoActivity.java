package br.com.alura.orgs.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.alura.orgs.R;
import br.com.alura.orgs.dao.ProdutosDao;
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding;
import br.com.alura.orgs.model.Produto;
import br.com.alura.orgs.ui.dialog.FormularioImagemDialog;
import br.com.alura.orgs.util.ImageViewUtil;

public class FormularioProdutoActivity extends AppCompatActivity {
    private ActivityFormularioProdutoBinding binding;
    private String urlImagem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produto);
        binding = ActivityFormularioProdutoBinding.inflate(getLayoutInflater());

        binding.produtoItemImageView.setOnClickListener(view -> {
            FormularioImagemDialog formularioImagemDialog = new FormularioImagemDialog(this);
            formularioImagemDialog.mostra(imageUrl -> {
                urlImagem = imageUrl;
                ImageViewUtil.tentaCarregarImagem(urlImagem, binding.produtoItemImageView);
                Log.i("TAG3", "onImageURLSelected: " + urlImagem);
            });
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