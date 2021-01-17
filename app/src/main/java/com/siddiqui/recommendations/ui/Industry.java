package com.siddiqui.recommendations.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.siddiqui.recommendations.R;

// Created by Taha Siddiqui
// 16/01/16
public class Industry {
    private String name;
    private String description;
    private Drawable drawable;
    private int drawableInt;

    public Industry(String name, String description, int drawable) {
        this.name = name;
        this.description = description;
        this.drawableInt = drawable;
    }

    public int getDrawableId() {
        return drawableInt;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
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
