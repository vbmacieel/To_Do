package com.example.todoapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ToDoViewModelFactory implements ViewModelProvider.Factory {
    private final Application mApplication;

    public ToDoViewModelFactory(Application application) {
        this.mApplication = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ToDoViewModel.class)) {
            return (T) new ToDoViewModel(mApplication);
        } else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }
    }
}
