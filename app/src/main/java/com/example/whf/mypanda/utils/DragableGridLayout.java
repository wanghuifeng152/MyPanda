package com.example.whf.mypanda.utils;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.whf.mypanda.R;

import java.util.List;

public class DragableGridLayout extends GridLayout implements View.OnLongClickListener, View.OnDragListener {

    //在代码里面new对象的时候调用
    public DragableGridLayout(Context context) {
        this(context, null);
    }


    //布局里面声明这个控件的时候调用
    public DragableGridLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    //在布局里面声明这个控件并且用到style样式的时候调用
    public DragableGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setColumnCount(columCount);
        //GridLayout添加或者删除条目过时候度动画
        setLayoutTransition(new LayoutTransition());
}


    //向GridLayout中添加條目
    public void setItems(List<String> list) {
        for (String str : list) {
            addItems(str);
        }

    }

    private int columCount = 3;
    private int margin = 20;

    public void addItems(String str) {
        TextView tv = new TextView(getContext());
        tv.setText(str);
        tv.setGravity(Gravity.CENTER);
        tv.setPadding(0, 10, 0, 10);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels / columCount - margin * 2;
        params.height = LayoutParams.WRAP_CONTENT;
        params.setMargins(margin, 10, margin, 10);
        tv.setLayoutParams(params);
        tv.setBackgroundResource(R.drawable.grid_item_bg);
        addView(tv);

        if (mIsDragable)
            tv.setOnLongClickListener(this);
        else
            tv.setOnLongClickListener(null);


        if (mIsDragable) {
            tv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //可拖拽的GridLayout就删除条目，不可拖拽的GriLayout就添加这个删除的条目
                    if (mItemClickListenner != null) {
                        mItemClickListenner.onDragItemClick(v);
                    }
                }
            });
        } else {
            tv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //不可拖拽的GriLa可拖拽的GridLayout就删除条目，yout就添加这个删除的条目
                    if (mItemClickListenner != null) {
                        mItemClickListenner.onDisDragItemClick(v);
                    }
                }
            });
        }

    }


    private onItemClickListenner mItemClickListenner;

    public interface onItemClickListenner {
            public void onDragItemClick(View view);

        public void onDisDragItemClick(View view);
    }

    public void setOnItemClickListenner(onItemClickListenner listenner) {
        this.mItemClickListenner = listenner;
    }


    private boolean isChange;
    public void setChange(boolean isChange){
        this.isChange=isChange;
    }

    @Override
    public boolean onLongClick(View v) {
        if (isChange){
            mDragView = v;
            v.startDrag(null, new DragShadowBuilder(v), null, 0);
        }
        return false;
    }


    //被拖拽的条目
    private View mDragView;

    //设置当前GridLayout是否能拖拽
    private boolean mIsDragable;

    public void setDragable(boolean isDragable) {
        this.mIsDragable = isDragable;
        if (mIsDragable) {
            setOnDragListener(this);
        } else {
            setOnDragListener(null);
        }

    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {

            //停止拖拽的时候调用一次
            case DragEvent.ACTION_DRAG_ENDED:
                Log.i("TAG", "ENDED");
                break;

            //进入拖拽区域范围内会执行一次
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.i("TAG", "ENTERED");
                break;

            //在拖拽区域范围外松手的时候调用一次
            case DragEvent.ACTION_DRAG_EXITED:
                Log.i("TAG", "EXITED");
                break;

            //拖动的时候会实时执行这个方法
            case DragEvent.ACTION_DRAG_LOCATION:
                Log.i("TAG", "LOCATION");
                int itemIndex = getIndex(event);
                if (itemIndex > -1 && mDragView != null && mDragView != getChildAt(itemIndex)) {
                    removeView(mDragView);
                    addView(mDragView, itemIndex);
                }
                break;

            //开始拖拽的时候调用一次
            case DragEvent.ACTION_DRAG_STARTED:
                Log.i("TAG", "STARTED");
                initRects();
                break;

            //在拖拽区域范围内松手的时候调用一次
            case DragEvent.ACTION_DROP:
                Log.i("TAG", "DROP");
                break;


        }
        return true;
    }


    //判断当前被拖拽的条目是否进入到了某个条目范围内，进入了就返回进入到的那个条目的索引值
    //没进入的话返回-1
    private int getIndex(DragEvent event) {
        for (int i = 0; i < rects.length; i++) {
            if (rects[i].contains((int) event.getX(), (int) event.getY())) {
                return i;
            }
        }
        return -1;
    }

    //将所有的条目都封装成矩形对象
    private Rect[] rects;

    private void initRects() {
        int childCount = getChildCount();
        rects = new Rect[childCount];
        for (int i = 0; i < childCount; i++) {
            View itemView = getChildAt(i);
            Rect rect = new Rect(itemView.getLeft(), itemView.getTop(),
                    itemView.getRight(), itemView.getBottom());
            rects[i] = rect;
        }
    }


}