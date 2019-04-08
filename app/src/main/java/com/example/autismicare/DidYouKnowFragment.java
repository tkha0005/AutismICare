package com.example.autismicare;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class DidYouKnowFragment extends Fragment {

    private List<Model> models = null;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_did_you_know, null);
        getActivity().setTitle("Did You Know");

        initializeDataItemList();
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setHasFixedSize(true);
        DidYouKnowAdapter didYouKnowAdapter = new DidYouKnowAdapter(models);
        recyclerView.setAdapter(didYouKnowAdapter);



        return view;


    }


    private void initializeDataItemList() {
        if(models == null) {
            models = new ArrayList<Model>();
            models.add(new Model("Reference:Factretriever" , R.drawable.a));
            models.add(new Model("Reference:Mrsgonzalez" , R.drawable.b));
            models.add(new Model("Reference:ABC News" , R.drawable.c));
            models.add(new Model("Reference:ABC News" , R.drawable.d));
            models.add(new Model("Reference:ABC News" , R.drawable.e));
            models.add(new Model("Reference:ABC News" , R.drawable.f));
            models.add(new Model("Reference:Autism Speaks" , R.drawable.g));
            models.add(new Model("Reference:ABC News" , R.drawable.h));
            models.add(new Model("Reference:GetHealthyStayHealthy" , R.drawable.i));
            models.add(new Model("Reference:GetHealthyStayHealthy" , R.drawable.j));
            models.add(new Model("Reference:Spectrum News" , R.drawable.k));
            models.add(new Model("Reference:NYTimes" , R.drawable.l));
            models.add(new Model("Reference:ABC News" , R.drawable.m));
            models.add(new Model("Reference:Teaching Children with Autism" , R.drawable.n));
            models.add(new Model("Click Here For Tableau:http://bit.ly/T4Bleau" , R.drawable.o));
            models.add(new Model("Reference:AIHW" , R.drawable.p));
            models.add(new Model("Reference:AIHW" , R.drawable.q));
            models.add(new Model("Reference:AIHW" , R.drawable.r));
            models.add(new Model("Reference:AIHW" , R.drawable.s));
            models.add(new Model("Reference:Positive Facts in Autism" , R.drawable.t));



        }
    }


}