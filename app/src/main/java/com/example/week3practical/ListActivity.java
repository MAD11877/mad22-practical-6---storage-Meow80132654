package com.example.week3practical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ListActivity extends AppCompatActivity {

    int num = 20; //Variable to determine how many times name is generated
    List<User> userList = new ArrayList<User>(); //List to store randomly generated users
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        DbHandler dbquerymachine = new DbHandler(this, null, null, 1);

        ArrayList<User> userList;
        userList = dbquerymachine.getUsers();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        /*for(int i = 0; i < num; i++){
            String randInt = Integer.toString(new Random().nextInt(10000000) + 10000000);
            String randInt2 = Integer.toString(new Random().nextInt());
            Boolean randBool3 = new Random().nextBoolean();
            User u = new User("Name" + randInt, "Description "+ randInt2, Integer.parseInt(randInt), randBool3);
            userList.add(u);
        }
        */
        MyAdaptor myAdapter = new MyAdaptor(this, userList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*
        ImageView profileImg = findViewById(R.id.ProfileImage);
        profileImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //alert
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        Random ran = new Random();
                        int randInt = ran.nextInt(999999);
                        Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                        myIntent.putExtra("RandomInt",randInt);
                        startActivity(myIntent);
                    }

                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id){
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
         });
         */

    }
}