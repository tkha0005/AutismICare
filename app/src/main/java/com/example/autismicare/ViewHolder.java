package com.example.autismicare;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder  extends RecyclerView.ViewHolder {

    private TextView ref = null;
    private ImageView imagee = null;



    public ViewHolder(View view) {
        super(view);


        ref = (TextView)view.findViewById(R.id.ref);
        imagee = (ImageView)view.findViewById(R.id.imagee);

    }


    public TextView getRef()
    {
        return ref;
    }

    public ImageView getImagee()
    {
        return imagee;
    }
}


