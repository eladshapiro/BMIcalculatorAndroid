package com.example.bmicalculatorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText firstNameEditText;
    EditText lastNameEditText;
    EditText ageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNameEditText=findViewById(R.id.FirstNameEditText);
        lastNameEditText=findViewById(R.id.LastNameEditText);
        ageEditText=findViewById(R.id.ageEditTextNumber);
    }
}