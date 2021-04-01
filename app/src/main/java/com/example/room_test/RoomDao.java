package com.example.room_test;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
@Dao
interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)//表示新增物件時和舊物件發生衝突後的處置，REPLACE 蓋掉 (最常用)   ABORT 閃退 (默認) IGNORE 忽略，還是舊的資料
    Long insert(RoomEntity item);

    @Insert
    void insertAll(RoomEntity item);

    @Query("SELECT * FROM room_entity WHERE userName LIKE :name")
    RoomEntity findByName(String name);

    @Query("SELECT * FROM room_entity")
    List<RoomEntity> getAll();

    @Delete
    void delete(RoomEntity item);

    @Update
    void update(RoomEntity item);
}
