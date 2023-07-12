package br.com.alura.orgs.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.orgs.R;
import br.com.alura.orgs.dao.ProdutosDao;
import br.com.alura.orgs.databinding.ActivityMainBinding;
import br.com.alura.orgs.ui.recyclerview.adapter.ListaDeProdutosAdapter;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.recycleView.setAdapter(new ListaDeProdutosAdapter(ProdutosDao.buscaTodos(), this));
//        binding.recycleView.setLayoutManager(new LinearLayoutManager(this)); COLOCADO NO CODIGO DE LAYOUT

        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(view -> {
            Intent intent = new Intent(this, FormularioProdutoActivity.class);
            startActivity(intent);
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;

    }
}
