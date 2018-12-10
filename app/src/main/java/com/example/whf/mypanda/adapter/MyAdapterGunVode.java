package com.example.whf.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.entity.MyGungVode;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/8.
 * at 北京
 */

public class MyAdapterGunVode extends RecyclerView.Adapter<MyAdapterGunVode.ViewHolder> {
    private List<MyGungVode.VideoBean> video;
    private Context con;

    public MyAdapterGunVode(List<MyGungVode.VideoBean> video, Context con) {
        this.video = video;
        this.con = con;
    }

    public MyAdapterGunVode.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(con).inflate(R.layout.item_gunvode, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapterGunVode.ViewHolder holder, int position) {
        holder.time_gv.setText(video.get(position).getLen());
        holder.title_gv.setText(video.get(position).getT());
        Picasso.with(con).load(video.get(position).getImg()).into(holder.image_gv);

    }

    @Override
    public int getItemCount() {
        return video.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image_gv;
        private final TextView time_gv;
        private final TextView title_gv;
        public ViewHolder(View itemView) {
            super(itemView);
            image_gv = itemView.findViewById(R.id.image_jx);
            time_gv = itemView.findViewById(R.id.text_tim);
            title_gv = itemView.findViewById(R.id.text_title);

        }
    }

}
