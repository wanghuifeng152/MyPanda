package com.example.whf.mypanda.entity;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/3.
 * at 北京
 */

public class PandaJinCai {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * daytime : 2018-04-03
         * id : TITE1522741184844842
         * image : http://p1.img.cctvpic.com/photoworkspace/2018/04/02/2018040213164770267.jpg
         * order : 1
         * pid : c29ab626eafc4ac9a4ce372d2a1d5602
         * title : 自带忧郁气质
         * type : 2
         * url : http://live.ipanda.com/2018/04/02/VIDExexwQm2YkCPyXog2TJ5s180402.shtml
         * vid :
         * videoLength : 00:22
         */

        private String daytime;
        private String id;
        private String image;
        private String order;
        private String pid;
        private String title;
        private String type;
        private String url;
        private String vid;
        private String videoLength;

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
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

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
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

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }
    }
}
