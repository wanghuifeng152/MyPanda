package com.example.whf.mypanda.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.greendao.History;
import com.example.whf.mypanda.R;
import com.google.android.exoplayer.C;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/18.
 * at 北京
 */

public class MyAdapterHisto extends RecyclerView.Adapter<MyAdapterHisto.ViewHolder> {
    private List<History> histories;
    private Context con;
    private OnClickListenre listtenre;
    private boolean Checdbaod;
    private onclicklist licklist;
    int mEditMode = -1;
    private static final int MYLIVE_MODE_CHECK = 0;
    private static final int MYLIVE_MODE_EDIT = 1; ;
    private static final int MYLIVE_MODE_NOCHECK = 2;
    private static final int MYLIVE_MODE_FINISH = 3;
    public MyAdapterHisto(List<History> histories, Context con) {
        this.histories = histories;
        this.con = con;
    }
    public void setEditMode(int editMode) {
        mEditMode = editMode;
        notifyDataSetChanged();
    }
    public MyAdapterHisto.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(con).inflate(R.layout.item_gung, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapterHisto.ViewHolder holder, final int position) {
        holder.text_sum_ls.setText(histories.get(position).getSum());
        holder.text_tilte_ls.setText(histories.get(position).getTitlr());
        holder.text_tim_ls.setText(histories.get(position).getStims());
        Picasso.with(con).load(histories.get(position).getImage()).into(holder.image_ls);
        final CheckBox ch_b = holder.ch_b;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listtenre.onclick(position);
            }
        });
        ch_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ch_b.isSelected()){
                    ch_b.setSelected(false);
                }else{
                    ch_b.setSelected(true);
                }
                licklist.onCheckb(position,ch_b.isSelected());
            }
        });
        switch (mEditMode) {
            case MYLIVE_MODE_EDIT:
                ch_b.setVisibility(View.VISIBLE);
                break;
            case MYLIVE_MODE_FINISH:
                ch_b.setSelected(false);
                ch_b.setVisibility(View.GONE);
                break;
            case MYLIVE_MODE_CHECK:
                ch_b.setSelected(true);
                break;
            case MYLIVE_MODE_NOCHECK:
                ch_b.setSelected(false);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView text_sum_ls;
        private final TextView text_tilte_ls;
        private final TextView text_tim_ls;
        private final ImageView image_ls;
        private final CheckBox ch_b;
        public ViewHolder(View itemView) {
            super(itemView);
            image_ls = itemView.findViewById(R.id.image_jx);
            text_tim_ls = itemView.findViewById(R.id.text_tim);
            text_tilte_ls = itemView.findViewById(R.id.text_title);
            text_sum_ls = itemView.findViewById(R.id.text_sum);
            ch_b = itemView.findViewById(R.id.ch_b);

        }
    }

    public interface OnClickListenre{

        void onclick(int position);
    }
    public void setOnClickListenre(OnClickListenre lilistenre){
        this.listtenre = lilistenre;
    }
    public interface onclicklist{
        void onCheckb(int position,boolean Checdbaod);
    }
    public void SetOnClicklist(onclicklist licklist){
        this.licklist = licklist;
    }
}
