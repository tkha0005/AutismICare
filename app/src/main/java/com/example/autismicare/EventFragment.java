package com.example.autismicare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventFragment  extends Fragment {

    RecyclerView recyclerView;
    private RequestQueue queue;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> urls = new ArrayList<>();
    ArrayList<String> starts = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, null);
        getActivity().setTitle("Upcoming Event");

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerVieweve);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        queue = Volley.newRequestQueue(getContext());
        jsonParse();
        return view;

    }
    private void jsonParse()
    {

        String isoDatePattern = "yyyy-MM-dd'T'HH:mm:dd'Z'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        String dateString = simpleDateFormat.format(new Date());

        String URL = "https://www.eventbriteapi.com/v3/events/search/?"
                + "q=autism&"
                + "sort_by=date&"
                + "location.address=melbourne&"
                + "start_date.range_start="+dateString+"&"
                + "token=FP5N4456EJUYP4KOCVRI";



        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("events");
                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                JSONObject events = jsonArray.getJSONObject(i);

                                JSONObject nams = events.getJSONObject("name");
                                names.add(nams.getString("text"));
                                urls.add(events.getString("url"));

                                JSONObject stars = events.getJSONObject("start");
                                String formatedDate = stars.getString("local").substring(0,10);
                                starts.add(formatedDate);

                            }

                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                        EventAdapter eventAdapter = new EventAdapter(getActivity(),names,urls,starts);
                        recyclerView.setAdapter(eventAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonObjectRequest);


    }


}