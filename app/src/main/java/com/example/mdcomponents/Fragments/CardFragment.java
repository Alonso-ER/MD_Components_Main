package com.example.mdcomponents.Fragments;

import android.app.DownloadManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentCardBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;

import butterknife.OnClick;


public class CardFragment extends Fragment {

    private FragmentCardBinding binding;
    public static final String TAG = "Card";
    private static Component mInstance;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_cards_template);
        mInstance.setType(Constants.SCROLL);
        return getmInstance();
    }

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentCardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();

        Glide.with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Good_Food_Display_-_NCI_Visuals_Online.jpg/800px-Good_Food_Display_-_NCI_Visuals_Online.jpg")
                .apply(options)
                .into(binding.cardImgLarge);

        binding.chipFirst.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "First Chip", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        binding.chipSecond.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if (isChecked) {
                        Toast.makeText(getActivity(), "Second Chip Checked", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Second Chip Unchecked", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        binding.chipThird.setOnCloseIconClickListener( v -> binding.chipThird.setVisibility(View.GONE));

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }


}