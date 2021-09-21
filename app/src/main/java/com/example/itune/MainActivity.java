
/*
In Class 05
MainActivity.java
Mariann Szabo-Freund
Sai Datta Bhaskararayuni
 */

package com.example.itune;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements AppCategoriesFragment.AppCategoryListener ,TopPaidAppsFragment.TopAppL{
    String c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new AppCategoriesFragment())
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void goToTop(String category) {
        c=category;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, TopPaidAppsFragment.newInstance(c))
                .addToBackStack(null)
                .commit();

    }
    @Override
    public void goToDetails(DataServices.App app) {
        DataServices.App c = app;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, AppDetailsFragment.newInstance(c))
                .addToBackStack(null)
                .commit();

    }




}