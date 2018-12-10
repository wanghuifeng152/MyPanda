package com.example.whf.mypanda.entity;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/7.
 * at 北京
 */

public class MyPadnaGUNg {

    private List<BigImgBean> bigImg;
    private List<ListBean> list;

    public List<BigImgBean> getBigImg() {
        return bigImg;
    }

    public void setBigImg(List<BigImgBean> bigImg) {
        this.bigImg = bigImg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class BigImgBean {
        /**
         * id : TITE1522479825733386
         * image : http://p1.img.cctvpic.com/photoworkspace/2018/03/24/2018032412564522555.jpg
         * order : 1
         * pid : 738999d84135482f8ab525659b48501a
         * stype :
         * title : 《特别节目》这位胖友，意识到自己的胖了吗？
         * type : 2
         * url : http://live.ipanda.com/2018/03/24/VIDEuR9x2bEJvfBVuky817Pv180324.shtml
         * vid :
         */

        private String id;
        private String image;
        private String order;
        private String pid;
        private String stype;
        private String title;
        private String type;
        private String url;
        private String vid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getStype() {
            return stype;
        }

        public void setStype(String stype) {
            this.stype = stype;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }
    }

    public static class ListBean {
        /**
         * brief : 第二季第三十九期：飞云VS昕昕，到底谁能技高一筹？
         * id : VSET100284428835
         * image : http://p1.img.cctvpic.com/photoworkspace/2018/03/26/2018032616494245618.jpg
         * order : 1
         * title : 《熊猫TOP榜》
         * type : 2
         * url : http://live.ipanda.com/2018/03/26/VIDEhoWXvgsEMmwu3guaW4zs180326.shtml
         * videoLength : 03:47
         */

        private String brief;
        private String id;
        private String image;
        private String order;
        private String title;
        private String type;
        private String url;
        private String videoLength;

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }
    }
}
