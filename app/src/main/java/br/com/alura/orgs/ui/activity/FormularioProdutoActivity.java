package br.com.alura.orgs.ui.activity;

import android.os.Bundle;
import android.util.Log;

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

        binding.btSalvar.setOnClickListener(view -> {
            String nome = binding.editNome.getText().toString();
            String descricao = binding.editDescricao.getText().toString();
            String precoString = binding.editPreco.getText().toString();
            BigDecimal preco;

            if (precoString.isBlank()) {
                preco = BigDecimal.ZERO;
            } else {
                preco = new BigDecimal(precoString);
            }

            Produto produto = new Produto(nome, descricao, preco);

            Log.i("Produto", produto.toString());

            ProdutosDao.adiciona(produto);
            Log.i("ProdutoS", ProdutosDao.buscaTodos().toString());
            finish();

        });

        setContentView(binding.getRoot());
    }


    @Override
    protected void onResume() {
        super.onResume();


    }
}