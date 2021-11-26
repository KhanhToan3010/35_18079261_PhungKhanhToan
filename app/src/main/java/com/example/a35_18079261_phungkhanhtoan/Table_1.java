package com.example.a35_18079261_phungkhanhtoan;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Table_1 {
    TextView tenBan;
    String mtenBan, tongTien;
    TextView tien1,tien2, tien3, tien4;
    ImageView btnTinhTien;
    Double a, b, c, d;
    private MyService myService;
    private boolean isconnect = false;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.MyBinder binder = (MyService.MyBinder) iBinder;
            myService = binder.getService();
            isconnect = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isconnect = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table1);


        tenBan = findViewById(R.id.tenBan);
        tien1 = findViewById(R.id.tien1);
        tien2 = findViewById(R.id.tien2);
        tien3 = findViewById(R.id.tien3);
        tien4 = findViewById(R.id.tien4);
        btnTinhTien = findViewById(R.id.btnTinhTien);

        mtenBan = (String) getIntent().getSerializableExtra("object_song");
        if(mtenBan != null){
            tenBan.setText(mtenBan);
        }

        Intent intent = new Intent(Table_1.this, MyService.class);
        bindService(intent, mConnection, BIND_AUTO_CREATE);
        btnTinhTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Table_1.this, TableDetail_02.class);
                Bundle bundle = new Bundle();

                a = Double.parseDouble(tien1.getText().toString());
                b = Double.parseDouble(tien2.getText().toString());
                c = Double.parseDouble(tien3.getText().toString());
                d = Double.parseDouble(tien4.getText().toString());
                tongTien = myService.TinhTien(a,b,c,d)+"";


                bundle.putSerializable("tongtien",tongTien);
                intent1.putExtras(bundle);

                startActivity(intent1);
            }
        });


    }
}
