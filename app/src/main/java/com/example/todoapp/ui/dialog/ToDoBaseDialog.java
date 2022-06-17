package com.example.todoapp.ui.dialog;

import android.app.AlertDialog;
import android.app.Application;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.todoapp.viewmodel.ToDoViewModel;
import com.example.todoapp.viewmodel.ToDoViewModelFactory;

public abstract class ToDoBaseDialog extends DialogFragment {
    protected ToDoViewModel mToDoViewModel;

    protected abstract void createDialog(AlertDialog.Builder builder);

    protected void setViewModel(Application application) {
        mToDoViewModel = new ViewModelProvider(this,
                new ToDoViewModelFactory(application)).get(ToDoViewModel.class);
    }
}
