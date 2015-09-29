package com.example.prakhar1001.viewpager1;


import android.os.Parcel;
import android.os.Parcelable;




public class Single_Row implements Parcelable {
    public String editString;
    public Boolean check;

    public String getText() {
        return editString;
    }

    public void setText(String text) {
        this.editString = text;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public Single_Row() {
    }

    public Single_Row(String text, boolean check) {
        this.editString = text;
        this.check = check;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(editString);
        out.writeInt(check ? 1 : 0);
    }

    public static final Parcelable.Creator<Single_Row> CREATOR = new Parcelable.Creator<Single_Row>() {
        public Single_Row createFromParcel(Parcel in) {
            return new Single_Row(in);
        }

        public Single_Row[] newArray(int size) {
            return new Single_Row[size];
        }
    };

    private Single_Row(Parcel in) {
        editString = in.readString();
        check = in.readInt() == 1;
    }
}
