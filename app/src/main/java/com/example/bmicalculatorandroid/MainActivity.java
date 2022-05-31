package com.example.bmicalculatorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText firstNameEditText;
    EditText lastNameEditText;
    EditText ageEditText;
    SeekBar heightSeekBar;
    TextView selectedHeightTextView;
    RadioGroup genderButton;
    RadioGroup bodyFrameButton;
    EditText actualWeightEditText;
    TextView BMITextView;
    TextView BodyStatusTextView;
    TextView IdealWeightTextViewOutput;
    TextView ActualWeightTextViewOutput;
    double bodyFrameSlimness=0;
    double heightInCm;
    double idealWeight;
    double bmi;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firstName,lastName,Age
        firstNameEditText = findViewById(R.id.FirstNameEditText);
        lastNameEditText = findViewById(R.id.LastNameEditText);
        ageEditText = findViewById(R.id.ageEditTextNumber);

        //height seek bar
        heightSeekBar = (SeekBar) findViewById(R.id.HightSeekBar);
        selectedHeightTextView = (TextView) findViewById(R.id.selectedHightTextView);

        //gender radio group ,body frame radio group
        genderButton=findViewById(R.id.GenderGroup);
        bodyFrameButton=findViewById(R.id.BodyFrameGroup);

        //	getCheckedRadioButtonId()- to see in the group

        //actual weight
        actualWeightEditText=findViewById(R.id.ActualWeightEditTextNumber);

        //all of the results
        BMITextView=findViewById(R.id.BMITextView);
        BodyStatusTextView=findViewById(R.id.BodyStatusTextView);
        IdealWeightTextViewOutput=findViewById(R.id.IdialWeightTextViewOutput);
        ActualWeightTextViewOutput=findViewById(R.id.ActualWeightTextViewOutput);


        heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                selectedHeightTextView.setText("selected height = " + heightSeekBar.getProgress() + " cm");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.SubmitButton:
            {
                submit(v);
                break;
            }
            case R.id.ClearButton: {
                BMITextView.setText("---");
                BodyStatusTextView.setText("---");
                IdealWeightTextViewOutput.setText("---");
                ActualWeightTextViewOutput.setText("---");

                firstNameEditText.setText("");
                lastNameEditText.setText("");
                ageEditText.setText("");

                heightSeekBar.setProgress(140);

                genderButton.clearCheck();
                bodyFrameButton.clearCheck();

                actualWeightEditText.setText("");
                break;
            }
        }
    }

    public void submit(View v)
    {
        if (bodyFrameButton.getCheckedRadioButtonId()==R.id.LargeRadioButton)
        {
            bodyFrameSlimness=1.1;
        }
        if (bodyFrameButton.getCheckedRadioButtonId()==R.id.MediumRadioButton)
        {
            bodyFrameSlimness=1;
        }
        if (bodyFrameButton.getCheckedRadioButtonId()==R.id.SmallRadioButton)
        {
            bodyFrameSlimness=0.9;
        }

         heightInCm=heightSeekBar.getProgress()*0.01;
         bmi=Integer.parseInt(actualWeightEditText.getText().toString())/(Math.pow(heightInCm,2));
         idealWeight= (heightSeekBar.getProgress()-100+(Integer.parseInt(ageEditText.getText().toString())/10))*0.9*bodyFrameSlimness;

         BMITextView.setText(String.valueOf(bmi));
        BodyStatusTextView.setText(weightStatus(bmi));
         IdealWeightTextViewOutput.setText(String.valueOf(idealWeight));
         ActualWeightTextViewOutput.setText(actualWeightEditText.getText().toString());
    }

    public String weightStatus(double bmi)
    {
        if (bmi<15)
        {
            return "Anorexic ";
        }
        if (bmi>=15 && bmi<=18.5)
        {
            return "Underweight ";
        }
        if (bmi>=18.5 && bmi<=24.9)
        {
            return "Normal ";
        }
        if (bmi>=25 && bmi<=29.9)
        {
            return "Overweight  ";
        }
        if (bmi>=30 && bmi<=35)
        {
            return "Obese  ";
        }
        if (bmi>=35)
        {
            return "Extreme Obese  ";
        }
        return "";
    }

}