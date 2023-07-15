package br.com.alura.orgs.ui.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.alura.orgs.R;
import br.com.alura.orgs.dao.ProdutosDao;
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding;
import br.com.alura.orgs.model.Produto;

public class FormularioProdutoActivity extends AppCompatActivity {
    private ActivityFormularioProdutoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produto);
        binding = ActivityFormularioProdutoBinding.inflate(getLayoutInflater());

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
        String nome = binding.editNome.getText().toString();
        String descricao = binding.editDescricao.getText().toString();
        String precoString = binding.editPreco.getText().toString();
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