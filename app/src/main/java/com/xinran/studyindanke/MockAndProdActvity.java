package com.xinran.studyindanke;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by houqixin on 2018/2/6.
 *
 * https://www.jianshu.com/p/98ee75dd49f4 在mock和prod不同的变体 同样的类同样的方法 但是方法的实现内容不一样 实现不同的效果
 也可以看做是不同的安装包，手机上也会成为俩APP
 */

public class MockAndProdActvity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock_prod);
        TextView tv= (TextView) findViewById(R.id.tv_mock);

        tv.setText(StringUtil.newString());

    }
}
