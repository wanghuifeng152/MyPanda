package com.example.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by WHF
 * on 2018/4/17.
 * at 北京
 */
@Entity
public class History {
    @Id
    private Long id;
    @Property(nameInDb = "image")
    private String image;
    @Property(nameInDb = "title")
    private String titlr;
    @Property(nameInDb = "sum")
    private String sum;
    @Property (nameInDb = "stims")
    private String stims;
    @Generated(hash = 1046755537)
    public History(Long id, String image, String titlr, String sum, String stims) {
        this.id = id;
        this.image = image;
        this.titlr = titlr;
        this.sum = sum;
        this.stims = stims;
    }
    @Generated(hash = 869423138)
    public History() {
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
    public String getSum() {
        return this.sum;
    }
    public void setSum(String sum) {
        this.sum = sum;
    }
    public String getStims() {
        return this.stims;
    }
    public void setStims(String stims) {
        this.stims = stims;
    }

}
