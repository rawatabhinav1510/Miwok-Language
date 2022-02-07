package com.example.miwokupdated;

public class ColorsConstructor {
    private String mDefaultColors;
    private String mMiwokColors;
    private int mColorimages;


    public ColorsConstructor(String DefaultColor, String MiwokColor, int colorimage) {
        mDefaultColors = DefaultColor;
        mMiwokColors = MiwokColor;
        mColorimages = colorimage;
    }

    public String getDefaultColor() {
        return mDefaultColors;
    }

    public String getMiwokColor() {
        return mMiwokColors;
    }

    public int getColorimage() {
        return mColorimages;
    }
}

