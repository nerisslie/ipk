package com.example.nerissa.siakad.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "nilai", indices = {@Index("nim_mhs")}, foreignKeys = @ForeignKey(entity = Mahasiswa.class,
        parentColumns = "nim", childColumns = "nim_mhs"))

public class Nilai {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "semester")
    private int semester;

    @ColumnInfo(name = "nim_mhs")
    public String nim_mhs;

    @ColumnInfo(name = "nilai")
    private Double nilai;

    public Nilai(int id, int semester, String nim_mhs,
                Double nilai) {
        this.id = id;
        this.semester = semester;
        this.nim_mhs = nim_mhs;
        this.nilai = nilai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getNim_mhs() {
        return nim_mhs;
    }

    public void setNim_mhs(String nim_mhs) {
        this.nim_mhs = nim_mhs;
    }

    public Double getNilai() {
        return nilai;
    }

    public void setNilai(Double nilai) {
        this.nilai = nilai;
    }
}
