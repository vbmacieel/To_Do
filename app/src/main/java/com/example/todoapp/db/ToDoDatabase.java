package com.example.todoapp.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.todoapp.model.ToDoModel;

@Database(entities = ToDoModel.class, version = 1)
public abstract class ToDoDatabase extends RoomDatabase {
    private static ToDoDatabase sInstace;
    private static String DATABASE_NAME = "todo";
    public abstract ToDoDao toDoDao();

    public static synchronized ToDoDatabase getInstance(Context context) {
        if (sInstace == null) {
            sInstace = Room.databaseBuilder(context.getApplicationContext(),
                    ToDoDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return sInstace;
    }

    private static RoomDatabase.Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(sInstace).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ToDoDao mToDoDao;

        public PopulateDbAsyncTask(ToDoDatabase db) {
            this.mToDoDao = db.toDoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mToDoDao.create(new ToDoModel("Primeiro Todo", "Descricao todo", false));
            return null;
        }
    }
}
