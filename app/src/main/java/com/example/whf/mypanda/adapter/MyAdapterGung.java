package com.example.whf.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.entity.MyPadnaGUNg;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/7.
 * at 北京
 */

public class MyAdapterGung extends RecyclerView.Adapter<MyAdapterGung.ViewHolder>{
    private List<MyPadnaGUNg.ListBean> list;
    private Context con;
    private OnClickListenre listenre;

    public MyAdapterGung(List<MyPadnaGUNg.ListBean> list, Context con) {
        this.list = list;
        this.con = con;
    }

    @Override
    public MyAdapterGung.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(con).inflate(R.layout.item_gung, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapterGung.ViewHolder holder, final int position) {
        holder.text_g.setText(list.get(position).getVideoLength());
        holder.text_gs.setText(list.get(position).getBrief());
        holder.text_gt.setText(list.get(position).getTitle());
        Picasso.with(con).load(list.get(position).getImage()).into(holder.image_g);
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

        private final ImageView image_g;
        private final TextView text_g;
        private final TextView text_gt;
        private final TextView text_gs;

        public ViewHolder(View itemView) {
            super(itemView);
            image_g = itemView.findViewById(R.id.image_jx);
            text_g = itemView.findViewById(R.id.text_tim);
            text_gt = itemView.findViewById(R.id.text_title);
            text_gs = itemView.findViewById(R.id.text_sum);
        }
    }

    public interface OnClickListenre{

        void OnClick(int position);
    }

    public void setOnClickListenre(OnClickListenre listenre){
        this.listenre = listenre;
    }
}
