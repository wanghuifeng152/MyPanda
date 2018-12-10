package com.example.whf.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.entity.PandaGung;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/3.
 * at 北京
 */

public class MyPandasyGung extends RecyclerView.Adapter<MyPandasyGung.ViewHolder> {
    private List<PandaGung.ListBean> listbeans;
    private Context con;

    public MyPandasyGung(List<PandaGung.ListBean> listbeans, Context con) {
        this.listbeans = listbeans;
        this.con = con;
    }

    public MyPandasyGung.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(con).inflate(R.layout.item_sygung, parent, false);
        ViewHolder holder = new ViewHolder(inflate);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyPandasyGung.ViewHolder holder, int position) {
        holder.title_gung.setText(listbeans.get(position).getTitle());
        holder.text_gung.setText(listbeans.get(position).getDaytime());
        Picasso.with(con).load(listbeans.get(position).getImage()).into(holder.image_gung);
        holder.text_sum.setText(listbeans.get(position).getVideoLength());
    }

    @Override
    public int getItemCount() {
        return listbeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image_gung;
        private final TextView title_gung;
        private final TextView text_gung;
        private final TextView text_sum;

        public ViewHolder(View itemView) {
            super(itemView);
            image_gung = itemView.findViewById(R.id.image_gung);
            title_gung = itemView.findViewById(R.id.title_gung);
            text_gung = itemView.findViewById(R.id.text_gung);
            text_sum = itemView.findViewById(R.id.text_sum);
        }
    }
}
