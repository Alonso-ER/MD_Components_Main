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
import com.example.mdcomponents.databinding.FragmentCheckboxBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;


public class CheckboxFragment extends Fragment {
    public static final String TAG = "Checkbox";
    private static Component mInstance;
    private FragmentCheckboxBinding binding;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_checkboxes);
        mInstance.setType(Constants.SCROLL);
        return getmInstance();
    }

    public CheckboxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCheckboxBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.cbEnable.setOnClickListener(view1 -> {
            String status = binding.cbEnable.isChecked()? "Activo" : "Inactivo";
            Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
            /*  binding.cbIndeterminate.setIndeterminate(binding.cbEnable.isChecked());
                binding.tvIndeterminate.setText    */
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}