package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "BookTb")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid")
    private int bid;
    @Column(name = "aname")
    private String aname;
    @Column(name = "bname")
    private String bname;
    @Column(name = "price")
    private float price;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getAname() {
        return aname;
    }



    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", aname='" + aname + '\'' +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                '}';
    }
}
