package com.alain.cursos.alonso.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.mdcomponents.cursos.alain.R;
import com.mdcomponents.cursos.alain.databinding.FragmentFullScreenDialogBinding;

public class FullScreenDialogFragment extends DialogFragment {
    FragmentFullScreenDialogBinding binding;

    public static final String TAG = "FullScreenDialogFragment";

    public FullScreenDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFullScreenDialogBinding.inflate(inflater, container, false);

        binding.toolbar.setNavigationIcon(R.drawable.ic_close);
        binding.toolbar.setNavigationOnClickListener(view1 -> dismiss());
        binding.toolbar.setTitle(R.string.dialog_full_screen);

        binding.btnSave.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(),
            R.string.message_action_success, Toast.LENGTH_SHORT).show();
            dismiss();
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
