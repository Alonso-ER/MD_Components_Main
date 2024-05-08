package com.alain.cursos.mdcomponents.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.OnClickListener;
import com.mdcomponents.cursos.alain.R;
import com.mdcomponents.cursos.alain.databinding.ItemComponentBinding;

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
        ItemComponentBinding binding = ItemComponentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Component component = mComponents.get(position);

        holder.setClickListener(mListener, component);

        holder.binding.textName.setText(component.getName());
        holder.binding.imgPhoto.setImageResource(component.getPhotoRes());
    }

    @Override
    public int getItemCount() {
        return mComponents.size();
    }

    public void add(Component component){
        if (!mComponents.contains(component)){
            mComponents.add(component);
            notifyItemInserted(mComponents.size() - 1);
        }
    }

    public void reverse() {
        Collections.reverse(mComponents);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ItemComponentBinding binding;

        public ViewHolder(@NonNull ItemComponentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setClickListener(OnClickListener listener, Component component){
            binding.getRoot().setOnClickListener(view -> listener.onClick(component));
        }
    }
}
