package com.example.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentMenuBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;

public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;
    public static final String TAG = "Menu";
    private static Component mInstance;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.image_menu_with_min);
        mInstance.setType(Constants.STATIC);
        return getmInstance();
    }


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnMenuPopup.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(), v);
            popupMenu.getMenuInflater().inflate(R.menu.menu_bottom_nav, popupMenu.getMenu());
            popupMenu.show();
        });

        String[] courses = new String[]{"Curso de Desarrollo Web Completo con HTML5, CSS3, JS AJAX PHP y MySQL",
                                        "Curso de Java Principiante a Experto - Inicios de Material Design para Android / 30hrs",
                                        "Angular - De cero a experto creando aplicaciones (Angular 8+)",
                                        "Curso de JavaScript Moderno Guía Definitiva Construye",
                                        "Curso de React JS" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                R.layout.item_menu_dropdown, courses);

        binding.actvCourses.setAdapter(adapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}