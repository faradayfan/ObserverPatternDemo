package com.johnmiller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LocalStocks implements IObserver<TickerUpdate>{
    List<String> localInterests;
    PrintWriter avgOut;
    PrintWriter change10Out;
    PrintWriter selectionOut;

    public LocalStocks(PrintWriter avgOut, PrintWriter change10Out, PrintWriter selectionOut) {
        this.localInterests = new ArrayList<>();
        this.localInterests.add("ALL");
        this.localInterests.add("BA");
        this.localInterests.add("BC");
        this.localInterests.add("GBEL");
        this.localInterests.add("KFT")   ;
        this.localInterests.add("MCD");
        this.localInterests.add("TR");
        this.localInterests.add("WAG");
        this.avgOut = avgOut;
        this.change10Out = change10Out;
        this.selectionOut = selectionOut;


    }

    @Override
    public void handleUpdate(TickerUpdate u) {
        this.writeAverage(u);
        this.writePerformingStocks(u);
        this.writeCompaniesOfInterest(u);
    }

    public void writeAverage(TickerUpdate tu){

        this.avgOut.println(tu.getUpdatedString() + " Average Price: " + tu.getAveragePrice());


    }

    public void writePerformingStocks(TickerUpdate tu) {

        this.change10Out.println(tu.getUpdatedString() + ": ");
        tu.getFilterChange(10).forEach(tickerItem -> this.change10Out.println(tickerItem.getTickerSymbol() + " " + tickerItem.getCurrentPrice() + " " + tickerItem.getPercentChange()));

    }

    public void writeCompaniesOfInterest(TickerUpdate tu) {

        this.selectionOut.println(tu.getUpdatedString() + ": ");
        tu.getSelection(this.localInterests).forEach(this.selectionOut::println);

    }
}
