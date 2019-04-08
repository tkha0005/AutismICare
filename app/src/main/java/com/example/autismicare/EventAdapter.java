package com.example.autismicare;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {
    ArrayList<String> names;
    ArrayList<String> urls;
    ArrayList<String> starts;
    Context context;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(int i);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListeners)
    {
        onItemClickListener = onItemClickListeners;

    }
    public EventAdapter(Context context, ArrayList<String> names , ArrayList<String> urls , ArrayList<String> starts)
    {
        this.context = context;
        this.names = names;
        this.urls = urls;
        this.starts = starts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_row , viewGroup , false);
        MyViewHolder myViewHolder = new MyViewHolder(view,onItemClickListener);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(names.get(i));
        myViewHolder.start.setText(starts.get(i));
        myViewHolder.url.setText(urls.get(i));

    }

    @Override
    public int getItemCount() {
        return names.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,start,url;

        public MyViewHolder(View view , final OnItemClickListener onItemClickListener)
        {
            super(view);
            name = (TextView)view.findViewById(R.id.event_name);
            start = (TextView)view.findViewById(R.id.event_time);
            url = (TextView)view.findViewById(R.id.event_url);


        }

    }
}
