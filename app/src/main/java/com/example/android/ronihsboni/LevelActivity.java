package com.example.android.ronihsboni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LevelActivity extends AppCompatActivity {

//    final static String Level_ONE = "Level One";
//    final static String Level_TWO = "Level Two";
//    final static String Level_THREE = "Level Three";


    TextView levelTextView;

    TextView exerciseTextView;

    EditText UserSolutionEditText;

    Button submitAnswer;

    TextView resultTextView;

    TextView numOfAnswer;

    AbstractGame game;

    Exercise currExercise;

    int numLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        exerciseTextView = findViewById(R.id.exercise_textView);

        UserSolutionEditText= findViewById(R.id.user_solution_editText);

        resultTextView= findViewById(R.id.result_textView);

        levelTextView= findViewById(R.id.level_textView);

        numOfAnswer = findViewById(R.id.numOfAnswer_TextView);
        Intent intentFromMainActivity = getIntent();

        if ( intentFromMainActivity.hasExtra(Intent.EXTRA_TEXT)) {
             game =(AbstractGame)  intentFromMainActivity.getSerializableExtra(Intent.EXTRA_TEXT);
        }

        numLevel= game.getNumLevel();
       levelTextView.setText("the level is:"+numLevel);
        currExercise = game.getCurrExercise();

        exerciseTextView.setText(currExercise.toString());

        displayResult();


    }

    int numOfTrueAnswer=0;
    int numOfFalseAnswer=0;

    private void displayResult () {

        numOfAnswer.setText(""+numOfTrueAnswer+"/"+(numOfFalseAnswer+numOfTrueAnswer));


    }

    private double getUserNumber () throws IllegalArgumentException   {
        if(UserSolutionEditText.length()==0 ) {
            throw new IllegalArgumentException("Invalid input...");
        }
        else {
            String userAnsString = UserSolutionEditText.getText().toString();
            UserSolutionEditText.getText().clear();
            double userAns= Double.valueOf(userAnsString); // throw NumberFormatException

            return userAns;

        }

    }

    public void newExercise(View view) {

        try {
            double userAns= getUserNumber ();

            if (currExercise.checkSolution(userAns) ){ // right

                resultTextView.setText("TRUE");
                game.createNewExercise();
                currExercise = game.getCurrExercise();

                exerciseTextView.setText(currExercise.toString());
                numOfTrueAnswer++;
            }

            else{

                resultTextView.setText("FALSE");
                numOfFalseAnswer++;

            }

        }

        catch (IllegalArgumentException iae) {

            UserSolutionEditText.setError("Enter a Number !");        }

        displayResult();
    }

}
