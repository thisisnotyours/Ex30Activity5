package com.suek.ex30activity5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    // 안드로이드의 시스템 앱들 실행하기
    // ex) 전화걸기앱, 사진앱, 문자앱, 카메라앱 etc..
    // 이런앱들은 모두 지정된 'Intent Action' 값을 가지고 잇음    (ex; 카메라앱의 인텐트액션- 구글링 해보기)
    // 그래서 프로그래머는 묵시적 Intent 를 이용해서 지정된 action 의 앱들을 실행

    public void clickDial(View view) {
        // 1) 전화거는 다이얼화면 앱 실행
        Intent intent= new Intent();
        intent.setAction(Intent.ACTION_DIAL);  //다이얼앱의 약속된 액션문자열 값

        // 3) 추가적으로 다이얼화면에 미리 전화번호가 입력되어 있기를 원한다면..
        Uri uri= Uri.parse("tel:01012345678"); //Uri 로 분석해준다라는 뜻. tel: 이 있기때문에 전화번호로 인식하고 뜸
        intent.setData(uri);

        // 2)
        startActivity(intent);
    }


    public void clickSMS(View view) {
        // 4) 짧은문자 서비스 앱
        Intent intent= new Intent();
        intent.setAction(Intent.ACTION_SENDTO);

        Uri uri= Uri.parse("smsto:01012345678, 01044445555");
        intent.setData(uri);

        // 문자내용을 미리 작성해 놓을 수 있음
        // 식별자 "sms_body" 는 약속된 글씨임. 마음대로 변경 불가
        intent.putExtra("sms_body", "Hey, are you there?");    //putExtra 추가적으로 넣어주기

        startActivity(intent);

    }


    public void clickWeb(View view) {
        // 웹페이지 보여주기
        Intent intent= new Intent(Intent.ACTION_VIEW); //액션값을 생성자에서 지정가능 (액션과 데이터를 둘다 넣어 줄여쓰기 가능)
        // Intent intent= new Intent();
        // intent.setAction(Intent.ACTION_VIEW);   //이렇게 써도 되지만.. 줄여서 위처럼 지정해서 씀.

        /*Uri uri= Uri.parse("http://www.naver.com");
        intent.setData(uri);*/          //이렇게 써도되지만 ..
        intent.setData(Uri.parse("http://www.naver.com"));  //줄여서 이렇게 쓰는 것 가능

        startActivity(intent);
    }


    public void clickGallery(View view) {
        // 사진선택 앱
        Intent intent= new Intent(Intent.ACTION_PICK);
        // 반드시 추가해야할 설정
        intent.setType("image/png");
        //intent.setType("image/jng");
        //intent.setType("image/*");  // * 어떤 파일이던 다.
        //intent.setType("audio/*");
        startActivity(intent);
    }


    public void clickCamera(View view) {
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }



}//Main
