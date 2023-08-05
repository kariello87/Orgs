package br.com.alura.orgs.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.alura.orgs.R;
import br.com.alura.orgs.model.Produto;

public class ListaDeProdutosAdapter extends RecyclerView.Adapter {

    private final Context context;
    private List<Produto> produtos;


    public ListaDeProdutosAdapter(List<Produto> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }


    @NonNull
    @Override
    public NossoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.produto_item, parent, false);
        return new NossoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Produto produto = produtos.get(position);
        NossoViewHolder nossoViewHolder = (NossoViewHolder) holder;
        nossoViewHolder.vincula(produto);

    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }


    public void atualiza(List<Produto> produtos) {
        this.produtos = produtos;
        notifyDataSetChanged(); //ATENÇÃO - NOTIFICA QUE OS DADOS FORAM MODIFICADOS. ADAPTER REFAZ TODOS OS PASSOS

    }
}

class NossoViewHolder extends RecyclerView.ViewHolder {


    public NossoViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    private static String formataValorEmMoedaNacional(BigDecimal valor) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
        String valorEmMoedaNacional = numberFormat.format(valor);
        return valorEmMoedaNacional;
    }

    public void vincula(Produto produto) {
        TextView nome = itemView.findViewById(R.id.nome);
        nome.setText(produto.getNome());
        TextView descricao = itemView.findViewById(R.id.descricao);
        descricao.setText(produto.getDescricao());
        TextView preco = itemView.findViewById(R.id.valor);
        String valorEmMoedaNacional = formataValorEmMoedaNacional(produto.getPreco());
        preco.setText(valorEmMoedaNacional);
        ImageView imagemProdutoItem = itemView.findViewById(R.id.produto_item_imageView);

        //Caso não haja imagem alguma carregada, ele some com a ImageView

        if (produto.getUrlImagem() != null) {
            imagemProdutoItem.setVisibility(View.VISIBLE);
        } else {
            imagemProdutoItem.setVisibility(View.GONE);
        }


        Picasso.get().load(produto.getUrlImagem()).into(imagemProdutoItem, new Callback() {
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
