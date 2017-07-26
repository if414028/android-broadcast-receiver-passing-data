package com.gvm.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubMainActivity extends AppCompatActivity {

    @BindView(R.id.txtSubMain)
    TextView textSubMainAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);
        ButterKnife.bind(this);

        IntentFilter filter = new IntentFilter("com.example.Broadcast");

        android.content.BroadcastReceiver receiver = new BroadcastReceiver();
        registerReceiver(receiver, filter);

        Intent intent = getIntent();
        String value = intent.getStringExtra("value");
        textSubMainAct.setText(value);

    }

    @OnClick(R.id.btnNextToCountAct)
    void toCountAct() {
        Intent intent = new Intent(this, CountActivity.class);
        startActivity(intent);
    }
}
