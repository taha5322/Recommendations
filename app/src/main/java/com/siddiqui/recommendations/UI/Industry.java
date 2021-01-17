package com.siddiqui.recommendations.UI;

import android.graphics.drawable.Drawable;

// Created by Taha Siddiqui
// 16/01/16
public class Industry {
    private String name;
    private String description;
    private Drawable drawable;

    public Industry(String name, String description, Drawable drawable) {
        this.name = name;
        this.drawable = drawable;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
