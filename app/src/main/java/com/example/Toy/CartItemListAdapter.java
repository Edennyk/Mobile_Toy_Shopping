package com.example.Toy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

public class CartItemListAdapter extends ArrayAdapter<Toys> {
    Context context;
    List<Toys> toylist;
    int resource;

    public CartItemListAdapter(Context context, int resource, List<Toys> toylist) {
        super(context, resource, toylist);
        this.context = context;
        this.resource = resource;
        this.toylist = toylist;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(resource,null);

        ImageView toyPic = view.findViewById(R.id.ivCartPic);
        final TextView toyName = view.findViewById(R.id.tvCartToyName);
        TextView price = view.findViewById(R.id.tvCartPrice);

        Toys toy = toylist.get(position);
        toyPic.setImageDrawable(context.getResources().getDrawable(toy.getImage()));
        toyName.setText(toy.getName());
        price.setText(toy.getPrice());
        view.findViewById(R.id.ibtnRemove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Toys b: CartActivity.cartList){
                    if(b.getName() == toyName.getText()){
                        CartActivity.cartList.remove(CartActivity.cartList.indexOf(b));
                        notifyDataSetChanged();
                        return;
                    }
                }
            }
        });

        return view;
    }
}
