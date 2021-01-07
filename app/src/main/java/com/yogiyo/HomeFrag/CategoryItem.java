package com.yogiyo.HomeFrag;

import android.graphics.drawable.Drawable;

public class CategoryItem {
    private Drawable category_img_top;
    private Drawable category_img_bottom;
    private String category_content_top;
    private String category_content_bottom;

    public Drawable getCategory_img_top() {
        return category_img_top;
    }

    public void setCategory_img_top(Drawable category_img_top) {
        this.category_img_top = category_img_top;
    }

    public Drawable getCategory_img_bottom() {
        return category_img_bottom;
    }

    public void setCategory_img_bottom(Drawable category_img_bottom) {
        this.category_img_bottom = category_img_bottom;
    }

    public String getCategory_content_top() {
        return category_content_top;
    }

    public void setCategory_content_top(String category_content_top) {
        this.category_content_top = category_content_top;
    }

    public String getCategory_content_bottom() {
        return category_content_bottom;
    }

    public void setCategory_content_bottom(String category_content_bottom) {
        this.category_content_bottom = category_content_bottom;
    }

    public CategoryItem(Drawable category_img_top, Drawable category_img_bottom, String category_content_top, String category_content_bottom) {
        this.category_img_top = category_img_top;
        this.category_img_bottom = category_img_bottom;
        this.category_content_top = category_content_top;
        this.category_content_bottom = category_content_bottom;
    }
}
