package com.gvm.broadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Voldarex on 7/26/2017.
 */

public class BroadcastReceiver extends android.content.BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        String value = intent.getStringExtra("value");

        Toast.makeText(context, value,
                Toast.LENGTH_LONG).show();

        Intent main = new Intent(context, MainActivity.class);
        main.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        main.putExtra("value", value);
        context.startActivity(main);

        Intent sub = new Intent(context, SubMainActivity.class);
        sub.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        sub.putExtra("value", value);
        context.startActivity(sub);
    }
}
