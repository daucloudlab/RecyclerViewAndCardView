package com.hathy.listsandcards;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<Person> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        rv.addOnItemTouchListener(new MyRecyclerViewTouchListener(getApplicationContext(), rv, new MyClickListener() {
            @Override
            public void onClick(View view, int position) {
                Person person = persons.get(position) ;
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class) ;
                intent.putExtra("name", person.name) ;
                intent.putExtra("age", person.age) ;
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Person person = persons.get(position) ;

                Toast.makeText(getApplicationContext(), "Сіз ұзақ бастыңыз және адамның аты " + person.name,
                        Toast.LENGTH_SHORT).show();
            }
        }));

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.emma));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.lavery));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.lillie));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }

    public interface MyClickListener{
        void onClick(View view, int position) ;
        void onLongClick(View view, int position) ;
    }


}
