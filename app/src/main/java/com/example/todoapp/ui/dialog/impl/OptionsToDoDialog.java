package com.example.todoapp.ui.dialog.impl;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.todoapp.model.ToDoModel;
import com.example.todoapp.ui.dialog.ToDoBaseDialog;

public class OptionsToDoDialog extends ToDoBaseDialog {
    private final ToDoModel mToDo;

    public OptionsToDoDialog(ToDoModel todo) {
        this.mToDo = todo;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        setViewModel(getActivity().getApplication());
        createDialog(builder);
        return builder.create();
    }

    @Override
    protected void createDialog(AlertDialog.Builder builder) {
        builder.setMessage("Options");
        builder.setPositiveButton("Delete", (dialogInterface, i) ->
                mToDoViewModel.delete(mToDo));
        builder.setNegativeButton("Update", (dialogInterface, i) -> {
            DialogFragment createToDoDialog = new CreateToDoDialog(mToDo);
            createToDoDialog.show(getChildFragmentManager(), "Update");
        });
    }
}
