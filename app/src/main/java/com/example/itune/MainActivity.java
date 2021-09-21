
/*
In Class 05
MainActivity.java
Mariann Szabo-Freund
Sai Datta Bhaskararayuni
 */

package com.example.itune;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements AppCategoriesFragment.AppCategoryListener {
    String c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new AppCategoriesFragment())
                .commit();
    }


    @Override
    public void goToTop(String category) {
        c=category;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, TopPaidAppsFragment.newInstance(c))
                .commit();

    }
 /*   public void goToTopPaidApps(String category ) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, TopPaidAppsFragment.newInstance(category))
                .addToBackStack(null)
                .commit();
    }*/

}