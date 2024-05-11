package com.alain.cursos.alonso.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alain.cursos.alonso.R;
import com.alain.cursos.alonso.databinding.FragmentCheckboxBinding;
import com.alain.cursos.alonso.utils.Component;
import com.alain.cursos.alonso.utils.Constants;

public class CheckboxFragment extends Fragment {

    FragmentCheckboxBinding binding;

    public static final String TAG = "Checkbox";

    public static Component getmInstance() {
        Component mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_checkboxes);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public CheckboxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCheckboxBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.cbEnable.setOnClickListener(view1 -> {
            String status = binding.cbEnable.isChecked() ? "Activo." : "Inactivo.";
            Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();

            //cbEnableIndeterminate.setIndeterminate(binding.cbEnable.isChecked());
            //tvEnableIndeterminate.setText(binding.cbEnable.isChecked()? R.string.status_enabled_indeterminate :
                    //R.string.status_disabled_indeterminate);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
