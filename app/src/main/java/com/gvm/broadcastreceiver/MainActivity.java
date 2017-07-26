package com.gvm.broadcastreceiver;

import android.content.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtMainAct)
    TextView textMainAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        IntentFilter filter = new IntentFilter("com.example.Broadcast");

        android.content.BroadcastReceiver receiver = new BroadcastReceiver();
        registerReceiver(receiver, filter);

        Intent intent = getIntent();
        String value = intent.getStringExtra("value");
        textMainAct.setText(value);

    }

    @OnClick(R.id.btnToSubMainAct)
    void toSubMain() {
        Intent intent = new Intent(this, SubMainActivity.class);
        startActivity(intent);
    }


}
