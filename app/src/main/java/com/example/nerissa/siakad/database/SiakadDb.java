package com.example.nerissa.siakad.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.graphics.Movie;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.nerissa.siakad.entity.Mahasiswa;
import com.example.nerissa.siakad.dao.MhsAdd;
import com.example.nerissa.siakad.entity.Nilai;
import com.example.nerissa.siakad.dao.NilaiAdd;

import java.util.concurrent.Executors;

@Database(entities ={Mahasiswa.class, Nilai.class},version = 1,exportSchema = false)
public abstract class SiakadDb extends RoomDatabase {

    private static SiakadDb INSTANCE;

    public abstract MhsAdd mhsAdd();

    public abstract NilaiAdd nilaiAdd();

    public synchronized static SiakadDb getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    private static SiakadDb buildDatabase(final Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                SiakadDb.class,
                "my-database").allowMainThreadQueries()
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Log.d("MoviesDatabase", "populating with data...");
                        new PopulateDbAsync(INSTANCE).execute();
//                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
//                            @Override
//                            public void run() {
//                                getInstance(context).mhsAdd().addMhs(Mahasiswa.addMhs());
//                            }
//                        });
                    }
                })
                .build();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private MhsAdd mhsAdd;
        private NilaiAdd nilaiAdd;

        public PopulateDbAsync(SiakadDb instance) {
            mhsAdd = instance.mhsAdd();
            nilaiAdd = instance.nilaiAdd();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Mahasiswa mhs1 = new Mahasiswa("20160801159", "Neris", "TI", "19980723");
            Mahasiswa mhs2 = new Mahasiswa("20160801951", "Siren", "SI", "23071998");

            mhsAdd.addMhs(mhs1, mhs2);

            Nilai nilai1 = new Nilai(1, 1, mhs1.getNim(), 3.33);
            Nilai nilai2 = new Nilai(2, 2, mhs1.getNim(), 3.00);
            Nilai nilai3 = new Nilai(3, 3, mhs1.getNim(), 2.67);
            Nilai nilai4 = new Nilai(4, 4, mhs1.getNim(), 3.00);
            Nilai nilai5 = new Nilai(5, 5, mhs1.getNim(), 3.33);
            Nilai nilai6 = new Nilai(6, 1, mhs2.getNim(), 2.00);
            Nilai nilai7 = new Nilai(7, 2, mhs2.getNim(), 3.33);
            Nilai nilai8 = new Nilai(8, 3, mhs2.getNim(), 3.67);
            Nilai nilai9 = new Nilai(9, 4, mhs2.getNim(), 3.00);
            Nilai nilai10 = new Nilai(10, 5, mhs2.getNim(), 2.67);

            nilaiAdd.addNilai(nilai1, nilai2, nilai3, nilai4, nilai5,
                    nilai6, nilai7, nilai8, nilai9, nilai10);

            return null;
        }
    }
}