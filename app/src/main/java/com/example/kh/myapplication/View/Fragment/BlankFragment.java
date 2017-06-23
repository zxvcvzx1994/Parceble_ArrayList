package com.example.kh.myapplication.View.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kh.myapplication.Module.RecyclerView.MyClass;
import com.example.kh.myapplication.Module.RecyclerView.MyRecyclerView;
import com.example.kh.myapplication.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private ArrayList<MyClass>   list = new ArrayList<MyClass>();
    private List<MyClass>   list1 = new ArrayList<MyClass>();

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        addlist();
        if(savedInstanceState!=null){
            list1 = savedInstanceState.getParcelableArrayList("list");

        }
        MyRecyclerView adapter = new MyRecyclerView(getActivity(),list1);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("list", list);
    }

    private void addlist() {

        Date a = java.sql.Date.valueOf("2013-02-12");

        list.add(new MyClass("vinh1",a));
        list.add(new MyClass("vinh2",a));
        list.add(new MyClass("vinh3",a));
        list.add(new MyClass("vinh4",a));
    }
}
