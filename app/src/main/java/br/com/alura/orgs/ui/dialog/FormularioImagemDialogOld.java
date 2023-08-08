package br.com.alura.orgs.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

import br.com.alura.orgs.databinding.ActivityFormularioImagemBinding;
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding;
import br.com.alura.orgs.util.ImageViewUtil;

public class FormularioImagemDialogOld {

    private ActivityFormularioProdutoBinding binding;
    private ActivityFormularioImagemBinding bindingImagemFormulario;
    private String urlImagem;
    private Context context;

    public FormularioImagemDialogOld(Context context) {
        this.context = context;
    }

    public void mostra(String endereco) {

        bindingImagemFormulario = ActivityFormularioImagemBinding.inflate(LayoutInflater.from(context));
        bindingImagemFormulario.formularioImagemBtCarregar.setOnClickListener(view1 -> {
            urlImagem = bindingImagemFormulario.url.getText().toString();
            if (urlImagem != null && !urlImagem.isBlank()) {
                ImageViewUtil.tentaCarregarImagem(urlImagem, bindingImagemFormulario.formularioImagemImageView);
            }
        });
        new AlertDialog.Builder(context)
                .setView(bindingImagemFormulario.getRoot()).setPositiveButton("Confirmar", (dialogInterface, i) -> {
                    if (urlImagem != null && !urlImagem.isBlank()) {
                        ImageViewUtil.tentaCarregarImagem(endereco, binding.produtoItemImageView);
//                        return endereco;
                    }

                }).setNegativeButton("Cancelar", (dialogInterface, i) -> {
                    //volta sem fazer nada
                })
                .show();
    }
}
