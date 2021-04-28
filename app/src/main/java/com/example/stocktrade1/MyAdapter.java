package com.example.stocktrade1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stocktrade1.model.BseandNse;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    List<BseandNse> dataholder;
    View.OnLongClickListener onLongClickListener;
    public MyAdapter(Context ctx, ArrayList<BseandNse> modelLists){
        this.dataholder=modelLists; }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Usually involves inflating a layout from XML .here inflating custom layout named single row design
        View itemList= LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_list,null,false);
        // pass the inflated view object to the ViewHolder.
        ViewHolder view=new ViewHolder(itemList);
        itemList.setOnClickListener(this::onClick);
        return view;
    }

    @Override
    // pass data to viewholder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BseandNse mNseBse=dataholder.get(position);
        holder.symbol.setText(""+mNseBse.getSymbolName());
        holder.ltp.setText(""+"₹"+mNseBse.getLtp());

        holder.change.setText(""+"+"+mNseBse.getChange());
        holder.changeper.setText(""+"(+"+mNseBse.getChangePer()+"%)");
    }
    //return no of items
    @Override
    public int getItemCount() {
        return dataholder.size();
    }
    public void onClick(View v){
        onLongClickListener.onLongClick(v);
        return;
    }
    public void onLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener=onLongClickListener;
    }
    //initializing views
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView symbol,exchange,ltp,details,change,changeper;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            symbol=itemView.findViewById(R.id.symbol_name);

            ltp=itemView.findViewById(R.id.ltp);

            change=itemView.findViewById(R.id.change);
            changeper=itemView.findViewById(R.id.change_per);
        }
    }
}
