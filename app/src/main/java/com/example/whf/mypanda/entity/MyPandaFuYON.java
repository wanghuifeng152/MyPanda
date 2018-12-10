package com.example.whf.mypanda.entity;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/7.
 * at 北京
 */

public class MyPandaFuYON {

    /**
     * video : [{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2018/04/06/0e63412b463b4878b3c6a79e8397ceec-73.jpg?p=2&h=120","len":"00:02:06","order":"56","ptime":"2018-04-06 16:15:22","t":"《当熊不让》 20180406 第54期：母子园里竞争大，有熊沦为路熊甲","url":"http://tv.cntv.cn/video/VSET100332640004/0e63412b463b4878b3c6a79e8397ceec","vid":"0e63412b463b4878b3c6a79e8397ceec","vsid":"VSET100332640004"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2018/03/30/719423527fbf4f85b9318f75804b6cd5-71.jpg?p=2&h=120","len":"00:02:01","order":"55","ptime":"2018-03-30 15:36:03","t":"《当熊不让》 20180330 第五十三期：国宝率先响应号召：为了生命安全，洗澡必须开窗开门","url":"http://tv.cntv.cn/video/VSET100332640004/719423527fbf4f85b9318f75804b6cd5","vid":"719423527fbf4f85b9318f75804b6cd5","vsid":"VSET100332640004"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2018/03/23/87453277b98043f5aa49ff3ee60bf533-69.jpg?p=2&h=120","len":"00:01:52","order":"54","ptime":"2018-03-23 19:13:33","t":"《当熊不让》 20180323 第五十二期：听说大熊猫也有彩色照片","url":"http://tv.cntv.cn/video/VSET100332640004/87453277b98043f5aa49ff3ee60bf533","vid":"87453277b98043f5aa49ff3ee60bf533","vsid":"VSET100332640004"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2018/03/16/000747292bae468395704a9ff91f417e-72.jpg?p=2&h=120","len":"00:02:04","order":"53","ptime":"2018-03-16 13:29:33","t":"《当熊不让》 20180316 第五十一期：熊孩子们的快乐生活","url":"http://tv.cntv.cn/video/VSET100332640004/000747292bae468395704a9ff91f417e","vid":"000747292bae468395704a9ff91f417e","vsid":"VSET100332640004"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2018/03/09/2e95c2d40b2a44bd94d18ef4d5d35253-75.jpg?p=2&h=120","len":"00:02:10","order":"52","ptime":"2018-03-09 15:44:23","t":"《当熊不让》 20180309 第五十期：汤圆好吃还是饺子好吃","url":"http://tv.cntv.cn/video/VSET100332640004/2e95c2d40b2a44bd94d18ef4d5d35253","vid":"2e95c2d40b2a44bd94d18ef4d5d35253","vsid":"VSET100332640004"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2018/03/02/d8990d9a63fb49ffabcacaa12798c643-50.jpg?p=2&h=120","len":"00:01:48","order":"51","ptime":"2018-03-02 14:17:59","t":"《当熊不让》 20180302 打榜！2018第一榜，花落谁家","url":"http://tv.cntv.cn/video/VSET100332640004/d8990d9a63fb49ffabcacaa12798c643","vid":"d8990d9a63fb49ffabcacaa12798c643","vsid":"VSET100332640004"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2018/02/09/2c78bbb6810b4c20ab954ee3d3787b67-50.jpg?p=2&h=120","len":"00:01:41","order":"50","ptime":"2018-02-09 14:16:02","t":"《当熊不让》 20180209 第四十八期：春节！想想要长肉心都会痛！","url":"http://tv.cntv.cn/video/VSET100332640004/2c78bbb6810b4c20ab954ee3d3787b67","vid":"2c78bbb6810b4c20ab954ee3d3787b67","vsid":"VSET100332640004"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"新节目《当熊不让》上线啦！每周五盘点当周最火视频和图片，让你一次看遍人气熊猫！","dy":"","enname":"其他","fcl":"","fl":"熊猫直播","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/3/15/VSETgpbnd9sJ0BP2qfKq00j2170315.jpg","js":"","name":"当熊不让","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100332640004","vsid":"VSET100332640004","yz":"","zcr":"","zy":""},"count":"55"}
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    // FIXME generate failure  field _$_0204
    public static class VideosetBean {
        private String count;


        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * bj :
             * cd :
             * desc : 新节目《当熊不让》上线啦！每周五盘点当周最火视频和图片，让你一次看遍人气熊猫！
             * dy :
             * enname : 其他
             * fcl :
             * fl : 熊猫直播
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/3/15/VSETgpbnd9sJ0BP2qfKq00j2170315.jpg
             * js :
             * name : 当熊不让
             * nf :
             * playdesc :
             * relvsid :
             * sbpd : 其他
             * sbsj :
             * url : http://tv.cntv.cn/videoset/VSET100332640004
             * vsid : VSET100332640004
             * yz :
             * zcr :
             * zy :
             */

            private String bj;
            private String cd;
            private String desc;
            private String dy;
            private String enname;
            private String fcl;
            private String fl;
            private String img;
            private String js;
            private String name;
            private String nf;
            private String playdesc;
            private String relvsid;
            private String sbpd;
            private String sbsj;
            private String url;
            private String vsid;
            private String yz;
            private String zcr;
            private String zy;

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }
        }
    }

    public static class VideoBean {
        /**
         * em : CM01
         * img : http://p2.img.cctvpic.com/fmspic/2018/04/06/0e63412b463b4878b3c6a79e8397ceec-73.jpg?p=2&h=120
         * len : 00:02:06
         * order : 56
         * ptime : 2018-04-06 16:15:22
         * t : 《当熊不让》 20180406 第54期：母子园里竞争大，有熊沦为路熊甲
         * url : http://tv.cntv.cn/video/VSET100332640004/0e63412b463b4878b3c6a79e8397ceec
         * vid : 0e63412b463b4878b3c6a79e8397ceec
         * vsid : VSET100332640004
         */

        private String em;
        private String img;
        private String len;
        private String order;
        private String ptime;
        private String t;
        private String url;
        private String vid;
        private String vsid;

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
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

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }
    }
}
