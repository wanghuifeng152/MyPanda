package com.example.whf.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.greendao.Collection;
import com.example.whf.mypanda.R;
import com.example.whf.mypanda.activity.CollectionActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/11.
 * at 北京
 */

public class MyAdapterColler extends RecyclerView.Adapter<MyAdapterColler.ViewHodler> {
    private List<Collection> collections;
    private Context con;
    private OnClickListenre listenre;
    int mEditMode = -1;
    private static final int MYLIVE_MODE_CHECK = 0;
    private static final int MYLIVE_MODE_EDIT = 1; ;
    private static final int MYLIVE_MODE_NOCHECK = 2;
    private static final int MYLIVE_MODE_FINISH = 3;
private boolean Checdbaod;
    private onclicklist licklist;

    public MyAdapterColler(List<Collection> collections, Context con) {
        this.collections = collections;
        this.con = con;
    }
    public void setEditMode(int editMode) {
        mEditMode = editMode;
        notifyDataSetChanged();
    }

    public MyAdapterColler.ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(con).inflate(R.layout.item_baob, parent, false);
        ViewHodler hodler = new ViewHodler(inflate);
        return hodler;

    }

    @Override
    public void onBindViewHolder(MyAdapterColler.ViewHodler holder, final int position) {
        holder.text_gt.setText(collections.get(position).getTitlr());
        Picasso.with(con).load(collections.get(position).getImage()).into(holder.image_g);
        final CheckBox ch_b = holder.ch_b;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenre.OnClick(position);
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

    }

    @Override
    public int getItemCount() {
        return collections.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private final ImageView image_g;
        private final TextView text_gt;
        private final CheckBox ch_b;


        public ViewHodler(View itemView) {
            super(itemView);
            image_g = itemView.findViewById(R.id.image_jx);
            text_gt = itemView.findViewById(R.id.text_title);
            ch_b = itemView.findViewById(R.id.ch_b);

        }
    }

    public interface OnClickListenre{

        void OnClick(int position);
    }

    public void setOnClickListenre(OnClickListenre listenre){
        this.listenre = listenre;
    }

    public interface onclicklist{
        void onCheckb(int position,boolean Checdbaod);
    }
    public void SetOnClicklist(onclicklist licklist){
        this.licklist = licklist;
    }
}
