package by.dzmitry_lakisau.hw06;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static by.dzmitry_lakisau.hw06.Constants.ACTION;
import static by.dzmitry_lakisau.hw06.Constants.NAME_OF_EXTRA;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReceiver mMyBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
            }
        });

        findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FragmentActivity.class));
            }
        });

        findViewById(R.id.button_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = findViewById(R.id.editText);
                String input = editText.getText().toString();

                Intent appendStringsService = new Intent(getApplicationContext(), AppendStringsService.class);
                appendStringsService.putExtra(NAME_OF_EXTRA, input);
                startService(appendStringsService);
            }
        });

        mMyBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(ACTION);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(mMyBroadcastReceiver, intentFilter);
    }

    public class MyBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String result = intent.getStringExtra(Constants.NAME_OF_EXTRA);

//            Toast toast = new Toast(getApplicationContext());
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }

}