package com.alain.cursos.alonso.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alain.cursos.alonso.R;
import com.alain.cursos.alonso.databinding.FragmentDialogBinding;
import com.alain.cursos.alonso.utils.Component;
import com.alain.cursos.alonso.utils.Constants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AlertDialogFragment extends Fragment {

    FragmentDialogBinding binding;

    public static final String TAG = "Dialog";

    private static Component mInstance;


    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_dialog_mobile_alert);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public AlertDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnDialogInfo.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(getActivity())
                    .setTitle(R.string.card_message_demo_small)
                    .setPositiveButton(R.string.dialog_ok, null)
                    .show();
        });

        binding.btnDialogChooser.setOnClickListener(v -> {
            final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.select_dialog_item);
            adapter.add("Opción 1");
            adapter.add("Opción 2");
            adapter.add("Opción 3");

            new MaterialAlertDialogBuilder(getActivity())
                    .setTitle(R.string.dialog_chooser)
                    .setAdapter(adapter, (dialogInterface, i) ->
                            Toast.makeText(getActivity(), adapter.getItem(i), Toast.LENGTH_SHORT).show())
                    .show();
        });

        binding.btnDialogConfirm.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(getActivity())
                    .setTitle(R.string.dialog_confirm_title)
                    .setMessage(R.string.card_message_demo_small)
                    .setPositiveButton(R.string.dialog_confirm, (dialogInterface, i) ->
                            Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show())
                    .setNegativeButton(R.string.dialog_cancel, null)
                    .show();
        });

        binding.btnDialogFullScreen.setOnClickListener(v -> {
            FullScreenDialogFragment dialogFragment = new FullScreenDialogFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            dialogFragment.show(transaction, FullScreenDialogFragment.TAG);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
