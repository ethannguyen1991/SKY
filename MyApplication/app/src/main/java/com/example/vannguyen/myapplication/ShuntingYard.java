package com.example.vannguyen.myapplication;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by VanNguyen on 3/22/17.
 */

class ShuntingYard
{
    private LinkedList<String> inputQ = new LinkedList<String>();

    public ShuntingYard(String s)
    {
        StringTokenizer st = new StringTokenizer(s, "+-*/^()", true);

    }
}
