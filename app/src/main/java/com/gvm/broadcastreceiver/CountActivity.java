package com.gvm.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountActivity extends AppCompatActivity {

    @BindView(R.id.txtCount)
    TextView textCount;

    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCount)
    void count() {
        number++;
        textCount.setText(Integer.toString(number));
    }

    @OnClick(R.id.btnMainAct)
    void toMainAct() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        broadcastingData();
    }

    @OnClick(R.id.btnSubMainAct)
    void toSubMainAct() {
        Intent intent = new Intent(this, SubMainActivity.class);
        startActivity(intent);
        broadcastingData();
    }

    public void broadcastingData() {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.setAction("com.example.Broadcast");
        intent.putExtra("value", Integer.toString(number));
        sendBroadcast(intent);
    }
}
