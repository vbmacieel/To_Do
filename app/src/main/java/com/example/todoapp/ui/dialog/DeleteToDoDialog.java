package com.example.todoapp.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.todoapp.model.ToDoModel;

public class DeleteToDoDialog extends DialogFragment {
    private ToDoModel mToDo;

    public DeleteToDoDialog(ToDoModel todo) {
        this.mToDo = todo;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Continuar código de deletar To-Do
        return builder.create();
    }
}
