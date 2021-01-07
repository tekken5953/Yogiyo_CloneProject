package com.yogiyo.HomeFrag;

import android.graphics.drawable.Drawable;

public class HashTagItem {

    private Drawable hashtag_background;
    private String hashtag_content;

    public Drawable getHashtag_background() {
        return hashtag_background;
    }

    public void setHashtag_background(Drawable hashtag_background) {
        this.hashtag_background = hashtag_background;
    }

    public String getHashtag_content() {
        return hashtag_content;
    }

    public void setHashtag_content(String hashtag_content) {
        this.hashtag_content = hashtag_content;
    }

    public HashTagItem(Drawable hashtag_background, String hashtag_content) {
        this.hashtag_background = hashtag_background;
        this.hashtag_content = hashtag_content;
    }
}
