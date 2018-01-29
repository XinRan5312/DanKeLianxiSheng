package com.xinran.studyindanke.bootsheet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xinran.studyindanke.R;

/**
 * Created by houqixin on 2018/1/29.
 */

public class BootSheetMainActvity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sheet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.sl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qxStartActvity(NestedScroollViewActvity.class);
            }
        });

        findViewById(R.id.rv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qxStartActvity(RecylerViewActvity.class);
            }
        });

        findViewById(R.id.bs_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qxStartActvity(BootSheetDialogActvity.class);
            }
        });

        findViewById(R.id.beautiful).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qxStartActvity(BeautifulActvity.class);
            }
        });
    }

    private void qxStartActvity(Class<? extends AppCompatActivity> cls) {
        startActivity(new Intent(this, cls));
    }
}
