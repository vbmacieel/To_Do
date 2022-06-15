package com.example.todoapp.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.todoapp.databinding.CreateTodoDialogBinding;

public class CreateToDoDialog extends DialogFragment {
    private CreateTodoDialogBinding mBinding;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        mBinding = CreateTodoDialogBinding.inflate(getLayoutInflater());

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Tentativa de dialog");
        builder.setView(mBinding.getRoot());
        builder.setPositiveButton("CERTO", (dialogInterface, i) ->
                Toast.makeText(getContext(), "Clicado", Toast.LENGTH_SHORT).show());
        builder.setNegativeButton("ERRADO", (dialogInterface, i) -> dismiss());
        return builder.create();
    }
}
