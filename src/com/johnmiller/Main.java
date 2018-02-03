package com.johnmiller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("---- Local Stocks ----");
        Ticker t = new Ticker();

        try {
            PrintWriter avgOut = new PrintWriter("Average.dat");
            PrintWriter change10Out = new PrintWriter("Change10.dat");
            PrintWriter selectionOut = new PrintWriter("Selection.dat");

            LocalStocks l = new LocalStocks(avgOut, change10Out, selectionOut);

            t.register(l);

            t.readAndUpdate();

            avgOut.close();
            change10Out.close();
            selectionOut.close();

        } catch (FileNotFoundException e) {

        }





    }
}
