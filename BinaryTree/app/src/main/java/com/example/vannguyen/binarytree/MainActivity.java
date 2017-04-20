package com.example.vannguyen.binarytree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText inputET;
    private ViewGroup theTree;
    private BinaryTree bt;
    private TextView TV;
    private BinaryTree leftTree;
    private BinaryTree rightTree;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.inputET = (EditText)this.findViewById(R.id.inputET);
        this.theTree = (ViewGroup)this.findViewById(R.id.theTree);
        this.bt = new BinaryTree(this.theTree, this);
    }
    public void addButtonPressed(View v) {
        this.bt.add(Integer.parseInt(this.inputET.getText().toString()));
    }

    public void inOrderTraverseButtonPressed(View v)
    {
        Core.theQ.clear();
        this.bt.visitInOrder();
        for(String s : Core.theQ)
        {
            System.out.print(s + ",");
        }
        System.out.println("");
    }

    public void getDepthButtonPressed(View v)
    {
        System.out.println("Depth: " + this.bt.getDepth());
    }

    public void balanceButtonPressed(View v)
    {
        int leftDepth = 0;
        int rightDepth = 0;


        if (this.leftTree.getPrevTree() != null)
        {
            leftDepth = this.leftTree.getDepth();
        }
        if (this.rightTree.getNextTree()!= null)
        {
            rightDepth = this.rightTree.getDepth();
        }
        if (rightDepth > leftDepth + 1)
        {
            TV.setText("the right side bigger depth but it's not balance");
        }
        else if (rightDepth + 1 < leftDepth)
        {
            TV.setText("the left side bigger depth but it's not balance");
        }
        else if (rightDepth > leftDepth)
        {
            TV.setText("the right side bigger depth but is balanced");
        }
        else if (rightDepth < leftDepth)
        {
            TV.setText("the left side bigger depth but is balanced");
        }
        else
        {
            TV.setText("balanced");
        }

    }
}
