package com.yogiyo.OrderList;

import android.graphics.drawable.Drawable;

public class OrderListItem {
    private String time;
    private String name;
    private String menu;
    private String complete;
    private Drawable img;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public OrderListItem(Drawable img, String time, String complete, String name, String menu ) {
        this.img = img;
        this.time = time;
        this.complete = complete;
        this.name = name;
        this.menu = menu;
    }
}
