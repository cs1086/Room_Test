package com.example.room_test;

import android.annotation.SuppressLint;
import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import androidx.room.TypeConverter;
import androidx.room.util.StringUtil;
/*
提供RoomDao物件型態轉換工具
*/
public class GithubTypeConverters {
    @SuppressLint("RestrictedApi")
    @TypeConverter
    public static List<Integer> stringToIntList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        return StringUtil.splitToIntList(data);
    }

    @SuppressLint("RestrictedApi")
    @TypeConverter
    public static String intListToString(List<Integer> ints) {
        return StringUtil.joinIntoString(ints);
    }

    @SuppressLint("RestrictedApi")
    @TypeConverter
    public static List<String> stringToStringList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(data.split(","));
    }

    @SuppressLint("RestrictedApi")
    @TypeConverter
    public static String stringListToString(List<String> list) {
        return list.stream().collect(Collectors.joining(","));
    }
}
