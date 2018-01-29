package com.xinran.studyindanke.bootsheet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.xinran.studyindanke.R;

/**
 * Created by houqixin on 2018/1/29.
 */

public class NestedScroollViewActvity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ns);

        // The View with the BottomSheetBehavior
        NestedScrollView bottomSheet= (NestedScrollView) findViewById(R.id.bottom_sheet);

         final BottomSheetBehavior behavior=BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //这里是bottomSheet 状态的改变，根据slideOffset可以做一些动画
                Log.e("qx", "newState--->" + newState+" bottomSheet=="+bottomSheet);
//                ViewCompat.setScaleX(bottomSheet,1);
//                ViewCompat.setScaleY(bottomSheet,1);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //这里是拖拽中的回调，根据slideOffset可以做一些动画
                Log.e("qx", "slideOffset=====》" + slideOffset+" bottomSheet=="+bottomSheet);
//                ViewCompat.setScaleX(bottomSheet,slideOffset);
//                ViewCompat.setScaleY(bottomSheet,slideOffset);
            }
        });

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("qx","behavior:"+behavior.getState());
                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    Log.e("qx","behavior:"+behavior.getState());
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });
    }
}
