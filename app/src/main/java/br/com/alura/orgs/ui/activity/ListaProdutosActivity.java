package br.com.alura.orgs.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.orgs.R;
import br.com.alura.orgs.dao.ProdutosDao;
import br.com.alura.orgs.databinding.ActivityListaProdutosBinding;
import br.com.alura.orgs.ui.recyclerview.adapter.ListaDeProdutosAdapter;

public class ListaProdutosActivity extends AppCompatActivity {
    private ActivityListaProdutosBinding binding;
    private ListaDeProdutosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        binding = ActivityListaProdutosBinding.inflate(getLayoutInflater());
        adapter = new ListaDeProdutosAdapter(ProdutosDao.buscaTodos(), this);
        configuraFAB();
        configuraRecyclerView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.atualiza(ProdutosDao.buscaTodos());

        setContentView(binding.getRoot());
    }

    private void configuraFAB() {
        binding.fab.setOnClickListener(view -> vaiParaFormularioProduto());
    }

    private void vaiParaFormularioProduto() {
        Intent intent = new Intent(this, FormularioProdutoActivity.class);
        startActivity(intent);
    }

    private void configuraRecyclerView() {
        binding.recycleView.setAdapter(adapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;

    }
}
