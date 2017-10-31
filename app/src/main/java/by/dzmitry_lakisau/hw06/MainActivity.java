package by.dzmitry_lakisau.hw06;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static by.dzmitry_lakisau.hw06.Constants.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = new Fragment_1();
        fragmentTransaction.add(R.id.container_1, fragment, FRAGMENT_1);
        fragment = new Fragment_2();
        fragmentTransaction.add(R.id.container_2, fragment, FRAGMENT_2);

        fragmentTransaction.commit();

//        findViewById(R.id.container_1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                findViewById(R.id.button_1).setVisibility(View.VISIBLE);
//            }
//        });

        findViewById(R.id.container_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.button_2).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = fragmentManager.findFragmentByTag(FRAGMENT_1);
                fragmentTransaction.show(fragment).commit();

                findViewById(R.id.button_1).setVisibility(View.GONE);
            }
        });

        findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = fragmentManager.findFragmentByTag(FRAGMENT_2);
                fragmentTransaction.show(fragment).commit();

                findViewById(R.id.button_2).setVisibility(View.GONE);
            }
        });
    }
}
