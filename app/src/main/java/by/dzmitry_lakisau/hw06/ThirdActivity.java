package by.dzmitry_lakisau.hw06;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = ThirdActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);

        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });


        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onNewIntent(Intent intent){//is called because of FLAG_ACTIVITY_CLEAR_TOP flag in Intent
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