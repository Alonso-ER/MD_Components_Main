package com.example.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentFullScreenDialogBinding;



public class FullScreenDialogFragment extends DialogFragment {
    public static final String TAG = "FullScreenDialogFragment";

    FragmentFullScreenDialogBinding binding;

    public FullScreenDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFullScreenDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toolbar.setNavigationIcon(R.drawable.ic_close);
        binding.toolbar.setNavigationOnClickListener(v -> dismiss());
        binding.toolbar.setTitle(R.string.dialog_full_screen);

        binding.btnSave.setOnClickListener(v -> {
            Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show();
            dismiss();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}