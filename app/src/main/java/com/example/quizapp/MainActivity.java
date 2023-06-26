package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView currentquestiontextview;
    TextView questiontextview;
    Button B1,B2,B3,B4;
    Button B5,B8;
    int questionindex=0;
    int score=0;
    String answerselected="";
//    int flag1=0,flag2=0,flag3=0,flag4=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentquestiontextview=findViewById(R.id.textView7);
        questiontextview=findViewById(R.id.textView8);
        B1=(Button)findViewById(R.id.button1);
        B2=(Button)findViewById(R.id.button2);
        B3=(Button)findViewById(R.id.button3);
        B4=(Button)findViewById(R.id.button4);
        B5=findViewById(R.id.button5);

        B8=findViewById(R.id.button8);
        B1.setOnClickListener(this);
        B2.setOnClickListener(this);
        B3.setOnClickListener(this);
        B4.setOnClickListener(this);

        loadquestion();

    }

    void loadquestion(){
        questiontextview.setText(questions.ques[questionindex]);
        B1.setText(questions.choices[questionindex][0]);
        B2.setText(questions.choices[questionindex][1]);
        B3.setText(questions.choices[questionindex][2]);
        B4.setText(questions.choices[questionindex][3]);

    }

    public void next(View view) {if(questionindex <4) {
            questionindex++;
        B1.setBackgroundColor(Color.WHITE);
        B2.setBackgroundColor(Color.WHITE);
        B3.setBackgroundColor(Color.WHITE);
        B4.setBackgroundColor(Color.WHITE);
            currentquestiontextview.setText("Q:"+(questionindex+1)+"/5");
            loadquestion();
    }
    }

    @Override
    public void onClick(View v) {
        B1.setBackgroundColor(Color.WHITE);
        B2.setBackgroundColor(Color.WHITE);
        B3.setBackgroundColor(Color.WHITE);
        B4.setBackgroundColor(Color.WHITE);

        Button clickedButton =(Button) v;
        clickedButton.setBackgroundColor(Color.GREEN);
        answerselected=clickedButton.getText().toString();
        if(answerselected==questions.answer[questionindex]){
            score++;
        }
    }


    public void submit(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("you score is "+score);
        builder.setCancelable(false);
        builder.setPositiveButton("RetakeQUIZ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                questionindex=0;
                score=0;
                loadquestion();
                answerselected="";
                B1.setBackgroundColor(Color.WHITE);
                B2.setBackgroundColor(Color.WHITE);
                B3.setBackgroundColor(Color.WHITE);
                B4.setBackgroundColor(Color.WHITE);

            }
        });
        builder.create().show();
    }
}