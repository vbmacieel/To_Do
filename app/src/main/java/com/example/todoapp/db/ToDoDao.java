package com.example.todoapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todoapp.model.ToDoModel;

import java.util.List;

@Dao
public interface ToDoDao {

    @Query("SELECT * FROM todo")
    LiveData<List<ToDoModel>> getAllToDos();

    @Insert
    void create(ToDoModel toDo);

    @Delete
    void delete(ToDoModel toDo);

    @Update
    void update(ToDoModel toDo);
}
