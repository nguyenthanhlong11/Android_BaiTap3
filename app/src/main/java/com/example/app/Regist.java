package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app.Object.account;
import com.example.app.SQL.SQL;

import java.util.ArrayList;
import java.util.List;

public class Regist extends AppCompatActivity {
    TextView name,pass;
    List<account> acc=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_regist);

        SQL sqlRegist= new SQL(Regist.this);
        name=findViewById(R.id.txName);
        pass=findViewById(R.id.txPassword);

        Button btn =findViewById(R.id.btRegist);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check=false;
                String passWord,userName;
                userName=name.getText().toString();
                passWord=pass.getText().toString();
                account newAccount= new account(acc.size()+1,userName,passWord);
                sqlRegist.addAccount(newAccount);
//                sqlRegist.addPopular();
//                sqlRegist.newProduct();
                Intent intent = new Intent (Regist.this, LoginFrom.class);
                startActivity(intent);

            }
        });
        Button btdk =findViewById(R.id.btLogin);
        btdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Regist.this, LoginFrom.class);
                startActivity(intent);
            }
        });

    }
}