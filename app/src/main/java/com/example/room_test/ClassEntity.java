package com.example.room_test;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = ClassEntity.TABLE_NAME)
@TypeConverters(GithubTypeConverters.class)
public class ClassEntity {
    static final String TABLE_NAME = "class";
    @PrimaryKey(autoGenerate = true)//自動生成
    int id=0;
    @NonNull
    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    String name="";
    int teacherId=0;
    public ClassEntity(@NonNull String name,int teacherId) {
        this.name = name;
        this.teacherId = teacherId;
    }
}
