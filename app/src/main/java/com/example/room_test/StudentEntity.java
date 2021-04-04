package com.example.room_test;

import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = StudentEntity.TABLE_NAME,foreignKeys = @ForeignKey(entity = ClassEntity.class,
        parentColumns = "id",
        childColumns = "classId",
        onDelete = CASCADE))
@TypeConverters(GithubTypeConverters.class)
public class StudentEntity {
    static final String TABLE_NAME = "student";
    @PrimaryKey(autoGenerate = true)//自動生成
    int id=0;
    @NonNull
    String studentID="";
    @NonNull
    String identyId="";
    String bloodType="";
    @NonNull
    @ColumnInfo(name = "userName", typeAffinity = ColumnInfo.TEXT)
    String name="";
    int sex=0;
    int classId;
    List<String> affinity;
    public List<Contacter> contacterList;
    Date birthDate;
    @Ignore
    String ignoreText = "";
    public StudentEntity(@NonNull String name, int sex,List<String> affinity,int classId) {
        this.name = name;
        this.sex = sex;
        this.affinity=affinity;
        this.classId=classId;
    }
}
