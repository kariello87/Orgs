package br.com.alura.orgs.ui.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.orgs.R;
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding;

public class FormularioProdutoActivity extends AppCompatActivity {


    private ActivityFormularioProdutoBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produto);


        binding = ActivityFormularioProdutoBinding.inflate(getLayoutInflater());
        binding.btSalvar.setOnClickListener(view -> {
            String nome2 = binding.editNome.getText().toString();
            Toast.makeText(this, nome2, Toast.LENGTH_SHORT).show();
        });
        setContentView(binding.getRoot());


    }


}