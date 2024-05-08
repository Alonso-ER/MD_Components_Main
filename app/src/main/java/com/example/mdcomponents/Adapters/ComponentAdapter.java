package com.example.mdcomponents.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mdcomponents.databinding.ItemComponentBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.OnClickListener;

import java.util.Collections;
import java.util.List;


public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ViewHolder> {
    private final List<Component> mComponents;
    private final OnClickListener mListener;

    public ComponentAdapter(List<Component> mComponents, OnClickListener mListener) {
        this.mComponents = mComponents;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        com.example.mdcomponents.databinding.ItemComponentBinding binding = ItemComponentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Component component = mComponents.get(position);
        holder.binding.imgPhoto.setImageResource(component.getPhotoRes());
        holder.binding.textName.setText(component.getName());
        holder.setClickListener(mListener, component);
    }

    @Override
    public int getItemCount() {
        return mComponents.size();
    }

    public void add(Component component) {
        if(!mComponents.contains(component)) {
            mComponents.add(component);
            notifyItemInserted(mComponents.size() - 1);
        }
    }

    public void reverse() {
        Collections.reverse(mComponents);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ItemComponentBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemComponentBinding.bind(itemView);
        }

        public void setClickListener(OnClickListener mListener, Component component) {
            binding.getRoot().setOnClickListener(v -> mListener.onClick(component));
        }
    }
}
