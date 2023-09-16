package com.example.revesion.FragmenttoFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.revesion.R;
import com.example.revesion.databinding.FragmentFirst3Binding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link First3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class First3Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    OnFragmentClicklisener onFragmentClicklisener;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public First3Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentClicklisener)
        onFragmentClicklisener= (OnFragmentClicklisener) context;
        else
            throw new ClassCastException("your actiivity dosnt implement OnFragmentClicklisener");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.

     * @return A new instance of fragment First3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static First3Fragment newInstance(String param1) {
        First3Fragment fragment = new First3Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentFirst3Binding binding=FragmentFirst3Binding.inflate(inflater,container,false);
        ArrayList<Name> arrayList=new ArrayList<>();
        arrayList.add(new Name("BBB"));
        arrayList.add(new Name("EE"));
        arrayList.add(new Name("BBEEB"));
        arrayList.add(new Name("YY"));
        arrayList.add(new Name("II"));
        arrayList.add(new Name("GC"));
        Adapter adapter=new Adapter(arrayList, new MyLestiner() {
            @Override
            public void onclick(Name name) {
            onFragmentClicklisener.OnclickFragment(name);
            }
        });
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        return binding.getRoot();
    }
    public interface OnFragmentClicklisener{
        void OnclickFragment(Name name);
    }

}

