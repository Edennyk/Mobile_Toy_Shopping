package com.example.Toy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import java.util.List;

public class CustomListAdaptor extends ArrayAdapter<Toys> {
    Context mContext;
    List<Toys> toysList;
    int resource;

    public CustomListAdaptor(Context mContext, int resource, List<Toys> toysList) {
        super(mContext, resource, toysList);

        this.mContext = mContext;
        this.resource = resource;
        this.toysList = toysList;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

        View view = inflater.inflate(resource,null); //in place of resource we can pass R.layout.my_list_items

        //referencing /initializing the textview and imageview
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewAuthor = view.findViewById(R.id.textViewAuthor);
        TextView textViewDescription = view.findViewById(R.id.textViewDescription);
        TextView textViewPrice = view.findViewById(R.id.textViewPrice);
        ImageView imageView = view.findViewById(R.id.myImageView);

        final Toys toys = toysList.get(position); //initializing Toys to get appropriate position

        textViewName.setText(toys.getName()); //setting data to text/image view
        textViewAuthor.setText(toys.getCompany());
        textViewDescription.setText(toys.getDescription());
        textViewPrice.setText(toys.getPrice());
        imageView.setImageDrawable(mContext.getResources().getDrawable(toys.getImage()));

        view.findViewById(R.id.addSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //selectItem(position);
                CartActivity.cartList.add(toys);
                //mContext.startActivity(new Intent(mContext, CartActivity.class));
                Toast.makeText(mContext,"A toy added!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
