package by.dzmitry_lakisau.hw06;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);

                CheckBox checkBox = findViewById(R.id.checkBox);
                if (checkBox.isChecked())
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

                startActivity(intent);
            }
        });

        findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onNewIntent(Intent intent){//is called because of android:launchMode="singleTop" property
        super.onNewIntent(intent);

        Log.d(TAG, "onNewIntent");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onResume(){//is called after onCreate or onNewIntent
        super.onResume();

        Log.d(TAG, "onResume");
    }
}