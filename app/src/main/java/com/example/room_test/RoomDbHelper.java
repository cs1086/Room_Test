package com.example.room_test;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {RoomEntity.class}, version = 1)
public abstract  class RoomDbHelper extends RoomDatabase {
    public abstract RoomDao getRoomDao();
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE RoomEntity "
                    + "ADD COLUMN affinity TEXT");
        }
    };
}
