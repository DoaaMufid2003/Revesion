package com.example.revesion;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends DialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ICON = "icon";
    private static final String ARG_TITLE = "title";
    private static final String ARG_MESAGE = "mesage";

    // TODO: Rename and change types of parameters
    private String title;
    private String measge;
    private int icon;
    private FirstFragment.positiveListner positiveListner;
    private FirstFragment.negativeListner negativeListner;
    private FirstFragment.NutrealListner NutrealListner;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        if (context instanceof positiveListner) {
            positiveListner = (FirstFragment.positiveListner) context;
        }else {
            new RuntimeException("positive");
        }

            if (context instanceof negativeListner){
            negativeListner= (FirstFragment.negativeListner) context;
        }else {
                new RuntimeException("negative");
            }
            if (context instanceof NutrealListner){
            NutrealListner= (FirstFragment.NutrealListner) context;
            }else {
                new RuntimeException("negative");
            }

        super.onAttach(context);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(int icon, String title,String measge) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ICON, icon);
        args.putString(ARG_TITLE, title);
        args.putString(ARG_TITLE, measge);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            measge = getArguments().getString(ARG_MESAGE);
            icon=getArguments().getInt(ARG_ICON);

        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog= new AlertDialog.Builder(getActivity());
        alertDialog.setIcon(icon);
        alertDialog.setTitle(title);
        alertDialog.setMessage(measge);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            positiveListner.onclickpositive();
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            negativeListner.onclicknegative();
            }
        });
        alertDialog.setNeutralButton("CANCLE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            dismiss();
            }
        });
        return alertDialog.create();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
    public interface positiveListner{
        void onclickpositive();
    }
    public interface negativeListner{
        void onclicknegative();
    }
    public interface NutrealListner{
        void onclickneutal();
    }
}