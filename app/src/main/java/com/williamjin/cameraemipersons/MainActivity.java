package com.williamjin.cameraemipersons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void handleProjectButton(View view) {
        switch (view.getId()){
            case R.id.btnCameraProject:
                startActivity(new Intent(this, CameraActivity.class));
                break;
            case R.id.btnEMIProject:
                startActivity(new Intent(this, EMIActivity.class));
                break;
            case R.id.btnPersonsProject:
                startActivity(new Intent(this, PersonsActivity.class));
                break;
        }
    }
}
