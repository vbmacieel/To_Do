package com.example.todoapp.ui.dialog.impl;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.todoapp.databinding.CreateTodoDialogBinding;
import com.example.todoapp.model.ToDoModel;
import com.example.todoapp.ui.dialog.ToDoBaseDialog;

public class CreateToDoDialog extends ToDoBaseDialog {
    private CreateTodoDialogBinding mBinding;
    private ToDoModel mToDo = null;

    public CreateToDoDialog() {
    }

    public CreateToDoDialog(ToDoModel mToDo) {
        this.mToDo = mToDo;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        mBinding = CreateTodoDialogBinding.inflate(getLayoutInflater());
        setViewModel(getActivity().getApplication());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        createDialog(builder);
        return builder.create();
    }

    @Override
    protected void createDialog(AlertDialog.Builder builder) {
        if (mToDo == null) {
            builder.setMessage("Create new To-Do");
            builder.setPositiveButton("Create", (dialogInterface, i) ->
                    createNewToDo());
        } else {
            createUpdateDialog(builder);
        }
        builder.setView(mBinding.getRoot());
        builder.setNegativeButton("Quit", (dialogInterface, i) -> dismiss());
    }

    private void createUpdateDialog(AlertDialog.Builder builder) {
        mBinding.todoTitleInput.setText(mToDo.getTitle());
        mBinding.todoDescriptionInput.setText(mToDo.getDescription());
        builder.setMessage("Update To-Do");
        builder.setPositiveButton("Update", (dialogInterface, i) ->
                updateToDo());
    }

    private void updateToDo() {
        String toDoTitle = mBinding.todoTitleInput.getText().toString();
        String toDoDescription = mBinding.todoDescriptionInput.getText().toString();
        if (!toDoTitle.isEmpty()) {
            ToDoModel updatedToDo = new ToDoModel(toDoTitle, toDoDescription, false);
            mToDoViewModel.update(updatedToDo);
        }
    }

    private void createNewToDo() {
        String toDoTitle = mBinding.todoTitleInput.getText().toString();
        String toDoDescription = mBinding.todoDescriptionInput.getText().toString();
        if (!toDoTitle.isEmpty()) {
            ToDoModel newToDo = new ToDoModel(toDoTitle, toDoDescription, false);
            mToDoViewModel.create(newToDo);
        } else {
            Toast.makeText(mBinding.getRoot().getContext(),
                    "Title field cannot be blank", Toast.LENGTH_SHORT).show();
        }
    }
}
