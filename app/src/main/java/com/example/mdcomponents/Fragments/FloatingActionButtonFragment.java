package com.example.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentFloatingActionButtonBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
public class FloatingActionButtonFragment extends Fragment {

    public static final String TAG = "Floating Action Button";
    private static Component mInstance;
    private FragmentFloatingActionButtonBinding binding;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_fab_default);
        mInstance.setType(Constants.STATIC);
        return getmInstance();
    }

    public FloatingActionButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFloatingActionButtonBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fabDefault.setOnClickListener(view1 ->
                Toast.makeText(getActivity(),
                R.string.message_action_success, Toast.LENGTH_SHORT).show());

        binding.fabLegacy.setOnClickListener(view1 -> {
            binding.fabLegacy.setVisibility(View.GONE);
            binding.tvLegacy.setVisibility(View.GONE);
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}