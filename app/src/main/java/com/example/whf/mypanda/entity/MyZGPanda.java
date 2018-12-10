package com.example.whf.mypanda.entity;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/10.
 * at 北京
 */

public class MyZGPanda {

    private List<LiveBean> live;

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }

    public static class LiveBean {
        /**
         * title : 黄花城水长城01
         * brief : 黄花城水长城旅游区位于北京市怀柔区九渡河镇境内，距北京市区65公里，怀柔区中心西北35公里。这里既有水库，又有长城，是北京界内少有的山水相连的长城。黄花城水长城是以奇而著称，以秀为特色，融山川、碧水、古长城为一体的旅游休闲胜地。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/12/28/1451292073067_287.jpg
         * id : wgw01
         * order : 1
         */

        private String title;
        private String brief;
        private String image;
        private String id;
        private String order;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
