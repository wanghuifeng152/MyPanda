package com.example.whf.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.entity.MyPandaShiJZ;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/4.
 * at 北京
 */

public class MyPandaDuoSj extends RecyclerView.Adapter<MyPandaDuoSj.ViewHolder> {
    private List<MyPandaShiJZ.ListBean> list;
    private Context con;
    private OnClickListenre listenre;

    public MyPandaDuoSj(List<MyPandaShiJZ.ListBean> list, Context con) {
        this.list = list;
        this.con = con;
    }

    public MyPandaDuoSj.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(con).inflate(R.layout.item_sytwo, parent, false);
        ViewHolder holder = new ViewHolder(inflate);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyPandaDuoSj.ViewHolder holder, final int position) {
        holder.text_xc.setText(list.get(position).getTitle());
        Picasso.with(con).load(list.get(position).getImage()).into(holder.image_xc);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            listenre.OnClick(position);
        }
    });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image_xc;
        private final TextView text_xc;

        public ViewHolder(View itemView) {
            super(itemView);
            image_xc = itemView.findViewById(R.id.image_xc);
            text_xc = itemView.findViewById(R.id.text_xc);
        }
    }

    public interface OnClickListenre{

        void OnClick(int position);
    }

    public void setOnClickListenre(OnClickListenre listenre){
        this.listenre = listenre;
    }
}
