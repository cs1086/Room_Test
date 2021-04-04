package com.example.room_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.room_test.RoomDbHelper.MIGRATION_1_2;
import static com.example.room_test.RoomDbHelper.MIGRATION_2_3;
import static com.example.room_test.RoomDbHelper.MIGRATION_4_5;
import static com.example.room_test.RoomDbHelper.MIGRATION_5_6;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    RoomDao roomDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RoomDbHelper db = Room.databaseBuilder(getApplicationContext(),
                RoomDbHelper.class, "database-name")
                .addMigrations(MIGRATION_1_2,MIGRATION_2_3,MIGRATION_4_5,MIGRATION_5_6) //如果資料庫要提升版本
                .build();
        roomDao =db.getRoomDao();
        new Thread(()->{
            StudentEntity r=new StudentEntity("小豬呵呵2",1, Arrays.asList("睡覺","打屁","賣萌"),1);
            r.id=3;
            r.studentID="jenderhowlay";
            Log.d("####","r.classId="+r.classId);
            Log.d("####","影響比數="+ roomDao.update(r));

            List<StudentEntity> roomEntityList= roomDao.getAll();
            roomEntityList.forEach(x->Log.d("####","getAll.id="+x.id+",name="+x.name+",affinity"+x.affinity+",studentID="+x.studentID));
            List<StudentEntity>  roomEntity= roomDao.findByName("睡覺好了");
            roomEntity.forEach(x->Log.d("####","findByName.id="+x.id+",name="+x.name+",affinity"+x.affinity));
            //Log.d("####","findByName.id="+roomEntity.id+",name="+roomEntity.name+",affinity"+roomEntity.affinity);

        }).start();

    }
    public void addClass(View view) {
        new Thread(()-> {
            long id = roomDao.insert(new ClassEntity("玫瑰花班", 0));
        }).start();
    }
    public void addStudent(View view) {
        new Thread(()-> {
            StudentEntity studentEntity=new StudentEntity("鼠王",1, Arrays.asList("臭臭","吃吃","酸酸"),2);
            studentEntity.birthDate=new Date();
            List<Contacter> contacterList=new ArrayList<>();
            Contacter contacter=new Contacter();
            contacter.name="鼠爸";
            contacter.sex=1;
            Contacter contacter2=new Contacter();
            contacter2.name="鼠嗎";
            contacter2.sex=2;
            contacterList.add(contacter);
            contacterList.add(contacter2);
            studentEntity.contacterList=contacterList;
            long id = roomDao.insert(studentEntity);
            Log.d("####","id="+id);
        }).start();
    }
    public void search(View view){
        new Thread(()-> {
            List<ClassAndAllStudent> classAndAllStudentList = roomDao.getClassAndAllStudents();
            classAndAllStudentList.forEach(x->Log.d("####","班級="+x.classEntity.name+",學生="+x.studentEntities.stream().map(y->"id:"+y.id+",姓名:"+y.name+",birthDate="+y.birthDate+",contact="+(y.contacterList==null?"":y.contacterList.stream().map(z->z.name).collect(Collectors.joining(",")))).collect(Collectors.joining(","))));
        }).start();
    }
}