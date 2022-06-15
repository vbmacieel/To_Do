package com.example.todoapp.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapp.databinding.ItemRecyclerviewBinding;
import com.example.todoapp.model.ToDoModel;

import java.util.List;

public class ToDoRecyclerViewAdapter extends
        RecyclerView.Adapter<ToDoRecyclerViewAdapter.ToDoViewHolder> {
    private final OnClickItem mListener;
    private List<ToDoModel> mToDoList;

    public ToDoRecyclerViewAdapter(OnClickItem listener) {
        this.mListener = listener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setToDoListData(List<ToDoModel> toDoList) {
        this.mToDoList = toDoList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecyclerviewBinding binding = ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ToDoViewHolder(binding, mListener, mToDoList);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDoModel toDo = mToDoList.get(position);
        holder.bind(toDo);
    }

    @Override
    public int getItemCount() {
        return mToDoList == null ? 0 : mToDoList.size();
    }

    static class ToDoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ItemRecyclerviewBinding mBinding;
        private final List<ToDoModel> mToDoList;
        private final OnClickItem mListener;

        public ToDoViewHolder(@NonNull ItemRecyclerviewBinding binding,
                              OnClickItem listener,
                              List<ToDoModel> toDoList) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mToDoList = toDoList;
            this.mListener = listener;
        }

        protected void bind(ToDoModel toDo) {
            this.mBinding.todoTitle.setText(toDo.getTitle());
            this.mBinding.todoDescription.setText(toDo.getDescription());
            if (toDo.isCompleted()) {
                this.mBinding.todoCompleted.isChecked();
            }
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            ToDoModel toDo = mToDoList.get(position);
            mListener.onToDoClick(toDo);
        }
    }

    public interface OnClickItem {
        void onToDoClick(ToDoModel toDo);
    }
}
