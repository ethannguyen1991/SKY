package com.example.vannguyen.myapplication;

/**
 * Created by VanNguyen on 3/28/17.
 */

public class Stack
{
    private Node top;
    private int count;
    public Stack() {
        this.top = null;
        count = 0;
    }
    public void push(Node n)
    {
        if(this.top == null)
        {
            this.top = n;
            this.count++;
        } else {
            n.setNextNode(top);
            this.top = n;
            this.count++;
        }
    }

    public Node pop()
    {
        Node nodeToRemove = this.top;
        if(this.top != null)
        {
            this.top = this.top.getNextNode();
            nodeToRemove.setNextNode(null);
            this.count--;
        }
        return nodeToRemove;
    }

    public Node peek()
    {
        return this.top;
    }

    public int getCount()
    {
        return count;
    }
}
