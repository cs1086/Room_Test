package com.example.room_test;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    private static Gson gson = new Gson();
    private static Type petListType = new TypeToken<ArrayList<Contacter>>() {}.getType();//定義json轉成物件後的型態格式
    @TypeConverter
    public static List<Contacter> petsFromJsonArray(String json) {
        return gson.fromJson(json, petListType);
    }

    @TypeConverter
    public static String petsToJsonArray(List<Contacter> pets) {
        return gson.toJson(pets);
    }
}
