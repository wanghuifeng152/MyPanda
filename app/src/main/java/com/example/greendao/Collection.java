package com.example.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by WHF
 * on 2018/4/11.
 * at 北京
 */
@Entity
public class Collection {
    @Id
    private Long id;
    @Property (nameInDb = "image")
    private String image;
    @Property(nameInDb = "title")
    private String titlr;
    @Property(nameInDb = "url")
    private String url;
    @Generated(hash = 927626682)
    public Collection(Long id, String image, String titlr, String url) {
        this.id = id;
        this.image = image;
        this.titlr = titlr;
        this.url = url;
    }
    @Generated(hash = 1149123052)
    public Collection() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getTitlr() {
        return this.titlr;
    }
    public void setTitlr(String titlr) {
        this.titlr = titlr;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
