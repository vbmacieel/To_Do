package com.example.todoapp.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CreateToDoDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Tentativa de dialog");
        builder.setPositiveButton("CERTO", (dialogInterface, i) ->
                Toast.makeText(getContext(), "Clicado", Toast.LENGTH_SHORT).show());
        builder.setNegativeButton("ERRADO", (dialogInterface, i) ->
                Toast.makeText(getContext(), "Clicado", Toast.LENGTH_SHORT).show());
        return builder.create();
    }
}
