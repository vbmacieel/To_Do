package com.example.todoapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.todoapp.db.ToDoDao;
import com.example.todoapp.db.ToDoDatabase;
import com.example.todoapp.model.ToDoModel;

import java.util.List;

public class ToDoRepository {
    private final LiveData<List<ToDoModel>> mAllToDos;
    private final ToDoDao mToDoDao;

    public ToDoRepository(Application application) {
        ToDoDatabase toDoDatabase = ToDoDatabase.getInstance(application);
        this.mToDoDao = toDoDatabase.toDoDao();
        this.mAllToDos = mToDoDao.getAllToDos();
    }

    public LiveData<List<ToDoModel>> getAllToDos() {
        return mAllToDos;
    }

    public void create(ToDoModel toDo) {
        new CreateToDoAsyncTask(mToDoDao).execute(toDo);
    }

    public void delete(ToDoModel toDo) {
        new DeleteToDoAsyncTask(mToDoDao).execute(toDo);
    }

    public void update(ToDoModel toDo) {
        new UpdateToDoAsyncTask(mToDoDao).execute(toDo);
    }

    private static class CreateToDoAsyncTask extends AsyncTask<ToDoModel, Void, Void> {
        private ToDoDao mToDoDao;

        public CreateToDoAsyncTask(ToDoDao toDoDao) {
            this.mToDoDao = toDoDao;
        }

        @Override
        protected Void doInBackground(ToDoModel... toDoModels) {
            mToDoDao.create(toDoModels[0]);
            return null;
        }
    }

    private static class UpdateToDoAsyncTask extends AsyncTask<ToDoModel, Void, Void> {
        private ToDoDao mToDoDao;

        public UpdateToDoAsyncTask(ToDoDao toDoDao) {
            this.mToDoDao = toDoDao;
        }

        @Override
        protected Void doInBackground(ToDoModel... toDoModels) {
            mToDoDao.update(toDoModels[0]);
            return null;
        }
    }

    private static class DeleteToDoAsyncTask extends AsyncTask<ToDoModel, Void, Void> {
        private ToDoDao mToDoDao;

        public DeleteToDoAsyncTask(ToDoDao toDoDao) {
            this.mToDoDao = toDoDao;
        }

        @Override
        protected Void doInBackground(ToDoModel... toDoModels) {
            mToDoDao.delete(toDoModels[0]);
            toDoModels = null;
            return null;
        }
    }
}
