package br.com.alura.orgs.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

import br.com.alura.orgs.databinding.ActivityFormularioImagemBinding;
import br.com.alura.orgs.util.ImageViewUtil;

public class FormularioImagemDialog {

    private final Context context;
    private ActivityFormularioImagemBinding binding;
    private String urlImagem;

    public FormularioImagemDialog(Context context) {
        this.context = context;
    }

    public void mostra(String urlPadrao, InterfaceImagem enderecoDaImagem) {

        binding = ActivityFormularioImagemBinding.inflate(LayoutInflater.from(context));

        if (urlPadrao != null) {
            ImageViewUtil.tentaCarregarImagem(urlPadrao, binding.formularioImagemImageView);
            binding.url.setText(urlPadrao);
        }

        binding.formularioImagemBtCarregar.setOnClickListener(view1 -> {
            urlImagem = binding.url.getText().toString();
            if (!urlImagem.isBlank()) {
                ImageViewUtil.tentaCarregarImagem(urlImagem, binding.formularioImagemImageView);
            }
        });

        new AlertDialog.Builder(context)
                .setView(binding.getRoot()).setPositiveButton("Confirmar", (dialogInterface, i) -> {
                    if (urlImagem != null && !urlImagem.isBlank()) {
                        if (enderecoDaImagem != null) {
                            enderecoDaImagem.quandoImagemCarregada(urlImagem);
                        }
                    }

                }).setNegativeButton("Cancelar", (dialogInterface, i) -> {
                    //volta sem fazer nada
                })
                .show();
    }

    public interface InterfaceImagem {
        void quandoImagemCarregada(String imageUrl);
    }
}
