package com.alain.cursos.alonso.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alain.cursos.alonso.utils.Component;
import com.alain.cursos.alonso.utils.Constants;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.snackbar.Snackbar;
import com.mdcomponents.cursos.alain.R;
import com.mdcomponents.cursos.alain.databinding.FragmentPickerBinding;

public class PickerFragment extends Fragment {

    FragmentPickerBinding binding;

    public static final String TAG = "Picker";

    public static Component getmInstance() {
        Component mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_picker);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public PickerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPickerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText(R.string.picker_title);
        builder.setSelection(System.currentTimeMillis());

        binding.btnDialog.setOnClickListener(v -> {
            builder.setTheme(com.google.android.material.R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);
        });
        binding.btnFullscreen.setOnClickListener(v -> {
            builder.setTheme(com.google.android.material.R.style.ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen);
        });

        MaterialDatePicker<?> picker = builder.build();
        picker.addOnPositiveButtonClickListener(selection ->
                //Snackbar.make(containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG).show());
                Snackbar.make(binding.containerMain, picker.getHeaderText(), Snackbar.LENGTH_LONG).show());
        picker.addOnNegativeButtonClickListener(dialog ->
                Snackbar.make(binding.containerMain, R.string.dialog_negative, Snackbar.LENGTH_LONG).show());
        picker.addOnCancelListener(dialogInterface ->
                Snackbar.make(binding.containerMain, R.string.dialog_cancel, Snackbar.LENGTH_LONG).show());
        picker.show(getParentFragmentManager(), picker.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
