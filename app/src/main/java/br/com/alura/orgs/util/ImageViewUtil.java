package br.com.alura.orgs.util;

import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import br.com.alura.orgs.R;

public abstract class ImageViewUtil {

    public static void tentaCarregarImagem(String urlImagem, ImageView imagemProdutoItem) {
        Picasso.get().load(urlImagem).placeholder(R.drawable.placeholder_carregando).into(imagemProdutoItem, new Callback() {
            @Override
            public void onSuccess() {
            }

            // Caso o Picasso não consigo carregar a imagem do link, ele exibe essa imagem padrão
            @Override
            public void onError(Exception e) {
                Picasso.get().load(R.drawable.erro).into(imagemProdutoItem);

            }
        });

    }
}
