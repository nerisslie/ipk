package com.example.nerissa.siakad.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "students", indices = {@Index("nim")})

public class Mahasiswa {

    @PrimaryKey @NonNull @ColumnInfo(name = "nim")
    private String nim;

    @ColumnInfo(name = "student_name")
    private String name;

    @ColumnInfo(name = "jurusan")
    private String jurusan;

    @ColumnInfo(name = "student_password")
    private String password;

    public Mahasiswa(String nim, String name, String jurusan, String password) {
        this.nim = nim;
        this.name = name;
        this.jurusan = jurusan;
        this.password = password;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static Mahasiswa[] addMhs() {
        return new Mahasiswa[] {
                new Mahasiswa("20160801159", "Neris", "TI", "19980723"),
                new Mahasiswa("20160801951", "Siren", "SI", "23071998")

        };
    }

}
