package com.kitesoft.ex26activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
    }

    //startActivityForResult()로 실행한 Activity가
    //종료되어 다시 이 액티비티가 보이게 될때
    //자동으로 실행되는 콜백 메소드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //Data를 가지고 돌아온 Intent가 clickBtn()메소드에서 startActivityForResult()를 호출하면서 2번째 파라미터로 전달한 식별요청코드와 같은지 switch문으로 통해 확인
        switch ( requestCode ){
            case 10: //startActivityForResult()의 2번째 파라미터로 전달했던 식별요청코드값

                //SecondActivity에서 Data를 보내지 않고 뒤로가기로 그냥 취소했을 수도 있으므로 이를 결과코드를 확인
                // 결과코드(resultCode): RESULT_OK 는 SecondActivity에서 setResult( RESULT_OK , intent);를 통해 지정한 값임
                if( resultCode == RESULT_OK){

                    //이 onActivityResult()메소드의 3번째 파라미터 인 Intent객체(참조변수명 data)에게 SecondActivity로부터 가져온 Extra데이터 얻어오기
                    String name= data.getStringExtra("Name");
                    int age= data.getIntExtra("Age", 0);

                    //얻어온 값 TextView에 출력하여 확인하기
                    tv.setText(name +" , "+ age);
                }

                break;
        }



        super.onActivityResult(requestCode, resultCode, data);
    }

    public void clickBtn(View v){
        //SecondActivity를 실행하는 Intent(택배기사)객체 생성
        Intent intent= new Intent(this, SecondActivity.class);
        //SecondActivity로 부터 Data를 받으려면 startActivity()가 아니라 반드시 startActivityForResult()로 실행해야만 함
        startActivityForResult(intent, 10); //2번째 파라미터 [requestCode] : 결과를 가지고온 Intent가 이 코드에서 실행한 Intent가 맞는지 확인하기 위한 임의의 식별요청코드(정수형 숫자 아무거나 써도 상관없음)

    }
}
