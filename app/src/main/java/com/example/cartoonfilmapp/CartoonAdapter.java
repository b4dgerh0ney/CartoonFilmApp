package com.example.cartoonfilmapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartoonAdapter extends RecyclerView.Adapter<CartoonAdapter.CartoonViewHolder> {

    private List<Cartoon> cartoonList;
    private OnCartoonClickListener onCartoonClickListener;


    public CartoonAdapter(List<Cartoon> cartoonList, OnCartoonClickListener onCartoonClickListener) {
        this.cartoonList = cartoonList;
        this.onCartoonClickListener = onCartoonClickListener;
    }

    @Override
    public CartoonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartoon_item, parent, false);
        return new CartoonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartoonViewHolder holder, int position) {
        Cartoon cartoon = cartoonList.get(position);
        holder.cartoonNameTextView.setText(cartoon.getName());
        holder.cartoonImageView.setImageResource(cartoon.getImageResId());
    }

    @Override
    public int getItemCount() {
        return cartoonList.size();
    }

    public interface OnCartoonClickListener {
        void onCartoonClick(Cartoon cartoon);
    }

    public class CartoonViewHolder extends RecyclerView.ViewHolder {

        TextView cartoonNameTextView;
        ImageView cartoonImageView;

        public CartoonViewHolder(View itemView) {
            super(itemView);
            cartoonNameTextView = itemView.findViewById(R.id.cartoonNameTextView);
            cartoonImageView = itemView.findViewById(R.id.cartoonImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCartoonClickListener.onCartoonClick(cartoonList.get(getAdapterPosition()));
                }
            });
        }
    }
}
