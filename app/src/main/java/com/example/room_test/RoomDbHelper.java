package com.example.room_test;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {StudentEntity.class,ClassEntity.class}, version = 6)
public abstract  class RoomDbHelper extends RoomDatabase {
    public abstract RoomDao getRoomDao();
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            Log.e("####","提升資料庫版本");
            database.execSQL("ALTER TABLE student "
                    + "ADD COLUMN bloodType TEXT DEFAULT ''");
        }
    };
    public static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            Log.e("####","提升資料庫版本");
            database.execSQL("create TABLE class "
                    + "(id INTEGER NOT NULL Primary Key,teacherId INTEGER NOT NULL DEFAULT 0,name TEXT NOT NULL DEFAULT '')");
            database.execSQL("ALTER TABLE student "
                    + "ADD COLUMN classId INTEGER DEFAULT 0 REFERENCES class(id) ON UPDATE NO ACTION ON DELETE CASCADE ");
        }
    };
    public static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            Log.e("####","提升資料庫版本");
            database.execSQL("ALTER TABLE student "
                    + "ADD COLUMN identyId VARCHAR  NOT NULL DEFAULT ''");
        }
    };
    public static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            Log.e("####","提升資料庫版本");
            database.execSQL("ALTER TABLE student "
                    + "ADD COLUMN contacterList VARCHAR DEFAULT ''");
        }
    };
    public static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            Log.e("####","提升資料庫版本");
            database.execSQL("ALTER TABLE student "
                    + "ADD COLUMN birthDate INTEGER DEFAULT 0");
        }
    };
}
