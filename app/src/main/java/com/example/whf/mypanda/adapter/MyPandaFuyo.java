package com.example.whf.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.entity.MyPandaFuYON;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/7.
 * at 北京
 */

public class MyPandaFuyo extends RecyclerView.Adapter<MyPandaFuyo.ViewHolder> {
    private List<MyPandaFuYON.VideoBean> video;
    private Context con;

    public MyPandaFuyo(List<MyPandaFuYON.VideoBean> video, Context con) {
        this.video = video;
        this.con = con;
    }

    public MyPandaFuyo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(con).inflate(R.layout.item_fuyong, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyPandaFuyo.ViewHolder holder, int position) {
        Picasso.with(con).load(video.get(position).getImg()).into(holder.image_f);
        holder.text_f.setText(video.get(position).getLen());
        holder.time_f.setText(video.get(position).getPtime());
        holder.title_f.setText(video.get(position).getT());
    }

    @Override
    public int getItemCount() {
        return video.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image_f;
        private final TextView text_f;
        private final TextView title_f;
        private final TextView time_f;

        public ViewHolder(View itemView) {
            super(itemView);
            image_f = itemView.findViewById(R.id.image);
            text_f = itemView.findViewById(R.id.textView);
            title_f = itemView.findViewById(R.id.title);
            time_f = itemView.findViewById(R.id.time);

        }
    }
}
