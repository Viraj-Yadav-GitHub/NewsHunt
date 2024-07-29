package com.example.newshunt.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newshunt.About;
import com.example.newshunt.Onitemclick.RecyclerItemClickListener;
import com.example.newshunt.PopWebsitesPackage.Adapter1;
import com.example.newshunt.PopWebsitesPackage.Model1;
import com.example.newshunt.R;

import java.util.ArrayList;


public class NewspaperFragment extends Fragment {

    RecyclerView recyclerView ;

    public NewspaperFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_newspaper, container, false);

        recyclerView = view.findViewById(R.id.popWebRv);
        ArrayList<Model1> list = new ArrayList<>();

        list.add(new Model1(R.drawable.timesofindia , "Times Of India"));
        list.add(new Model1(R.drawable. hindustantimes, "Hindustan Times"));
        list.add(new Model1(R.drawable. lokmattimes, "Lokmat Times"));
        list.add(new Model1(R.drawable. bbcnews, "BBC News"));
        list.add(new Model1(R.drawable. theindianexpress, "The Indian Express"));
        list.add(new Model1(R.drawable. theeconomictimes, "The Economic Times"));
        list.add(new Model1(R.drawable. firstindia, "First India"));
        list.add(new Model1(R.drawable. telegraph, "The Telegraph"));
        list.add(new Model1(R.drawable. thehindu, "The Hindu"));
        list.add(new Model1(R.drawable. thehansindia, "The Hans India"));

        Adapter1 adapter1 = new Adapter1(list , getContext());
        recyclerView.setAdapter(adapter1);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


                switch(position){

                    case 0 :  gotoUrl("https://timesofindia.indiatimes.com/"); break;
                    case 1 :  gotoUrl("https://www.hindustantimes.com/"); break;
                    case 2 :  gotoUrl("https://www.lokmattimes.com/"); break;
                    case 3 :  gotoUrl("https://www.bbc.com/news"); break;
                    case 4 :  gotoUrl("https://indianexpress.com/"); break;
                    case 5 :  gotoUrl("https://economictimes.indiatimes.com/"); break;
                    case 6 :  gotoUrl("https://firstindia.co.in/"); break;
                    case 7 :  gotoUrl("https://www.telegraphindia.com/"); break;
                    case 8 :  gotoUrl("https://www.thehindu.com/"); break;
                    case 9 :  gotoUrl("https://www.thehansindia.com/"); break;
                    default:

                }

            }

            @Override
            public void onLongItemClick(View view, int position) {

                Toast.makeText(getContext(), "Click once only !", Toast.LENGTH_LONG).show();
            }
        }

        ));






        return view ;
    }


    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
      startActivity(new Intent(Intent.ACTION_VIEW , uri));

    }




}