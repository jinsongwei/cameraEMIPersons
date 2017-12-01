package com.williamjin.cameraemipersons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.williamjin.cameraemipersons.model.Person;

import java.util.List;

public class listPeopleActivity extends AppCompatActivity {
    TextView tvPeople;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_people);

        tvPeople = findViewById(R.id.tvPeople);
        List<Person> people = getIntent().getParcelableArrayListExtra("people");
        StringBuilder result = new StringBuilder();
        for(Person p : people){
            result.append(p.toString()).append("\n");
        }
        tvPeople.setText(result);
    }
}
