package by.dzmitry_lakisau.hw06;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import static by.dzmitry_lakisau.hw06.Constants.ACTION;
import static by.dzmitry_lakisau.hw06.Constants.NAME_OF_EXTRA;

public class AppendStringsService extends IntentService{

    private String mInput = "";

    public AppendStringsService() {
        super(AppendStringsService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        try {
            Thread.sleep(500);//delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String input = null;
        if (intent != null) {
            input = intent.getStringExtra(NAME_OF_EXTRA);
        }
        mInput += input;

        Intent outputIntent = new Intent();
        outputIntent.setAction(ACTION);
        outputIntent.addCategory(Intent.CATEGORY_DEFAULT);
        outputIntent.putExtra(NAME_OF_EXTRA, mInput);
        sendBroadcast(outputIntent);
    }
}
