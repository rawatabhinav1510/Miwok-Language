package com.example.miwokupdated;


public class NumbersConstructor {
    private String mDefaultNumbers;
    private String mMiwokNumbers;
    private int mImageidNumber;
    private int mNumbersAudio;

    /*
    YEH BASICALLY ARRAYLIST K SABHI OBJECT K DATA KO STORE KARTA HAI AUR JB ADAPTER CLASS VIEWS BANNAE K LIYE
    MANGTI HAI DATA KO TOH YEH VO DATA KO RETURN KAR DETA HAI

     */

    public NumbersConstructor(String defaultNumber, String defaultmiwokNumber, int defaultImageid,int numbersaudio) {
        mDefaultNumbers= defaultNumber;
        mMiwokNumbers = defaultmiwokNumber;
        mImageidNumber = defaultImageid;
        mNumbersAudio=numbersaudio;
    }

    public String getDefaultNumbers() {
        return mDefaultNumbers;
    }

    public String getMiwokNumbers() {
        return mMiwokNumbers;
    }

    public int getImageidNumber() {
        return mImageidNumber;
    }
    public int getNumbersAudio() {
        return mNumbersAudio;
    }
}


