package com.example.a35_18079261_phungkhanhtoan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Table2 {
    TextView tongTien;
    String tien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table2);

        tongTien = tongTien.findViewById();
        tien = (String) getIntent().getSerializableExtra("tongtien");
        if(tien != null){
            tongTien.setText(tien);
        }
    }

    private Intent getIntent() {
    }

    private void setContentView(int activity_table2) {
    }
}
