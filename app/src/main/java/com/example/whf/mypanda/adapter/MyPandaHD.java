package com.example.whf.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.entity.PandaHD;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/2.
 * at 北京
 */

public class MyPandaHD extends RecyclerView.Adapter<MyPandaHD.ViewHolder> {
    private List<PandaHD.InteractiveBean> interactive;
    private Context con;
    private OnClickListenre listenre;

    public MyPandaHD(List<PandaHD.InteractiveBean> interactive, Context con) {
        this.interactive = interactive;
        this.con = con;
    }

    public MyPandaHD.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(con).inflate(R.layout.item_hd, parent, false);
        ViewHolder holder = new ViewHolder(inflate);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyPandaHD.ViewHolder holder, final int position) {
        holder.tetle_hd.setText(interactive.get(position).getTitle());
        Picasso.with(con).load(interactive.get(position).getImage()).into(holder.image_hd);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenre.OnClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return interactive.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tetle_hd;
        private final ImageView image_hd;

        public ViewHolder(View itemView) {
            super(itemView);
            tetle_hd = itemView.findViewById(R.id.tetle_hd);
            image_hd = itemView.findViewById(R.id.image_hd);
        }
    }

    public interface OnClickListenre {

        void OnClick(int position);

    }

    public void setOnClickListenre(OnClickListenre listenre) {
        this.listenre = listenre;
    }
}
