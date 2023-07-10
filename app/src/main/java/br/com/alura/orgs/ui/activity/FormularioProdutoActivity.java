package br.com.alura.orgs.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.orgs.R;
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding;

public class FormularioProdutoActivity extends AppCompatActivity {

    private ActivityFormularioProdutoBinding formularioProdutoBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produto);
        String nome = formularioProdutoBinding.editNome.getText().toString();
        Log.i("nome", nome);

    }
}