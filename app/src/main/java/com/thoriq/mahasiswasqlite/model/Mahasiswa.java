package com.thoriq.mahasiswasqlite.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by farizdotid on 25-Oct-16.
 */

public class Mahasiswa implements Parcelable {

    private int id;
    private String nama;
    private String tempat_lahir;

    public Mahasiswa() {
    }

    public Mahasiswa(String nama, String tempat_lahir) {
        this.nama = nama;
        this.tempat_lahir = tempat_lahir;
    }

    protected Mahasiswa(Parcel in) {
        id = in.readInt();
        nama = in.readString();
        tempat_lahir = in.readString();
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel in) {
            return new Mahasiswa(in);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nama);
        dest.writeString(tempat_lahir);
    }
}
