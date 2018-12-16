package com.mobilancer.pastaneapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView txtNameDetail;
    private TextView txtDescDetail;
    private TextView txtAmountDetail;
    private TextView txtIdDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtNameDetail = findViewById(R.id.txtNameDetail);
        txtDescDetail = findViewById(R.id.txtDescDetail);
        txtAmountDetail = findViewById(R.id.txtAmountDetail);
        txtIdDetail = findViewById(R.id.txtIdDetail);
        txtNameDetail.setText((String) getIntent().getExtras().get("name"));
        txtDescDetail.setText((String) getIntent().getExtras().get("desc"));
        txtAmountDetail.setText(String.valueOf(getIntent().getExtras().get("amount")));
        txtIdDetail.setText(String.valueOf(getIntent().getExtras().get("id")));
    }

}
