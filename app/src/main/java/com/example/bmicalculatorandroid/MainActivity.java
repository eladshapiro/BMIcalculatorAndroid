package com.example.bmicalculatorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText firstNameEditText;
    EditText lastNameEditText;
    EditText ageEditText;
    SeekBar heightSeekBar;
    TextView selectedHeightTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firstName,lastName,Age
        firstNameEditText=findViewById(R.id.FirstNameEditText);
        lastNameEditText=findViewById(R.id.LastNameEditText);
        ageEditText=findViewById(R.id.ageEditTextNumber);

        //height seek bar
        heightSeekBar = (SeekBar) findViewById(R.id.HightSeekBar);
        selectedHeightTextView = (TextView) findViewById(R.id.selectedHightTextView);

        heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                selectedHeightTextView.setText("selected height = " + heightSeekBar.getProgress()+" cm");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}