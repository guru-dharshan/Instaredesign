package com.example.instaredesign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.bumptech.glide.load.engine.Resource;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView storyrecycle;
    RecyclerView postrecycle;
    public static List<String> storylist ;
    public static List<String> postlist ;
    public static List<Integer> linkphoto ;
    CardView dialog;
    ImageView mode;
    Switch aSwitch;
    RadioButton view1,view2;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            linkphoto=new ArrayList<>();
            linkphoto.add(R.drawable.group);
            setTheme(R.style.darktheme);
        }
        else {
            linkphoto=new ArrayList<>();
            linkphoto.add(R.drawable.groupdark);
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch=findViewById(R.id.aswitch);
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            aSwitch.setChecked(true);
        }
        storyrecycle=findViewById(R.id.storyrecycle);
        postrecycle=findViewById(R.id.postrecycle);
        storylist=new ArrayList<>();
        postlist=new ArrayList<>();
        mode=findViewById(R.id.modess);
        dialog=findViewById(R.id.dialogg);
        storylist.add("ic_group_351");
        storylist.add("rectangle1");
        storylist.add("rectangle2");
        storylist.add("rectangle3");
        storylist.add("rectangle4");
        storylist.add("rectangle5");
        storylist.add("rectangle6");
        storylist.add("rectangle7");
        storylist.add("rectangle8");
        storylist.add("rectangle9");
        storylist.add("rectangle10");
        storylist.add("rectangle11");
        group=findViewById(R.id.radiogroup);

        view1=findViewById(R.id.view1);
        view2=findViewById(R.id.view2);


        postlist.add("post3");
        postlist.add("post4");
        postlist.add("post5");
        postlist.add("post6");
        postlist.add("post7");
        postlist.add("post8");
        postlist.add("post9");
        postlist.add("post10");
        postlist.add("post11");
        storyadapter storyadapter = new storyadapter(MainActivity.this, storylist);
        storyrecycle.setAdapter(storyadapter);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        storyrecycle.setLayoutManager(horizontalLayoutManagaer);

        RecyclerAdapter postadapter = new RecyclerAdapter(postlist,MainActivity.this,linkphoto);
        postrecycle.setAdapter(postadapter);
        LinearLayoutManager ver
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        postrecycle.setLayoutManager(ver);


        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setVisibility(View.VISIBLE);
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        view1.setChecked(true);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "View 1", Toast.LENGTH_SHORT).show();
                RecyclerAdapter postadapter = new RecyclerAdapter(postlist,MainActivity.this,linkphoto);
                postrecycle.setAdapter(postadapter);
                LinearLayoutManager ver
                        = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                postrecycle.setLayoutManager(ver);
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "View 2", Toast.LENGTH_SHORT).show();
                postadapter postadapter = new postadapter(MainActivity.this,postlist);
                postrecycle.setAdapter(postadapter);
                LinearLayoutManager ver
                        = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                postrecycle.setLayoutManager(ver);
            }
        });
    }
}