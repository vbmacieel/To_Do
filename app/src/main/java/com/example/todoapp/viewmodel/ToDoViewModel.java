package com.example.todoapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todoapp.model.ToDoModel;
import com.example.todoapp.repository.ToDoRepository;

import java.util.List;

public class ToDoViewModel extends AndroidViewModel {
    private final ToDoRepository toDoRepository;
    private final LiveData<List<ToDoModel>> allToDos;

    public ToDoViewModel(@NonNull Application application) {
        super(application);
        toDoRepository = new ToDoRepository(application);
        allToDos = toDoRepository.getAllToDos();
    }

    public LiveData<List<ToDoModel>> getAllToDos() {
        return allToDos;
    }

    public void create(ToDoModel toDo) {
        toDoRepository.create(toDo);
    }

    public void delete(ToDoModel toDo) {
        toDoRepository.delete(toDo);
    }

    public void update(ToDoModel toDo) {
        toDoRepository.update(toDo);
    }
}
