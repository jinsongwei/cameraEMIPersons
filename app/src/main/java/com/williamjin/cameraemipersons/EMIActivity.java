package com.williamjin.cameraemipersons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class EMIActivity extends AppCompatActivity {

    private static TextView tvAmount;
    private static TextView tvYear;
    private static TextView tvRate;
    private static TextView tvTotal;

    private static SeekBar sbAmount;
    private static SeekBar sbYear;
    private static SeekBar sbRate;

    private int amount = 0;
    private int year = 0;
    private int rate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi);
        tvTotal = findViewById(R.id.tvTotal);
        seekBarAmount();
        seekBarYear();
        seekBarRate();
    }

    public void seekBarAmount() {
        tvAmount = findViewById(R.id.tvAmount);
        sbAmount = findViewById(R.id.sbAmount);
        sbAmount.setMax(1000000);
        sbAmount.incrementProgressBy(100);
        tvAmount.setText("Amount: " + sbAmount.getProgress() + " / " + sbAmount.getMax());
        sbAmount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress_value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress_value = i;
                amount = i;
                tvAmount.setText("Amount: " + i + " / " + sbAmount.getMax());
                Toast.makeText(EMIActivity.this, "SeekBar in progress", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(EMIActivity.this, "SeekBar in StartTracking", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvAmount.setText("Amount: " + progress_value + " / " + sbAmount.getMax());
                Toast.makeText(EMIActivity.this, "SeekBar in StopTracking", Toast.LENGTH_LONG).show();
                tvTotal.setText(Integer.toString(amount * year * rate / 100));
            }
        });
    }

    public void seekBarYear() {
        tvYear = findViewById(R.id.tvYear);
        sbYear = findViewById(R.id.sbYear);
        sbYear.setMax(50);
        tvYear.setText("Year: " + sbYear.getProgress() + " / " + sbYear.getMax());
        sbYear.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress_value = i;
                year = i;
                tvYear.setText("Year: " + i + " / " + sbYear.getMax());
                Toast.makeText(EMIActivity.this, "SeekBar in progress", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(EMIActivity.this, "SeekBar in StartTracking", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvYear.setText("Year: " + progress_value + " / " + sbYear.getMax());
                Toast.makeText(EMIActivity.this, "SeekBar in StopTracking", Toast.LENGTH_LONG).show();
                tvTotal.setText(Integer.toString(amount * year * rate / 100));
            }
        });
    }

    public void seekBarRate() {
        tvRate = findViewById(R.id.tvRate);
        sbRate = findViewById(R.id.sbRate);
        sbRate.setMax(100);
        tvRate.setText("Rate: " + sbRate.getProgress() + "% / " + sbRate.getMax() + "%");
        sbRate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress_value = i;
                rate = i;
                tvRate.setText("Rate: " + i + "% / " + sbRate.getMax() + "%");
                Toast.makeText(EMIActivity.this, "SeekBar in progress", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(EMIActivity.this, "SeekBar in StartTracking", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvRate.setText("Rate: " + progress_value + "% / " + sbRate.getMax());
                Toast.makeText(EMIActivity.this, "SeekBar in StopTracking", Toast.LENGTH_LONG).show();
                tvTotal.setText(Integer.toString(amount * year * rate / 100));
            }
        });
    }
}
