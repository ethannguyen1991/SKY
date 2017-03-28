package com.example.vannguyen.myapplication;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by VanNguyen on 3/22/17.
 */


    public class Queue {
        private Node front;
        private Node end;
        private int count;
        private Stack outputStack;

        public Queue()
        {
            this.front = null;
            this.end = null;
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public void enqueue(String value) //get at the end
        {
            Node n = new Node(value);
            this.count++;
            if (this.end == null) {
                this.front = n;
                this.end = n;
            } else {
                this.end.setNextNode(n);
                this.end = n;
            }
        }

        public Node dequeue() //remove from the front
        {
            Node nodeToReturn = this.front;
            if (this.front != null) {
                this.front = nodeToReturn.getNextNode();
                nodeToReturn.setNextNode(null);
                this.count--;
            }
            return nodeToReturn;
        }

        public boolean hasMoreElements()
        {
            return this.front !=null;
        }
      private boolean operator(String s)
      {
          String ops = "+-*/()^";
          return ops.indexOf(s) != -1;
      }
    private void doMath()
    {
        String op = this.outputStack.pop().getPayload();
        if(this.operator(this.outputStack.peek().getPayload()))
        {
            this.doMath();
        }
        int op2 = Integer.parseInt(this.outputStack.pop().getPayload());

        if(this.operator(this.outputStack.peek().getPayload()))
        {
            this.doMath();
        }
        int op1 = Integer.parseInt(this.outputStack.pop().getPayload());

        if(op.equals("+"))
        {
            this.outputStack.push(new Node("" + (op2 + op1)));
        }
        else if(op.equals("-"))
        {
            this.outputStack.push(new Node("" + (op1 - op2)));
        }
        else if(op.equals("*"))
        {
            this.outputStack.push(new Node("" + (op2 * op1)));
        }
        else if(op.equals("/"))
        {
            this.outputStack.push(new Node("" + (op1 / op2)));
        }
    }
    }
