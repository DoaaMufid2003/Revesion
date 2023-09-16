package com.example.revesion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.revesion.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements FirstFragment.NutrealListner,FirstFragment.negativeListner,FirstFragment.positiveListner{
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment fragment=FirstFragment.newInstance(R.drawable.ic_launcher_background,"Revision","Are You Sure ?");
                fragment.show(getSupportFragmentManager(),null);
            }
        });

    }
    @Override
    public void onclickpositive() {
        Toast.makeText(this, "positive", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onclicknegative() {
        Toast.makeText(this, "negative", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onclickneutal() {

    }
}