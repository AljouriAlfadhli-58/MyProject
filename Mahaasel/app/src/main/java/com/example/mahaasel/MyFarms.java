package com.example.mahaasel;

public class MyFarms {
    Integer langImg;
    String langName;
    String langTime;
    Integer key;

    public MyFarms(Integer langImg,String langName , String langTime , Integer key){
        this.langImg = langImg;
        this.langName= langName;
        this.langTime= langTime;
        this.key= key;
    }

    public Integer getLangImg() {
        return langImg;
    }

    public String getLangName() {
        return langName;
    }

    public String getLangTime() {
        return langTime;
    }

    public Integer getKey() {
        return key;
    }
}
