package br.com.alura.orgs.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
        binding.produtoItemImageView.setOnClickListener(view -> {
            new AlertDialog.Builder(this)
                    .setView(R.layout.formulario_imagem)
                    .show();
            Button botaoCarregar = findViewById(R.id.formulario_imagem_bt_carregar);
            botaoCarregar.setOnClickListener(view1 -> Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show());

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