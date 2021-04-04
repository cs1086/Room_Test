package com.example.room_test;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
@Dao
interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)//表示新增物件時和舊物件發生衝突後的處置，REPLACE 蓋掉 (最常用)   ABORT 閃退 (默認) IGNORE 忽略，還是舊的資料
    Long insert(StudentEntity item);
    @Insert
    Long insert(ClassEntity item);
    @Insert
    void insertAll(StudentEntity item);

    @Query("SELECT * FROM student WHERE userName LIKE :name")
    List<StudentEntity> findByName(String name);

    @Query("SELECT * FROM student")
    List<StudentEntity> getAll();

    @Delete
    int delete(StudentEntity item);
    /**
     *@param item RoomEntity物件
     *@return 修改幾筆資料
     */
    @Update
    int update(StudentEntity item);

    @Query("SELECT * FROM class")
    List<ClassAndAllStudent> getClassAndAllStudents();


}
