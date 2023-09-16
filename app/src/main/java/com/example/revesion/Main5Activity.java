package com.example.revesion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.revesion.FragmenttoFragment.First3Fragment;
import com.example.revesion.FragmenttoFragment.Name;
import com.example.revesion.FragmenttoFragment.SecoundFragment;
import com.example.revesion.databinding.ActivityMain5Binding;

public class Main5Activity extends AppCompatActivity implements First3Fragment.OnFragmentClicklisener {
ActivityMain5Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.FirstFrame,new First3Fragment()).addToBackStack("f1").commit();
    }
    @Override
    public void OnclickFragment(Name name) {
        SecoundFragment fragment=SecoundFragment.newInstance(name.getName());
        getSupportFragmentManager().beginTransaction().replace(R.id.SecoundFrame,fragment).addToBackStack("f1").commit();
    }
}