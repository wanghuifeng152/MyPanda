package com.example.whf.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.entity.PandaJinCai;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/3.
 * at 北京
 */

public class MyPabdaSyFour extends RecyclerView.Adapter<MyPabdaSyFour.ViewHolder> {
    private List<PandaJinCai.ListBean> listBeans;
    private Context con;

    public MyPabdaSyFour(List<PandaJinCai.ListBean> listBeans, Context con) {
        this.listBeans = listBeans;
        this.con = con;
    }

    public MyPabdaSyFour.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(con).inflate(R.layout.item_jinc, parent, false);
        ViewHolder holder = new ViewHolder(inflate);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyPabdaSyFour.ViewHolder holder, int position) {
        holder.text_title.setText(listBeans.get(position).getTitle());
        Picasso.with(con).load(listBeans.get(position).getImage()).into(holder.image_jx);
        holder.text_sum.setText(listBeans.get(position).getDaytime());
        holder.text_tim.setText(listBeans.get(position).getVideoLength());

    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image_jx;
        private final TextView text_title;
        private final TextView text_sum;
        private final TextView text_tim;


        public ViewHolder(View itemView) {
            super(itemView);
            image_jx = itemView.findViewById(R.id.image_jx);
            text_title = itemView.findViewById(R.id.text_title);
            text_tim=itemView.findViewById(R.id.text_tim);
            text_sum = itemView.findViewById(R.id.text_sum);


        }
    }
}
