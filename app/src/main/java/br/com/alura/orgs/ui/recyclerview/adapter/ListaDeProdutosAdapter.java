package br.com.alura.orgs.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.alura.orgs.R;
import br.com.alura.orgs.databinding.ProdutoItemBinding;
import br.com.alura.orgs.model.Produto;

public class ListaDeProdutosAdapter extends RecyclerView.Adapter {

    private final List<Produto> produtos;
    private final Context context;


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
}

class NossoViewHolder extends RecyclerView.ViewHolder {

    private ProdutoItemBinding produtoItemBinding;

    public NossoViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void vincula(Produto produto) {
        TextView nome = itemView.findViewById(R.id.nome);
        nome.setText(produto.getNome());
        TextView descricao = itemView.findViewById(R.id.descricao);
        descricao.setText(produto.getDescricao());
        TextView preco = itemView.findViewById(R.id.valor);
        preco.setText(produto.getPreco().toPlainString());


    }
}
