package com.hoangtrongminhduc.dev.simplecalculator3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnsend;
    private EditText edtA, edtB;
    private ListView lv;
    ArrayList<String> arrList=null;
    ArrayAdapter<String> adapter=null;
    public static String A1 = "a", B1= "b";
    public static final int REQUEST_CODE=1997;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsend=(Button) findViewById(R.id.btnsend);
        edtA=(EditText) findViewById(R.id.edtA);
        edtB=(EditText) findViewById(R.id.edtB);
        lv=(ListView) findViewById(R.id.lv);
        arrList=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(adapter);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAB();
            }
        });
    }
    public void sendAB(){
        Intent intent=new Intent(MainActivity.this, Calculator.class);
        intent.putExtra(A1, Integer.parseInt(edtA.getText().toString()));
        intent.putExtra(B1, Integer.parseInt(edtB.getText().toString()));
        startActivityForResult(intent,REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK){
                String ketqua=data.getStringExtra(Calculator.RESULT_AB);
                arrList.add(ketqua);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
