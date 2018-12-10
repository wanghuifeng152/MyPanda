package com.example.whf.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.entity.PandaShY;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/3.
 * at 北京
 */

public class MyPandaSyOne extends RecyclerView.Adapter<MyPandaSyOne.ViewHolder> {
    private List<PandaShY.DataBean.PandaeyeBean.ItemsBean> items;
    private Context con;
    private OnClickListenre listenre;

    public MyPandaSyOne(List<PandaShY.DataBean.PandaeyeBean.ItemsBean> items, Context con) {
        this.items = items;
        this.con = con;
    }

    public MyPandaSyOne.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(con).inflate(R.layout.item_syone, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyPandaSyOne.ViewHolder holder, final int position) {
        holder.text_sybob.setText(items.get(position).getBrief());
        holder.text_sybo.setText(items.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenre.OnClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView text_sybob;
        private final TextView text_sybo;
        public ViewHolder(View itemView) {
            super(itemView);
            text_sybob = itemView.findViewById(R.id.text_sybob);
            text_sybo = itemView.findViewById(R.id.text_sybo);
        }
    }

    public interface OnClickListenre{

        void OnClick(int position);
    }

    public void setOnClickListenre(OnClickListenre listenre){

        this.listenre = listenre;

    }
}
