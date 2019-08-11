package com.example.android.ronihsboni;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mLevelOneButton;
    Button mLevelTwoButton;
    Button mLevelThreeButton;


//    final static String Level_ONE = "Level One";
//    final static String Level_TWO = "Level Two";
//    final static String Level_THREE = "Level Three";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLevelOneButton= findViewById(R.id.level_one_button);
        mLevelTwoButton = findViewById(R.id.level_two_button);
        mLevelThreeButton=findViewById(R.id.level_three_button) ;


        mLevelOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;
                Class destination = LevelActivity.class;

                AbstractGame gameLevelOne = new GameLevelOne();

                Intent intentLevelOne = new Intent(context,destination);

                intentLevelOne.putExtra(Intent.EXTRA_TEXT,gameLevelOne);
                startActivity(intentLevelOne);

            }
        });

        mLevelTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;
                Class destination = LevelActivity.class;

                AbstractGame gameLevelTwo = new GameLevelTwo();

                Intent intentLevelOne = new Intent(context,destination);

                intentLevelOne.putExtra(Intent.EXTRA_TEXT,gameLevelTwo);
                startActivity(intentLevelOne);

            }
        });

//        mLevelThreeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Context context = MainActivity.this;
//                Class destination = LevelActivity.class;
//
//                AbstractGame gameLevelOne = new GameLevelOne();
//
//                Intent intentLevelOne = new Intent(context,destination);
//
//                //  intentLevelOne.putExtra(Level Two,gameLevelOne);
//                startActivity(intentLevelOne);
//
//            }
//        });

    }
}
