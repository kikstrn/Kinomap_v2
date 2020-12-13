package com.example.kinomap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.text.Normalizer;

import retrofit2.Call;
import retrofit2.http.GET;

public class Vehicles implements Comparable<Vehicles>, Parcelable {

    private int id;
    //private byte[] icon;
    private String name;

    public Vehicles(int id,  String name) { //byte[] icon,
        this.id = id;
        //this.icon = icon;
        this.name = name;
    }

    public Vehicles( String name) { //byte[] icon,
        //this.icon = icon;
        this.name = name;
    }

    protected Vehicles(Parcel in){
        id = in.readInt();
        //icon = new byte[in.readInt()];
        //in.readByteArray(icon);
        name = in.readString();
    }

    public static final Creator<Vehicles> CREATOR = new Creator<Vehicles>() {
        @Override
        public Vehicles createFromParcel(Parcel in) {
            return new Vehicles(in);
        }

        @Override
        public Vehicles[] newArray(int size) {
            return new Vehicles[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    //Ecriture du parcel

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeInt(id);
        //dest.writeByteArray(icon);
        //dest.writeInt(icon.length);
        dest.writeString(name);
    }

    @Override
    public int compareTo(Vehicles o) {
        String s1 = Normalizer.normalize(name, Normalizer.Form.NFD);
        String s2 = Normalizer.normalize(o.name, Normalizer.Form.NFD);
        return s1.toLowerCase().compareTo(s2.toLowerCase());
    }

    @Override
    public String toString(){
        String listo = "Véhicule : \n";
        listo += "id : " + id + "\n";
        listo += "Nom du véhicule : " + name + "\n";
        return listo;
    }


    //public Bitmap getIcon() {
        //return BitmapFactory.decodeByteArray(icon, 0, icon.length);
    //}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class JSONResponse {
        private Vehicles[] vehicles;

        public Vehicles[] getVehicles(){
            return vehicles;
        }
    }



}
