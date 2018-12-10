package com.example.whf.mypanda.entity;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/7.
 * at 北京
 */

public class MyPandaBoba {
    /**
     * data : {"bigImg":[{"id":"TITE1522480134436442","image":"http://p1.img.cctvpic.com/photoworkspace/2018/03/30/2018033018212193804.jpg","order":"1","pid":"4ee48b8d1cfd4eb4bf521541cba3c359","stype":"","title":"陕西汉中再次发现棕色大熊猫个体","type":"2","url":"http://live.ipanda.com/2018/03/30/VIDE17sswU8joAHvg6mRFUeb180330.shtml","vid":""}],"listurl":"http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bigImg : [{"id":"TITE1522480134436442","image":"http://p1.img.cctvpic.com/photoworkspace/2018/03/30/2018033018212193804.jpg","order":"1","pid":"4ee48b8d1cfd4eb4bf521541cba3c359","stype":"","title":"陕西汉中再次发现棕色大熊猫个体","type":"2","url":"http://live.ipanda.com/2018/03/30/VIDE17sswU8joAHvg6mRFUeb180330.shtml","vid":""}]
         * listurl : http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda
         */

        private String listurl;
        private List<BigImgBean> bigImg;

        public String getListurl() {
            return listurl;
        }

        public void setListurl(String listurl) {
            this.listurl = listurl;
        }

        public List<BigImgBean> getBigImg() {
            return bigImg;
        }

        public void setBigImg(List<BigImgBean> bigImg) {
            this.bigImg = bigImg;
        }

        public static class BigImgBean {
            /**
             * id : TITE1522480134436442
             * image : http://p1.img.cctvpic.com/photoworkspace/2018/03/30/2018033018212193804.jpg
             * order : 1
             * pid : 4ee48b8d1cfd4eb4bf521541cba3c359
             * stype :
             * title : 陕西汉中再次发现棕色大熊猫个体
             * type : 2
             * url : http://live.ipanda.com/2018/03/30/VIDE17sswU8joAHvg6mRFUeb180330.shtml
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
    }
}
