package com.example.room_test;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

public class ClassAndAllStudent {
    @Embedded
    public ClassEntity classEntity;//班級

    @Relation(parentColumn = "id",
            entityColumn = "classId")
    public List<StudentEntity> studentEntities;
}
