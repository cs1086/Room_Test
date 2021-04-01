package com.example.room_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.room_test.RoomDbHelper.MIGRATION_1_2;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoomDbHelper db = Room.databaseBuilder(getApplicationContext(),
                RoomDbHelper.class, "database-name")
                //.addMigrations(MIGRATION_1_2) 如果資料庫要提升版本
                .build();
        new Thread(()->{
            long id = db.getRoomDao().insert(new RoomEntity("小豬呵呵",2, Arrays.asList("籃球","棒球0","電影")));
            Log.d("####","id="+id);
            List<RoomEntity> roomEntityList=db.getRoomDao().getAll();
            roomEntityList.forEach(x->Log.d("####","id="+x.id+",name="+x.name+",affinity"+x.affinity));
        }).start();
    }
}