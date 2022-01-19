package com.example.wudc;

public class RecItem {
    /* 아이템의 정보를 담기 위한 클래스 */

    String num;
    String name;
    String des;

    public RecItem(String num, String name, String des) { //int resId
        this.num = num;
        this.name = name;
        this.des = des;
    }

    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
}
