package com.example.whf.mypanda.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.constants.Urls;
import com.example.whf.mypanda.entity.PandaDuosj;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PinlFragment extends BaseFragment implements View.OnClickListener {

    private HomePersenter mshouYFragment;
    private EditText edit_pl;
    private Button but_pl;
    private RecyclerView recycl;

    @Override
    protected void loadData() {
        mshouYFragment = new HomePersenter(Urls.BASEURL11, this, PandaDuosj.class);
        mshouYFragment.start();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pinl, container, false);
        initView(view);
        return view;
    }

    protected void initView(View view) {
        edit_pl = (EditText) view.findViewById(R.id.edit_pl);
        but_pl = (Button) view.findViewById(R.id.but_pl);
        recycl = (RecyclerView) view.findViewById(R.id.recycl);

        but_pl.setOnClickListener(this);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_pinl;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_pl:

                break;
        }
    }

    private void submit() {
        // validate
        String pl = edit_pl.getText().toString().trim();
        if (TextUtils.isEmpty(pl)) {
            Toast.makeText(getContext(), "添加评论.....", Toast.LENGTH_SHORT).show();
            return;
        }



    }

    @Override
    public void onSucess(Object o) {

    }

    @Override
    public void onFaile(String msg) {

    }

    @Override
    public void setPresenter(HomePersenter presenter) {
        this.mshouYFragment = presenter;
    }
}
