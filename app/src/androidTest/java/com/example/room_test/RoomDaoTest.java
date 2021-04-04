package com.example.room_test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import java.util.Arrays;

import androidx.room.Room;
import androidx.test.InstrumentationRegistry;

public class RoomDaoTest extends TestCase {
    RoomDbHelper db;
    RoomDao roomDao;
    @Before
    public void setUp() throws Exception {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                RoomDbHelper.class).build();
        roomDao=db.getRoomDao();
        long id = roomDao.insert(new ClassEntity("玫瑰花班", 0));
        StudentEntity studentEntity =new StudentEntity("小豬呵呵2",1, Arrays.asList("睡覺","打屁","賣萌"),1);
    }
    @After
    public void closeDb() throws Exception {
        db.close();
    }
}