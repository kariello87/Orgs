package br.com.alura.orgs.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

import br.com.alura.orgs.databinding.ActivityFormularioImagemBinding;
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding;
import br.com.alura.orgs.util.ImageViewUtil;

public class FormularioImagemDialog {

    private ActivityFormularioImagemBinding binding;

    private ActivityFormularioProdutoBinding activityFormularioProdutoBinding;
    private String urlImagem;
    private Context context;

    public FormularioImagemDialog(Context context) {
        this.context = context;
    }

    public void mostra(OnImageURLSelectedListener listener) {

        binding = ActivityFormularioImagemBinding.inflate(LayoutInflater.from(context));
        activityFormularioProdutoBinding = ActivityFormularioProdutoBinding.inflate(LayoutInflater.from(context));
        binding.formularioImagemBtCarregar.setOnClickListener(view1 -> {
            urlImagem = binding.url.getText().toString();
            if (urlImagem != null && !urlImagem.isBlank()) {
                ImageViewUtil.tentaCarregarImagem(urlImagem, binding.formularioImagemImageView);
            }
        });

        new AlertDialog.Builder(context)
                .setView(binding.getRoot()).setPositiveButton("Confirmar", (dialogInterface, i) -> {
                    if (urlImagem != null && !urlImagem.isBlank()) {
                        ImageViewUtil.tentaCarregarImagem(urlImagem, activityFormularioProdutoBinding.produtoItemImageView);
                        if (listener != null) {
                            listener.onImageURLSelected(urlImagem);
                        }
                    }

                }).setNegativeButton("Cancelar", (dialogInterface, i) -> {
                    //volta sem fazer nada
                })
                .show();
    }

    public interface OnImageURLSelectedListener {
        void onImageURLSelected(String imageUrl);
    }
}
