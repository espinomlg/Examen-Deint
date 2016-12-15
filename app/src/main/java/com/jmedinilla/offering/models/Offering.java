package com.jmedinilla.offering.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

/**
 * @author Andrés Espino López
    Modelo  que contiene los datos de las ofertas
 */
public class Offering implements Parcelable{

    public static final String OFFER = "offer";

    public static final byte IMPORTANCE_LOW = 0;
    public static final byte IMPORTANCE_NORMAL = 1;
    public static final byte IMPORTANCE_HIGH = 2;

    public static final Comparator<Offering> alphabetic_order = new Comparator<Offering>() {
        @Override
        public int compare(Offering o1, Offering o2) {
            return o1.name.compareToIgnoreCase(o2.name);
        }
    };

    public static final Comparator<Offering> alphabetic_inverse = new Comparator<Offering>() {
        @Override
        public int compare(Offering o1, Offering o2) {
            return o1.name.compareToIgnoreCase(o2.name) * -1;
        }
    };

    public static final Comparator<Offering> type_order = new Comparator<Offering>() {
        @Override
        public int compare(Offering o1, Offering o2) {
            return o1.type - o2.type;
        }
    };



    private String name,
    store,
    date;

    private int img;

    private byte type,
    importance;

    public Offering(String name, String store, String date, byte type, byte importance, int img) {
        this.name = name;
        this.store = store;
        this.date = date;
        this.type = type;
        this.importance = importance;
        this.img = img;
    }

    protected Offering(Parcel in) {
        name = in.readString();
        store = in.readString();
        date = in.readString();
        img = in.readInt();
        type = in.readByte();
        importance = in.readByte();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(store);
        dest.writeString(date);
        dest.writeInt(img);
        dest.writeByte(type);
        dest.writeByte(importance);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Offering> CREATOR = new Creator<Offering>() {
        @Override
        public Offering createFromParcel(Parcel in) {
            return new Offering(in);
        }

        @Override
        public Offering[] newArray(int size) {
            return new Offering[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getImportance() {
        return importance;
    }

    public void setImportance(byte importance) {
        this.importance = importance;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}
