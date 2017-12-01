package com.williamjin.cameraemipersons;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.williamjin.cameraemipersons.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonsActivity extends AppCompatActivity {
    List<Person> people = new ArrayList<>();

    TextView etPersonName;
    TextView etPersonAge;
    TextView etPersonGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);

        etPersonName = findViewById(R.id.etPersonName);
        etPersonGender = findViewById(R.id.etPersonGender);
        etPersonAge = findViewById(R.id.etPersonAge);
    }


    public void sendPerson(View view) {
        Intent intent = new Intent(this, listPeopleActivity.class);
        intent.putParcelableArrayListExtra("people", (ArrayList<? extends Parcelable>) people);
        startActivity(intent);
    }

    public void addPerson(View view) {
        String name = etPersonName.getText().toString();
        String gender = etPersonGender.getText().toString();
        String age = etPersonAge.getText().toString();
        people.add(new Person(name, age, gender));
        etPersonName.setText("");
        etPersonAge.setText("");
        etPersonGender.setText("");
    }
}
