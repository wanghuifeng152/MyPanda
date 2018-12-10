package com.example.whf.mypanda.utils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by WHF
 * on 2018/4/10.
 * at 北京
 */
@Entity
public class ZGSong {
    @Id
    private Long id;
    @Property(nameInDb = "title")
    private String title;
    @Property(nameInDb = "url")
    private String url;
    @Generated(hash = 1980022669)
    public ZGSong(Long id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }
    @Generated(hash = 518587908)
    public ZGSong() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
   
    
}
