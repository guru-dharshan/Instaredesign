package com.example.instaredesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView storyrecycle;
    RecyclerView postrecycle;
    public static List<String> storylist ;
    public static List<String> postlist ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storyrecycle=findViewById(R.id.storyrecycle);
        postrecycle=findViewById(R.id.postrecycle);
        storylist=new ArrayList<>();
        postlist=new ArrayList<>();
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

        RecyclerAdapter postadapter = new RecyclerAdapter(postlist,MainActivity.this);
        postrecycle.setAdapter(postadapter);
        LinearLayoutManager ver
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        postrecycle.setLayoutManager(ver);

    }
}