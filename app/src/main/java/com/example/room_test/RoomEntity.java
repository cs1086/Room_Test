package com.example.room_test;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = RoomEntity.TABLE_NAME)
@TypeConverters(GithubTypeConverters.class)
public class RoomEntity {
    static final String TABLE_NAME = "room_entity";
    @PrimaryKey(autoGenerate = true)//自動生成
    int id=0;
    @NonNull
    @ColumnInfo(name = "userName", typeAffinity = ColumnInfo.TEXT)
    String name="";
    int sex=0;
    List<String> affinity;
    @Ignore
    String ignoreText = "";
    public RoomEntity(@NonNull String name, int sex,List<String> affinity) {
        this.name = name;
        this.sex = sex;
        this.affinity=affinity;
    }
}
