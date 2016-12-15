package com.jmedinilla.offering.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Andrés Espino López
 * Modelo para conservar la selección de ofertas del usuario
 */

public class Configuration implements Parcelable{

    public static final String CONFIG = "configuration";

    private static boolean home;
    private static boolean electronic;
    private static boolean sports;
    private static boolean showImportance;


    public Configuration(boolean home, boolean electronic, boolean sports, boolean importance) {
        Configuration.home = home;
        Configuration.electronic = electronic;
        Configuration.sports = sports;
        Configuration.showImportance = importance;

    }

    protected Configuration(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Configuration> CREATOR = new Creator<Configuration>() {
        @Override
        public Configuration createFromParcel(Parcel in) {
            return new Configuration(in);
        }

        @Override
        public Configuration[] newArray(int size) {
            return new Configuration[size];
        }
    };

    public static boolean isHome() {
        return home;
    }

    public static void setHome(boolean home) {
        Configuration.home = home;
    }

    public static boolean isElectronic() {
        return electronic;
    }

    public static void setElectronic(boolean electronic) {
        Configuration.electronic = electronic;
    }

    public static boolean isSports() {
        return sports;
    }

    public static void setSports(boolean sports) {
        Configuration.sports = sports;
    }

    public static boolean isShowImportance() {
        return showImportance;
    }

    public static void setShowImportance(boolean showImportance) {
        Configuration.showImportance = showImportance;
    }
}