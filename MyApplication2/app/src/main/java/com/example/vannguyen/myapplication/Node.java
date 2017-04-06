package com.example.vannguyen.myapplication;

/**
 * Created by VanNguyen on 4/6/17.
 */

public class Node {
    private int payload;
    private Node leftNode;
    private Node rightNode;

    public Node(int payload) {
        this.payload = payload;
        this.leftNode = null;
        this.rightNode = null;
    }
    public void add(int payload)
    {
        if(payload < this.payload)
        {
            if(leftNode == null)
            {
                this.leftNode = new Node(payload);
            }
            else
            {
                leftNode.add(payload);
            }
        }else if(payload > this.payload)
        {
            if(rightNode == null)
            {
                this.rightNode = new Node(payload);
            }
            else
            {
                rightNode.add(payload);
            }
        }
        else
        {
            this.payload = payload;
        }

    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

}