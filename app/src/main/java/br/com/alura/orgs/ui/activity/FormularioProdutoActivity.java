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

public class FormularioProdutoActivity extends AppCompatActivity {
    private ActivityFormularioProdutoBinding binding;
    private ActivityFormularioImagemBinding formularioImagemBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produto);
        binding = ActivityFormularioProdutoBinding.inflate(getLayoutInflater());
        binding.produtoItemImageView.setOnClickListener(view -> {
            new AlertDialog.Builder(this)
                    .setView(R.layout.activity_formulario_imagem)
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

        return new Produto(nome, descricao, preco);
    }


    @Override
    protected void onResume() {
        super.onResume();


    }
}