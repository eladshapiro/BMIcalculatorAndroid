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

/*
Assignment:
Writing an application that calculates the physical condition,
weight and ideal weight of a human, when gender, height
physique, etc. are known according to the exercise requirement.

Algorithm:
Calculation of physical condition - weight is by the BMI Body
Mass Index in accordance with the following formula, for both
men and women:  BMI = W / H^2
and the ideal weight according to the formula:
ideal weight = (height - 100 + (age / 10)) * 0.9 * slimness.

You can look for more information in this links:
BMI-https://he.wikipedia.org/wiki/%D7%9E%D7%93%D7%93_%D7%9E%D7%A1%D7%AA_%D7%92%D7%95%D7%A3
Ideal weight-(there is a section that talk about the Ideal body weight)
https://en.wikipedia.org/wiki/Human_body_weight

 */

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

        //Define the editText-firstName,lastName,Age
        firstNameEditText = findViewById(R.id.FirstNameEditText);
        lastNameEditText = findViewById(R.id.LastNameEditText);
        ageEditText = findViewById(R.id.ageEditTextNumber);

        //Define the height seek bar
        heightSeekBar = (SeekBar) findViewById(R.id.HightSeekBar);
        selectedHeightTextView = (TextView) findViewById(R.id.selectedHightTextView);

        //Define the gender radio group ,body frame radio group
        genderButton=findViewById(R.id.GenderGroup);
        bodyFrameButton=findViewById(R.id.BodyFrameGroup);

        //Define the editText-actual weight
        actualWeightEditText=findViewById(R.id.ActualWeightEditTextNumber);

        //Define all of the results that need to change when you press submit
        BMITextView=findViewById(R.id.BMITextView);
        BodyStatusTextView=findViewById(R.id.BodyStatusTextView);
        IdealWeightTextViewOutput=findViewById(R.id.IdialWeightTextViewOutput);
        ActualWeightTextViewOutput=findViewById(R.id.ActualWeightTextViewOutput);

        //seek bar listener for showing you what is the height you are currently on
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
            case R.id.SubmitButton:     //when you press the submit button the submit() function come in action
            {
                submit(v);
                break;
            }
            case R.id.ClearButton:      //when you press the clear button all of the inputs zeroed
            {
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
        // check the body slimness
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

        //calculate the bmi accordance the formula
         bmi=Integer.parseInt(actualWeightEditText.getText().toString())/(Math.pow(heightInCm,2));
        //calculate the ideal weight accordance the formula
         idealWeight= (heightSeekBar.getProgress()-100+(Integer.parseInt(ageEditText.getText().toString())/10))*0.9*bodyFrameSlimness;

         //displaying the results to the user in the results section
         BMITextView.setText(String.valueOf(bmi));
         BodyStatusTextView.setText(weightStatus(bmi));
         IdealWeightTextViewOutput.setText(String.valueOf(idealWeight));
         ActualWeightTextViewOutput.setText(actualWeightEditText.getText().toString());
    }
    // check the users weight status according the BMI
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