package br.com.alura.orgs.ui.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.orgs.R;
import br.com.alura.orgs.databinding.ActivityMainBinding;
import br.com.alura.orgs.model.Produto;
import br.com.alura.orgs.ui.recyclerview.adapter.ListaDeProdutosAdapter;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //jeito antigo de fazer
        /*TextView viewNome = findViewById(R.id.nome);
        viewNome.setText("Cesta de Frutas");*/

        //JEITO NOVO DE FAZER


        binding = ActivityMainBinding.inflate(getLayoutInflater());

        Produto p1 = new Produto("Maçã", "Gala", new BigDecimal("5.99"));
        Produto p2 = new Produto("Manga", "Palmer", new BigDecimal("1.99"));
        Produto p3 = new Produto("Uva", "Itália", new BigDecimal("8.99"));
        ArrayList<Produto> produtos = new ArrayList<>(List.of(p1, p2, p3));

        binding.recycleView.setAdapter(new ListaDeProdutosAdapter(produtos, this));
//        binding.recycleView.setLayoutManager(new LinearLayoutManager(this)); COLOCADO NO CODIGO DE LAYOUT


        setContentView(binding.getRoot());

        Toast.makeText(this, "Olá Mundo", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;

    }
}
