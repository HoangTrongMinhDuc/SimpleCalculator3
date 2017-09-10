package com.hoangtrongminhduc.dev.simplecalculator3;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.hoangtrongminhduc.dev.simplecalculator3.R.id.btnsendr;
import static com.hoangtrongminhduc.dev.simplecalculator3.R.id.edtA;
import static com.hoangtrongminhduc.dev.simplecalculator3.R.id.edtB;
import static com.hoangtrongminhduc.dev.simplecalculator3.R.id.tvkq;

public class Calculator extends AppCompatActivity {
    public static String RESULT_AB ="result_ab";
    private TextView tvA, tvB, tvkq;
    private Button btncong, btntru, btnnhan, btnchia, btnsendr;
    private int a=0, b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        tvA=(TextView) findViewById(R.id.tvA);
        tvB=(TextView) findViewById(R.id.tvB);
        tvkq=(TextView) findViewById(R.id.tvkq);
        btncong=(Button) findViewById(R.id.btncong);
        btntru=(Button) findViewById(R.id.btntru);
        btnnhan=(Button) findViewById(R.id.btnnhan);
        btnchia=(Button) findViewById(R.id.btnchia);
        btnsendr=(Button) findViewById(R.id.btnsendr);
        getData();
        btntru.setOnClickListener(myVarListener);
        btncong.setOnClickListener(myVarListener);
        btnnhan.setOnClickListener(myVarListener);
        btnchia.setOnClickListener(myVarListener);
        btnsendr.setOnClickListener(returnResult);
    }
    private View.OnClickListener myVarListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v==btncong){
                tvkq.setText(a+"+"+b+"="+(a+b));
            }else
            if(v==btntru){
                tvkq.setText(a+"-"+b+"="+(a-b));
            }else
            if(v==btnnhan){
                tvkq.setText(a+"x"+b+"="+(a*b));
            }else tvkq.setText(a+"/"+b+"="+(a/b));
        }
    };
    private View.OnClickListener returnResult=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.putExtra(RESULT_AB,tvkq.getText());
            setResult(RESULT_OK,intent);
            finish();
        }
    };
    public void getData(){
        Intent intent = getIntent();
        a=intent.getIntExtra(MainActivity.A1,0);
        b=intent.getIntExtra(MainActivity.B1,0);
        tvA.setText(a+"");
        tvB.setText(b+"");
    }
}
