package com.example.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentTextFieldBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;

public class TextFieldFragment extends Fragment {

    public static final String TAG = "Text Fields";
    private static Component mInstance;
    private FragmentTextFieldBinding binding;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_textfields_outlined_active);
        mInstance.setType(Constants.SCROLL);
        return getmInstance();
    }
    public TextFieldFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTextFieldBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tilCapitalLetter.setEndIconOnClickListener( view1 -> {
            if(binding.etCapitalLetter.getText() != null ){
                String content = binding.etCapitalLetter.getText().toString();
                binding.etCapitalLetter.setText(content.toUpperCase());
            }
        });

        binding.etPrice.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Do nothing
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().isEmpty() && Integer.valueOf(editable.toString()) < 5 ){
                   binding.etPrice.setError(getString(R.string.error_price_min));
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}