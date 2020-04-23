package com.androiddevs.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonAdapter.OnItemClickListener{

    ArrayList<Person> persons;
    int cont = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvPersons = findViewById(R.id.rvPersons);
        rvPersons.setLayoutManager(new LinearLayoutManager(this));

        persons = new ArrayList<>();
        persons.add(new Person("Barrack Obama", 60, R.drawable.kermit6,false));
        persons.add(new Person("Angela Merkel", 120,  R.drawable.kermit1,false));
        persons.add(new Person("Kim Jong-Un", 12,  R.drawable.kermit3,false));
        persons.add(new Person("Donald Trump", 80, R.drawable.kermit4,false));
        persons.add(new Person("Napoleon", 30,  R.drawable.kermit5,false));
        persons.add(new Person("Michael Jackson", 27, R.drawable.kermit6,false));
        persons.add(new Person("Elvis Presley", 65, R.drawable.photo,false));

        PersonAdapter adapter = new PersonAdapter(persons);
        rvPersons.setAdapter(adapter);
        adapter.setOnItemClickListener(MainActivity.this);


    }

    @Override
    public void OnLikeClick(int position) {


        Person p = persons.get(position);
        if(p.getSelected() ==false)
        p.setSelected(true);
        else
            
            p.setSelected(false);


    }

}
