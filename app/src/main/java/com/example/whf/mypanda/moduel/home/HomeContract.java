package com.example.whf.mypanda.moduel.home;

import com.example.whf.mypanda.moduel.IPresenter;
import com.example.whf.mypanda.moduel.IView;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;

/**
 * Created by WHF
 * on 2018/4/2.
 * at 北京
 */

public interface HomeContract {
    public interface BaseHomePresenter extends IPresenter {

    }

    public interface BaseHomeView extends IView {
        public void setPresenter(HomePersenter presenter);
    }

}
