package com.example.mdcomponents.Fragments;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentDialogBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AlertDialogFragment extends Fragment {

    private FragmentDialogBinding binding;

    public static final String TAG = "Dialog";
    private static Component mInstance;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_dialog_mobile_alert);
        mInstance.setType(Constants.STATIC);
        return getmInstance();
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
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.select_dialog_item);
            arrayAdapter.add("Item 1");
            arrayAdapter.add("Item 2");
            arrayAdapter.add("Item 3");

            new MaterialAlertDialogBuilder(getActivity())
                    .setTitle(R.string.dialog_chooser)
                    .setAdapter(arrayAdapter, (dialog, i) ->
                        Toast.makeText(getActivity(), arrayAdapter.getItem(i), Toast.LENGTH_SHORT).show())
                    .show();
        });

        binding.btnDialogConfirm.setOnClickListener(v -> {
            //new MaterialAlertDialogBuilder(getActivity())
            //new MaterialAlertDialogBuilder(getActivity(), com.google.android.material.R.style.ThemeOverlay_MaterialComponents_Dialog)
            new MaterialAlertDialogBuilder(getActivity(), com.google.android.material.R.style.MaterialAlertDialog_MaterialComponents_Title_Icon)
                    .setTitle(R.string.dialog_confirm_title)
                    .setMessage(R.string.card_message_demo_small)
                    .setPositiveButton(R.string.dialog_ok, (dialog, i) ->
                            Toast.makeText(getActivity(), R.string.message_action_success,
                                    Toast.LENGTH_SHORT).show() )
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