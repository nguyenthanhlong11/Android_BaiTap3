package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app.Object.account;
import com.example.app.SQL.SQL;

import java.util.ArrayList;
import java.util.List;

public class LoginFrom extends AppCompatActivity {

    List<account> acc=new ArrayList<>();
    TextView name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_login_from);

        SQL s1= new SQL(LoginFrom.this);

        name=findViewById(R.id.txName);
        pass=findViewById(R.id.txPassword);
        Button btn =findViewById(R.id.btRegist);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                acc= s1.getAccount();
                boolean check=false;
                String passWord,userName;
                userName=name.getText().toString();
                passWord=pass.getText().toString();

                for (int i=0;i<acc.size();i++){
                    if(acc.get(i).getUserName().equals(userName) && acc.get(i).getPassWord().equals(passWord)){
                        Log.d("Đăng nhập","Thành công");
                        Intent intent = new Intent (LoginFrom.this, tabnavi.class);
                        startActivity(intent);
                    }else {
                        Log.d("Đăng nhập",acc.get(i).getUserName()+acc.get(i).getPassWord()+userName+passWord);
                    }
                }

            }
        });

        Button btdk =findViewById(R.id.btLogin);
        btdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LoginFrom.this, Regist.class);
                startActivity(intent);
            }
        });
    }
}