package com.letstravel.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private ListView listView1;
private TextView txtview1;
private AutoCompleteTextView autoCompleteTextView;
    public static final String dictionary[]={

            "Accidial ", "dial someone's number on phone accidentally",
            "Agender  ", "people do not identify as male or female",
//            "Airball  ", "completely miss the basket, rim, and backboard with a shot",
            "Chillax    ", "calm down and relax",
            "Conlang    ", "an invented language intended for human communication",
            "Ginger    ","a person with red hair",
            "Hangry    ","bad-tempered or irritable as a result of hunger",
            "Listicle    ","an article consisting of a series of items presented as a list.",
            "Mankini    ","a brief one-piece bathing garment for men",
//            "Normie    ","an ordinary or normal person, who believes in popular opinion",
            "Overshare    ","give out too much information",
            "Smober    ","a person who gives up smoking or nicotine use",
    };
    private Map<String, String> dictionary1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1=(ListView)findViewById(R.id.listview1);
        txtview1=(TextView)findViewById(R.id.txtview1);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.autocompletetextview);
//        listView1.setFastScrollEnabled(true);
//        listView1.setFastScrollAlwaysVisible(true);

        dictionary1=new HashMap<>();
        for(int i=0;i<dictionary.length;i+=2){
            dictionary1.put(dictionary[i], dictionary[i+1]);
        }

        ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,new ArrayList<String>(dictionary1.keySet()));
        listView1.setAdapter(arrayAdapter1);
        autoCompleteTextView.setAdapter(arrayAdapter1);
        autoCompleteTextView.setThreshold(1);




        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dictionary2=parent.getItemAtPosition(position).toString();
                String dictionary3=dictionary1.get(dictionary2);
                txtview1.setText("Meaning of "+ " " +dictionary2+" "+ "is :"+ " " +dictionary3);
              // Toast.makeText(MainActivity.this, "Capital of" +dictionary2+ "is :"+dictionary3, Toast.LENGTH_SHORT).show();

            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id1) {
                String dictionary2=parent.getItemAtPosition(position).toString();
                String dictionary3=dictionary1.get(dictionary2);
                txtview1.setText("Meaning of "+ " " +dictionary2+" "+ "is :"+ " " +dictionary3);
            }
        });

    }
}
