package com.example.appgmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView;
        listView = findViewById(R.id.listViewApp);
        ArrayList<AppEntity> arrayList;
        AdapterGmail adapterGmail;
        arrayList = new ArrayList<>();
        AppEntity s1 = new AppEntity("hung@gmail.com", "Nhân ngày sinh nhật của tôi","Gửi thư mời sinh nhật", "13:00 pm" );
        s1.setImage(s1.getName().charAt(0));
        arrayList.add(s1);
        AppEntity s2 = new AppEntity("huy@gmail.com", "Nhân ngày sinh nhật của tôi","Gửi thư mời sinh nhật", "15:00 pm");
        s1.setImage(s2.getName().charAt(0));
        arrayList.add(s2);
        AppEntity s3 = new AppEntity("quan@gmail.com", "Nhân ngày sinh nhật của tôi","Gửi thư mời sinh nhật", "16:00 pm");
        s1.setImage(s3.getName().charAt(0));
        arrayList.add(s3);
        AppEntity s4 = new AppEntity("dung@gmail.com", "Nhân ngày sinh nhật của tôi","Gửi thư mời sinh nhật", "17:00 pm");
        s1.setImage(s4.getName().charAt(0));
        arrayList.add(s4);
        AppEntity s5 = new AppEntity("doan@gmail.com", "Nhân ngày sinh nhật của tôi","Gửi thư mời sinh nhật", "18:00 pm");
        s1.setImage(s5.getName().charAt(0));
        arrayList.add(s5);
        adapterGmail = new AdapterGmail(MainActivity.this, R.layout.layout_gmail, arrayList);
        listView.setAdapter(adapterGmail);
        Boolean isPlay = true;
//        ImageView imageViewStart = findViewById(R.id.startApp);
//        imageViewStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 if(isPlay) {
//                     imageViewStart.setImageResource(R.drawable.start_run);
//                 }else {
//                     imageViewStart.setImageResource(R.drawable.star_init);
//                 }
//            }
//        });
    }
}