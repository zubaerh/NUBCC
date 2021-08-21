package com.zubaer.nubcc;

public class Teacher {
    private String img;
    private String name;
    private String deg;
    private String phone;

    public Teacher(String img, String name, String deg, String phone){
        this.img = img;
        this.name = name;
        this.deg = deg;
        this.phone = phone;
    }

    public String getImg(){ return img;}
    public void setImg(String img){this.img = img;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getDeg(){return deg;}
    public void setDeg(String deg){this.deg = deg;}
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}
}
