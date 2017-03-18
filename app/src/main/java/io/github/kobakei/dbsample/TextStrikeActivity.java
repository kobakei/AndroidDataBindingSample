package io.github.kobakei.dbsample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.kobakei.dbsample.databinding.TextStrikeActivityBinding;

public class TextStrikeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextStrikeActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.text_strike_activity);
    }
}
