package com.example.whf.mypanda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.entity.MyPandaJinC;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/11.
 * at 北京
 */

public class ListViewAdapter4 extends BaseAdapter {

    private List<MyPandaJinC.LiveBean> live;
    private Context context;

    public ListViewAdapter4(List<MyPandaJinC.LiveBean> live, Context context) {
        this.live = live;
        this.context = context;
    }

    @Override
    public int getCount() {
        return live.size();
    }

    @Override
    public Object getItem(int position) {
        return live.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_more2,null);
            holder.iv_image=convertView.findViewById(R.id.iv_image);
            holder.tv_title=convertView.findViewById(R.id.tv_title);
            holder.iv_triangle=convertView.findViewById(R.id.iv_triangle);
            holder.text_item=convertView.findViewById(R.id.text_Item);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(live.get(position).getImage()).into(holder.iv_image);
        holder.tv_title.setText(live.get(position).getTitle());
        holder.text_item.setText(live.get(position).getBrief());

        final ViewHolder finalHolder = holder;
        holder.iv_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalHolder.iv_triangle.setSelected(false);
                finalHolder.iv_triangle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!finalHolder.iv_triangle.isSelected()) {
                            finalHolder.text_item.setVisibility(View.VISIBLE);
                            finalHolder.iv_triangle.setSelected(true);
                        } else {
                            finalHolder.text_item.setVisibility(View.GONE);
                            finalHolder.iv_triangle.setSelected(false);
                        }
                    }
                });
            }
        });

        return convertView;
    }

    class ViewHolder{
        ImageView iv_image;
        TextView tv_title;
        ImageView iv_triangle;
        TextView text_item;
    }
}
