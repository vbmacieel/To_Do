package com.example.todoapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;

import com.example.todoapp.adapter.ToDoRecyclerViewAdapter;
import com.example.todoapp.databinding.ActivityMainBinding;
import com.example.todoapp.model.ToDoModel;
import com.example.todoapp.ui.dialog.impl.CreateToDoDialog;
import com.example.todoapp.ui.dialog.impl.OptionsToDoDialog;
import com.example.todoapp.viewmodel.ToDoViewModel;
import com.example.todoapp.viewmodel.ToDoViewModelFactory;

public class MainActivity extends AppCompatActivity implements ToDoRecyclerViewAdapter.OnClickItem {
    private ToDoRecyclerViewAdapter mAdapter;
    private ActivityMainBinding mBinding;
    private ToDoViewModel mToDoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setViewModel(getApplication());
        setUpRecyclerViewAdapter();
        setClickOnFab();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mToDoViewModel.getAllToDos().observe(this, toDoModels ->
                mAdapter.setToDoListData(toDoModels));
    }

    private void setUpRecyclerViewAdapter() {
        RecyclerView recyclerView = mBinding.recyclerviewTodoList;
        mAdapter = new ToDoRecyclerViewAdapter(this);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(mBinding.getRoot().getContext()));
        recyclerView.setAdapter(mAdapter);
    }

    private void setViewModel(Application application) {
        mToDoViewModel = new ViewModelProvider(this,
                new ToDoViewModelFactory(application)).get(ToDoViewModel.class);
    }

    private void setClickOnFab() {
        mBinding.fabAddNewTodo.setOnClickListener(view -> {
            DialogFragment createToDoDialog = new CreateToDoDialog();
            createToDoDialog.show(getSupportFragmentManager(), "Create");
        });
    }

    @Override
    public void onToDoClick(ToDoModel toDo) {
        DialogFragment optionsToDoDialog = new OptionsToDoDialog(toDo);
        optionsToDoDialog.show(getSupportFragmentManager(), "Options");
    }
}