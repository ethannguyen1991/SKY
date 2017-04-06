package com.example.vannguyen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity
{
    private Node binTree;
    private ViewGroup display;
    private EditText input;
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binTree = null;
        display = (ViewGroup)findViewById(R.id.displayLayout);
        input = (EditText)findViewById(R.id.editText);
    }
    public void buttonClicked(View v) {
        int num = Integer.parseInt(input.getText().toString());
        if(binTree == null){
            binTree = new Node(num);
        }else {
            binTree.add(num);
        }
        displayTree(this.binTree);
    }
    private void displayTree(Node tree) {
        display.removeAllViews();
        Queue<Node> currentLevel = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();

        currentLevel.add(tree);
        String text = "";
        while(!currentLevel.isEmpty()) {
            Iterator<Node> iterator = currentLevel.iterator();
            while (iterator.hasNext()) {
                Node currentTree = iterator.next();
                if (currentTree == null) {
                    text += "null  ";
                } else {
                    if (currentTree.getLeftNode() != null) {
                        nextLevel.add(currentTree.getLeftNode());
                    } else {
                        nextLevel.add(null);
                    }
                    if (currentTree.getRightNode() != null) {
                        nextLevel.add(currentTree.getRightNode());
                    } else {
                        nextLevel.add(null);
                    }
                    text += currentTree.getPayload() + "   ";
                }
            }
        }
    }
}
