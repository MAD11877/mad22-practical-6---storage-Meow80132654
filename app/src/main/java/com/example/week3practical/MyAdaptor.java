package com.example.week3practical;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class MyAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<User> userList;
    Context context;

    public MyAdaptor(Context ct, List<User> users){
        context = ct;
        userList = users;
    };

    @Override
    public int getItemViewType(int position){
        String name = userList.get(position).name;
        char lastChar= name.charAt(name.length()-1);
        if ( lastChar == '7'){
            return 1;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view;
        if (viewType==1){
            view = inflater.inflate(R.layout.rowend7, parent, false);
            return new MyViewHolderEnd7(view);
        }

        view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        int viewType = getItemViewType(position);
        if (viewType == 1){
            MyViewHolderEnd7 ViewHolderEnd7 = (MyViewHolderEnd7) holder;
            ViewHolderEnd7.nameView.setText(userList.get(position).name);
            ViewHolderEnd7.descView.setText(userList.get(position).description);
            ViewHolderEnd7.imageView.setImageResource(R.drawable.ic_launcher_background);
            ViewHolderEnd7.imageViewEnd7.setImageResource(R.drawable.ic_launcher_background);
            ViewHolderEnd7.imageViewEnd7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("This is an AlertDialog");
                    builder.setMessage("Please choose an option below");
                    builder.setCancelable( false );
                    builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(context, MainActivity.class);
                            User user = userList.get(position);
                            intent.putExtra("user",  user);
                            context.startActivity(intent);
                        }
                    }).setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                }
            });
        }
        else {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.nameView.setText(userList.get(position).name);
            viewHolder.descView.setText(userList.get(position).description);
            viewHolder.imageView.setImageResource(R.drawable.ic_launcher_background);
            viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Profile");
                    builder.setMessage(userList.get(position).name);
                    builder.setCancelable( false );
                    builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(context, MainActivity.class);
                            User user = userList.get(position);
                            intent.putExtra("user",  user);
                            context.startActivity(intent);
                        }
                    }).setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                }
            });



        }
    }

    @Override
    public int getItemCount() {
       return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameView, descView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.nameView);
            descView = itemView.findViewById(R.id.descView);
            imageView = itemView.findViewById(R.id.imageView3);
        }
    }
    public class MyViewHolderEnd7 extends RecyclerView.ViewHolder{

        TextView nameView, descView;
        ImageView imageView;
        ImageView imageViewEnd7;
        public MyViewHolderEnd7(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.nameView2);
            descView = itemView.findViewById(R.id.descView2);
            imageViewEnd7 = itemView.findViewById(R.id.imageView7);
            imageView = itemView.findViewById(R.id.imageView6);
        }
    }

}
