package com.kitesoft.ex26activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edit= findViewById(R.id.edit);
    }

    public void clickBtn(View v){

        //MainActivity에서 SecondActivity를 실행하기 위해 온 Intent 객체 참조
        Intent intent= getIntent();

        //MainActivity에 돌려줄 문자열 데이터를 EditText에서 얻어오기
        String name= edit.getText().toString();
        int age= 20;//int형도 전달하는 연습을 위해 임의의 값을 가진 변수 선언

        //돌려줄 데이터를 택배기사(intent)에게 추가
        intent.putExtra("Name", name);
        intent.putExtra("Age", age);

        //이 결과가 OK라는 식별결과코드를 지정(RESULT_OK) 하고 위에서 Extra데이터를 추가한 Intent객체 결과로 설정!!
        setResult( RESULT_OK , intent);

        finish();
    }
}
