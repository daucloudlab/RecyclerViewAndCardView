package com.hathy.listsandcards;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.info_actitvity);

        String name = getIntent().getStringExtra("name") ;
        String age = getIntent().getStringExtra("age") ;

        TextView nameTextView = (TextView)findViewById(R.id.name) ;
        TextView ageTextView = (TextView)findViewById(R.id.age) ;
        nameTextView.setText(name);
        ageTextView.setText(age);
    }
}
