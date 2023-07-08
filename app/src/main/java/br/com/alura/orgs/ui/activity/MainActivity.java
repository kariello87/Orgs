package br.com.alura.orgs.ui.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import br.com.alura.orgs.R;
import br.com.alura.orgs.databinding.ActivityMainBinding;
import br.com.alura.orgs.databinding.ProdutoItemBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ProdutoItemBinding produtoItemBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //jeito antigo de fazer
        /*TextView viewNome = findViewById(R.id.nome);
        viewNome.setText("Cesta de Frutas");*/

        //JEITO NOVO DE FAZER


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        produtoItemBinding = ProdutoItemBinding.inflate(getLayoutInflater());

        RecyclerView.Adapter adapter = binding.recycleView.getAdapter();


        produtoItemBinding.nome.setText("Cesta de Frutas");
        produtoItemBinding.descricao.setText("maçã, limão, pêra");
        produtoItemBinding.valor.setText("R$ 5,99");


        setContentView(binding.getRoot());

        Toast.makeText(this, "Olá Mundo", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;

    }
}
