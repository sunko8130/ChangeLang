package com.frontiertechnologypartners.changelang;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.mmtextview.components.MMButton;
import org.mmtextview.components.MMTextView;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeLangFragment extends BaseFragment {

    private Button btnMyan, btnEng;
    private TextView tvHello;
    private Context mContext;
    public ChangeLangFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("refresh fargment","reload current fragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("refresh fargment","reload current fragment");
        return inflater.inflate(R.layout.fragment_change_lang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //init views
        btnMyan = view.findViewById(R.id.btn_myanmar);
        btnEng = view.findViewById(R.id.btn_english);
        tvHello = view.findViewById(R.id.tv_hello);

        String defLanguage = Locale.getDefault().getLanguage();
        tvHello.setText(String.format("Locale.getDefault() - %s", defLanguage));

        //click
        btnMyan.setOnClickListener(view1 -> setNewLocale("my"));

        btnEng.setOnClickListener(view1 -> setNewLocale("en"));

    }

    private void setNewLocale(String language) {
        App.localeManager.persistLanguage(language);

//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        if (Build.VERSION.SDK_INT >= 26) {
//            ft.setReorderingAllowed(false);
//        }
//        ft.detach(this).attach(this).commit();

        new Handler().post(new Runnable() {

            @Override
            public void run()
            {
                Intent intent = getActivity().getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                getActivity().overridePendingTransition(0, 0);
                getActivity().finish();

                getActivity().overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });
    }
}
