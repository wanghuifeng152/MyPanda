package com.example.whf.mypanda.entity;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/8.
 * at 北京
 */

public class MyGungVode {


    /**
     * video : [{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2018/04/02/3f395794d796451d93dfcf016ea86361-129.jpg?p=2&h=120","len":"00:03:49","order":"90","ptime":"2018-04-02 15:21:32","t":"《熊猫TOP榜》 20180402 第二季第四十期：厉害了我的滚滚","url":"http://tv.cntv.cn/video/VSET100284428835/3f395794d796451d93dfcf016ea86361","vid":"3f395794d796451d93dfcf016ea86361","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2018/03/26/d7bdceecc81b4bb7b2fa0c7a6b47b9aa-129.jpg?p=2&h=120","len":"00:03:47","order":"89","ptime":"2018-03-26 13:11:51","t":"《熊猫TOP榜》 20180326 第二季第三十九期：飞云VS昕昕 谁能技高一筹","url":"http://tv.cntv.cn/video/VSET100284428835/d7bdceecc81b4bb7b2fa0c7a6b47b9aa","vid":"d7bdceecc81b4bb7b2fa0c7a6b47b9aa","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2018/03/19/2c9f19f6aea640e7a0f2e691f9d5f71b-129.jpg?p=2&h=120","len":"00:03:36","order":"88","ptime":"2018-03-19 15:29:39","t":"《熊猫TOP榜》 20180319 第二季第三十八期：正宗的霜糖宝宝","url":"http://tv.cntv.cn/video/VSET100284428835/2c9f19f6aea640e7a0f2e691f9d5f71b","vid":"2c9f19f6aea640e7a0f2e691f9d5f71b","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2018/03/12/8701857f3e3d4cd18241ca5a66793c3e-129.jpg?p=2&h=120","len":"00:03:39","order":"87","ptime":"2018-03-12 13:59:03","t":"《熊猫TOP榜》 20180312 第二季第三十七期：开学之际 群熊乱舞","url":"http://tv.cntv.cn/video/VSET100284428835/8701857f3e3d4cd18241ca5a66793c3e","vid":"8701857f3e3d4cd18241ca5a66793c3e","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2018/03/05/be6d8d9a84cb4bfabfd69ee8a791a6ef-129.jpg?p=2&h=120","len":"00:03:40","order":"86","ptime":"2018-03-05 18:25:48","t":"《熊猫TOP榜》 20180305 第二季第三十六期：2017届小团子上幼儿园啦！","url":"http://tv.cntv.cn/video/VSET100284428835/be6d8d9a84cb4bfabfd69ee8a791a6ef","vid":"be6d8d9a84cb4bfabfd69ee8a791a6ef","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2018/02/19/f34504f80bfd411f936f3e7d2809f8f9-112.jpg?p=2&h=120","len":"00:03:23","order":"85","ptime":"2018-02-19 11:23:23","t":"《熊猫TOP榜》 20180219 第二季第三十五期：吃，是过年的主要节目","url":"http://tv.cntv.cn/video/VSET100284428835/f34504f80bfd411f936f3e7d2809f8f9","vid":"f34504f80bfd411f936f3e7d2809f8f9","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2018/02/12/b837f0c4cd1d4dd2b46515948d982f22-129.jpg?p=2&h=120","len":"00:03:31","order":"84","ptime":"2018-02-12 14:18:32","t":"《熊猫TOP榜》 20180212 第二季第34期：吃播很流行","url":"http://tv.cntv.cn/video/VSET100284428835/b837f0c4cd1d4dd2b46515948d982f22","vid":"b837f0c4cd1d4dd2b46515948d982f22","vsid":"VSET100284428835"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg","js":"","name":"熊猫TOP榜","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100284428835","vsid":"VSET100284428835","yz":"","zcr":"","zy":""},"count":"90"}
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

    // FIXME generate failure  field _$_0251
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
             * desc : 这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面
             * dy :
             * enname : 其他
             * fcl :
             * fl :
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg
             * js :
             * name : 熊猫TOP榜
             * nf :
             * playdesc :
             * relvsid :
             * sbpd : 其他
             * sbsj :
             * url : http://tv.cntv.cn/videoset/VSET100284428835
             * vsid : VSET100284428835
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
         * img : http://p1.img.cctvpic.com/fmspic/2018/04/02/3f395794d796451d93dfcf016ea86361-129.jpg?p=2&h=120
         * len : 00:03:49
         * order : 90
         * ptime : 2018-04-02 15:21:32
         * t : 《熊猫TOP榜》 20180402 第二季第四十期：厉害了我的滚滚
         * url : http://tv.cntv.cn/video/VSET100284428835/3f395794d796451d93dfcf016ea86361
         * vid : 3f395794d796451d93dfcf016ea86361
         * vsid : VSET100284428835
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
