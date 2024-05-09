package com.alain.cursos.alonso.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.alain.cursos.alonso.utils.Component;
import com.alain.cursos.alonso.utils.Constants;
import com.mdcomponents.cursos.alain.R;
import com.mdcomponents.cursos.alain.databinding.FragmentFloatingActionButtonBinding;

public class FloatingActionButtonFragment extends Fragment {
    FragmentFloatingActionButtonBinding binding;

    public static final String TAG = "Floating Action Button";


    public static Component getmInstance() {
        Component mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_fab_default);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public FloatingActionButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFloatingActionButtonBinding.inflate(inflater, container, false);

        binding.fabDefault.setOnClickListener(view1 -> Toast.makeText(getActivity(), R.string.message_action_success,
                Toast.LENGTH_SHORT).show());
        binding.fabLegacy.setOnClickListener(view1 -> {
            binding.fabLegacy.setVisibility(View.GONE);
            binding.tvLegacy.setVisibility(View.GONE);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
