package br.com.alura.orgs;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.orgs.databinding.ActivityMainBinding;

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

        binding.nome.setText("Cesta de Frutas");
        binding.descricao.setText("maçã, limão, pêra");
        binding.valor.setText("R$ 5,99");


        setContentView(binding.getRoot());

        Toast.makeText(this, "Olá Mundo", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;

    }
}
