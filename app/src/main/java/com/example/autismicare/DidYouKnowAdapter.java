package com.example.autismicare;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DidYouKnowAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Model> models;

    public DidYouKnowAdapter(List<Model> models)
    {
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.dyk_row , viewGroup , false);
        final TextView ref = (TextView)view.findViewById(R.id.ref);
        final ImageView imagee = (ImageView) view.findViewById(R.id.imagee);
        ViewHolder views = new ViewHolder(view);
        return views;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Model mm = models.get(i);
        viewHolder.getRef().setText(mm.getRef());
        Picasso.get()
                .load(mm.getImage())
                .resize(500 , 500)
                .into(viewHolder.getImagee());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
