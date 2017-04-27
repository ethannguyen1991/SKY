package com.example.vannguyen.binarytree;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by VanNguyen on 4/20/17.
 */

public class BinaryTree
{
    private BinaryTree prevTree;
    private BinaryTree nextTree;
    public boolean isSet;
    private int payload;
    private char position;
    private int depth;
    private ViewGroup theTreeView;
    private Context context;
    private BinaryTree leftTree;
    private BinaryTree rightTree;
    private BinaryTree parent;
    private String direction;
    private int balanceFactor;

    public BinaryTree(ViewGroup theTreeView, Context context)
    {
        this.nextTree = null;
        this.prevTree = null;
        this.theTreeView = theTreeView;
        this.isSet = false;
        this.depth = 0;
        this.position = 'M';
        this.leftTree = null;
        this.rightTree = null;
        this.context = context;
        this.parent = null;
        this.direction = "";
        this.balanceFactor = 0;
    }

    public BinaryTree(int payload, int depth, char position, ViewGroup theTreeView, Context context)
    {
        this(theTreeView, context);
        this.payload = payload;
        this.depth = depth;
        this.position = position;
        this.isSet = true;
    }


    public void binaryTreeRecurrsive (int i)
    {
        BinaryTree b = new BinaryTree();
        b.setPayload(i);
        if (this.getPayload() == -1)
        {
            this.setPayload(i);
        }
        else if (this.getPayload() <= i)
        {
            if (this.rightTree == null)
            {
                b.setParent(this);
                b.setDirection("On the Right");
                this.setRightTree(b);
            }
            else this.rightTree.binaryTreeRecurrsive(i);
        }
        else if (this.getPayload() >= i)
        {
            if (this.leftTree == null)
            {
                b.setParent(this);
                b.setDirection("On the left");
                this.setLeftTree(b);
            }
            else this.leftTree.binaryTreeRecurrsive(i);
        }
    }
    public int depthCheck()
    {
        int leftDepth = 0;
        int rightDepth = 0;
        if (this.getRightTree() != null)
        {
            rightDepth = 1 + this.getRightTree().depthCheck();
        }
        if (this.getLeftTree() != null)
        {
            rightDepth = 1 + this.getLeftTree().depthCheck();
        }
        if (rightDepth > leftDepth)
        {
            return rightDepth;
        }
        else
        {
            return leftDepth;
        }
    }
    public int getBalanceFactor()
    {
        int leftDepth = 0;
        int rightDepth = 0;
        if (this.leftTree != null)
        {
            leftDepth = 1 + this.leftTree.depthCheck();
        }
        if (this.rightTree != null)
        {
            rightDepth = 1 + this.rightTree.depthCheck();
        }
        this.balanceFactor = rightDepth - leftDepth;
        return this.balanceFactor;
    }
    public boolean isOutOfBalance()
    {
        int leftDepth = 0;
        int rightDepth = 0;
        if(this.leftTree != null)
        {
            leftDepth = this.leftTree.getDepth();
        }
        if(this.rightTree != null)
        {
            rightDepth = this.rightTree.getDepth();
        }

        int difference = Math.abs(leftDepth - rightDepth);
        return difference > 1;
    }

    public int getDepth()
    {
        int leftDepth = 0;
        int rightDepth = 0;
        if(this.leftTree != null)
        {
            leftDepth = 1 + this.leftTree.getDepth();
        }
        if(this.rightTree != null)
        {
            rightDepth = 1 + this.rightTree.getDepth();
        }

        if(rightDepth > leftDepth)
        {
            return rightDepth;
        }
        else
        {
            return leftDepth;
        }
    }

    public void visitInOrder()
    {
        if(this.leftTree != null)
        {
            this.leftTree.visitInOrder();
        }
        Core.theQ.addLast("" + this.payload);
        if(this.rightTree != null)
        {
            this.rightTree.visitInOrder();
        }
    }

    private void addTextViewToTree(String lexJSON)
    {
        TextView tv = new TextView(this.context);
        tv.setText(lexJSON);
        this.theTreeView.addView(tv);
    }

    public boolean add(int payload)
    {
        if(!this.isSet)
        {
            this.payload = payload;
            this.addTextViewToTree(this.toLexicalJSON());
            this.isSet = true;
            return true;
        }
        else
        {
            if(payload <= this.payload)
            {
                //add this payload to the left
                if(this.leftTree == null)
                {
                    this.leftTree = new BinaryTree(payload, this.depth+1, 'L', theTreeView, this.context);
                    this.addTextViewToTree(this.leftTree.toLexicalJSON());
                    return true;
                }
                else
                {
                    //I have a left tree, and I'm going to ask him to
                    //add the payload to himself.
                    return this.leftTree.add(payload);
                }
            }
            else
            {
                //add this payload to the right
                if(this.rightTree == null)
                {
                    this.rightTree = new BinaryTree(payload, this.depth+1, 'R', this.theTreeView, this.context);
                    this.addTextViewToTree(this.rightTree.toLexicalJSON());
                    return true;
                }
                else
                {
                    //I have a right tree, and I'm going to ask him to
                    //add the payload to himself.
                    return this.rightTree.add(payload);
                }
            }
        }
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public BinaryTree getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(BinaryTree leftTree) {
        this.leftTree = leftTree;
    }

    public BinaryTree getRightTree() {
        return rightTree;
    }

    public void setRightTree(BinaryTree rightTree) {
        this.rightTree = rightTree;
    }

    private String toLexicalJSON()
    {
        String json = "{\"depth\":" + this.depth + ", \"position\":\"" + this.position + "\", \"payload\":" + this.payload + "}";
        return json;
    }

    public BinaryTree getParent() {
        return parent;
    }

    public void setParent(BinaryTree parent) {
        this.parent = parent;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void display()
    {
        if(this.isSet)
        {
            System.out.println(this.payload);
            if(this.leftTree != null)
            {
                this.leftTree.display();
            }
            if(this.rightTree != null)
            {
                this.rightTree.display();
            }
        }
        else
        {
            System.out.println("Empty Tree");
        }
    }

    public BinaryTree getPrevTree() {
        return prevTree;
    }

    public void setPrevTree(BinaryTree prevTree) {
        this.prevTree = prevTree;
    }

    public BinaryTree getNextTree() {
        return nextTree;
    }

    public void setNextTree(BinaryTree nextTree) {
        this.nextTree = nextTree;
    }


}
