package com.example.hui.work2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView tv1;
    private TextView tv2;
    private int iNum1,iNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        tv1.setText("在onCreate方法中赋值");
        tv2.setText("在onCreate方法中赋值");
        iNum1=0;
        iNum2=0;
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv1.setText("触发onRestart,显示view1");
        tv2.setText("触发onRestart,显示view2");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        iNum1++;
        iNum2++;
        outState.putString("tv1","onSaveInstanceState保存的值为"+iNum1);
        outState.putString("tv2",String.valueOf(iNum2));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv1.setText(savedInstanceState.getString("tv1"));
        tv2.setText("onSaveInstanceState保存的值为"+savedInstanceState.getString("tv2"));
        iNum2=Integer.parseInt(savedInstanceState.getString("tv2"));
    }
}
