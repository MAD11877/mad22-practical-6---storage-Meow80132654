package com.example.week3practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week3practical.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivingEnd = getIntent();
        User newUser = (User) receivingEnd.getSerializableExtra("user");


        Button MessageButton = findViewById(R.id.MessageButton);
        Button FollowButton = findViewById(R.id.FollowButton);

        TextView NameView = findViewById(R.id.nameView);
        TextView DescView = findViewById(R.id.descView);

        MessageButton.setText("Message");
        if (newUser.isFollowed() == true){
            FollowButton.setText("Unfollow");
        }
        else {
            FollowButton.setText("Follow");
        }
        DbHandler dbquerymachine = new DbHandler(this, null, null, 1);

        NameView.setText(newUser.getName());
        DescView.setText(newUser.getDesc());

        FollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (newUser.isFollowed()== true){
                    newUser.setFollowed(false);
                    dbquerymachine.updateUser(newUser);

                    FollowButton.setText("Follow");
                    Toast.makeText(MainActivity.this,"UnFollowed user!", Toast.LENGTH_SHORT).show();
                }
                else{
                    newUser.setFollowed(true);
                    dbquerymachine.updateUser(newUser);
                    FollowButton.setText("UnFollow");
                    Toast.makeText(MainActivity.this,"Followed user!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        MessageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent myIntent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(myIntent);
            }


        });




    }
}