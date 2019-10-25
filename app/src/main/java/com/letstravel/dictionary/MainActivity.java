package com.letstravel.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private ListView listView1;
private TextView txtview1;
    public static final String dictionary[]={

            "Accidial ", "dial someone's number on phone accidentally",
            "Agender  ", "people do not identify as male or female",
            "Airball  ", "completely miss the basket, rim, and backboard with a shot",
            "Automagically", "in a way that seems magical, especially by computer",
            "Barista  ", "a person whose job involves preparing and serving different types of coffee",
            "Bedunged    ", "has been soiled with or covered in dung; very old or old-fashioned.",
            "Chillax    ", "calm down and relax",
            "Conlang    ", "an invented language intended for human communication",
            "Droolworthy    ","extremely attractive or desirable",
            "Eggcorn    ","word or phrase that results from a mishearing because of similar sounds",
//            "Frankenfood    ","genetically modified food",
//            "Ginger    ","a person with red hair",
//            "Hangry    ","bad-tempered or irritable as a result of hunger",
//            "Kadult    ","person who is technically an adult due to age but still acts like a child.",
//            "Listicle    ","an article consisting of a series of items presented as a list.",
//            "Mankini    ","a brief one-piece bathing garment for men",
//            "Normie    ","an ordinary or normal person, who believes in popular opinion",
//            "Overshare    ","give out too much information",
//            "Ping    ","a signal sent from one computer to another across a network for usually diagnostic purposes",
//            "Riff    ","play a short repeated phrase or tune in popular music and jazz",
//            "Smober    ","a person who gives up smoking or nicotine use",
    };
    private Map<String, String> dictionary1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1=(ListView)findViewById(R.id.listview1);
        txtview1=(TextView)findViewById(R.id.txtview1);


        dictionary1=new HashMap<>();
        for(int i=0;i<dictionary.length;i+=2){
            dictionary1.put(dictionary[i], dictionary[i+1]);
        }

        ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,new ArrayList<String>(dictionary1.keySet()));
        listView1.setAdapter(arrayAdapter1);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dictionary2=parent.getItemAtPosition(position).toString();
                String dictionary3=dictionary1.get(dictionary2);
                txtview1.setText("Meaning of "+ " " +dictionary2+" "+ "is :"+ " " +dictionary3);
              //  Toast.makeText(MainActivity.this, "Capital of" +dictionary2+ "is :"+dictionary3, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
