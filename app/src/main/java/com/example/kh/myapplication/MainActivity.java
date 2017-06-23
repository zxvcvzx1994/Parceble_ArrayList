package com.example.kh.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.kh.myapplication.View.Fragment.BlankFragment;

public class MainActivity extends AppCompatActivity {

    private BlankFragment blankFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(blankFragment==null) {
            blankFragment = new BlankFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.lineMain,blankFragment, "BlankFragment").commit();
        }else
            blankFragment = (BlankFragment) getSupportFragmentManager().findFragmentByTag("BlankFragment");


    }


}
