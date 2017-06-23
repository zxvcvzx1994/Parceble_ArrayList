package com.example.kh.myapplication.Module.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kh.myapplication.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kh on 6/23/2017.
 */

public class MyRecyclerView extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<MyClass> list = new ArrayList<MyClass>();
    public MyRecyclerView(Context context, List<MyClass> list){
        this.context= context;
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       MyClass myClass =  list.get(position);
        holder.txtName.setText(myClass.getName());
        Date a = myClass.getData();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        holder.txtdata.setText(df.format(a));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
   class MyViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.data)
    TextView txtdata ;
    @BindView(R.id.txtName)
    TextView txtName;
    public MyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
