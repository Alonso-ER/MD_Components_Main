package com.example.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentSnackBarBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.google.android.material.snackbar.Snackbar;


public class SnackBarFragment extends Fragment {

    public static final String TAG = "Snackbar";
    private static Component mInstance;
    private FragmentSnackBarBinding binding;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_singleline_action);
        mInstance.setType(Constants.STATIC);
        return getmInstance();
    }

    public SnackBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSnackBarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.containerMain.setOnClickListener(view1 ->
                Snackbar.make(view1, R.string.message_action_success, Snackbar.LENGTH_LONG)
                .setAction("Volver", view2 -> requireActivity().finish())
                .show());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}