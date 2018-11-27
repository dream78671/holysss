package com.jeff.umar.p101;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    transaction.replace(R.id.container,new Home()).commit();

                    return true;
                case R.id.Classes:
                    Toast.makeText(MainActivity.this, "My Classes", Toast.LENGTH_SHORT).show();
                    transaction.replace(R.id.container,new Classes()).commit();

                    return true;
                case R.id.Myaccount:
                    Toast.makeText(MainActivity.this, "My Account", Toast.LENGTH_SHORT).show();
                    transaction.replace(R.id.container,new MyAccount()).commit();

                    return true;
                case R.id.Holyheadweb:
                    Toast.makeText(MainActivity.this, "Holyhead Website", Toast.LENGTH_SHORT).show();
                    transaction.replace(R.id.container,new Holyheadweb()).commit();

                    return true;

                case R.id.Events:
                    Toast.makeText(MainActivity.this, "Events", Toast.LENGTH_SHORT).show();
                    transaction.replace(R.id.container,new Eventsfrag()).commit();

                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container,new Home()).commit();


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
