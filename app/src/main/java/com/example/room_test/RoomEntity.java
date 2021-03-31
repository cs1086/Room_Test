package com.example.room_test;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = RoomEntity.TABLE_NAME)
public class RoomEntity {
    static final String TABLE_NAME = "room_entity";
    @PrimaryKey(autoGenerate = true)//自動生成
    int id=0;
    @NonNull
    @ColumnInfo(name = "name2", typeAffinity = ColumnInfo.TEXT)
    String name="";
    int sex=0;
    @Ignore
    String ignoreText = "";
}
