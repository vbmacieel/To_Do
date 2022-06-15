package com.example.todoapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.todoapp.adapter.ToDoRecyclerViewAdapter;
import com.example.todoapp.databinding.ActivityMainBinding;
import com.example.todoapp.model.ToDoModel;
import com.example.todoapp.ui.dialog.CreateToDoDialog;

public class MainActivity extends AppCompatActivity implements ToDoRecyclerViewAdapter.OnClickItem {
    private ToDoRecyclerViewAdapter mAdapter;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setUpRecyclerViewAdapter();
        setClickOnFab();
    }

    private void setUpRecyclerViewAdapter() {
        RecyclerView recyclerView = mBinding.recyclerviewTodoList;
        mAdapter = new ToDoRecyclerViewAdapter(this);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(mBinding.getRoot().getContext()));
        recyclerView.setAdapter(mAdapter);
    }

    private void setClickOnFab() {
        mBinding.fabAddNewTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newDialog = new CreateToDoDialog();
                newDialog.show(getSupportFragmentManager(), "Create To-Do");
            }
        });
    }

    @Override
    public void onToDoClick(ToDoModel toDo) {

    }
}