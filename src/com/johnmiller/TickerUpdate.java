package com.johnmiller;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class TickerUpdate {

    private List<TickerItem> tickerItems;
    private String updatedString;

    public TickerUpdate() {
        this.tickerItems = new ArrayList<>();
    }

    public void addTickerItem(TickerItem t){
        this.tickerItems.add(t);
    }

    public List<TickerItem> getTickerItems(){
        return this.tickerItems;
    }

    public double getAveragePrice(){
        return this.tickerItems
                .stream()
                .mapToDouble(TickerItem::getCurrentPrice)
                .average()
                .getAsDouble();
    }

    public List<TickerItem> getFilterChange(double change){
        return this.tickerItems
                .stream()
                .filter(tickerItem -> Math.abs(tickerItem.getPercentChange()) > change)
                .collect(Collectors.toList());
    }

    public List<TickerItem> getSelection(List<String> interests){
        return this.tickerItems
                .stream()
                .filter(tickerItem -> interests.contains(tickerItem.getTickerSymbol()))
                .collect(Collectors.toList());
    }


    public String getUpdatedString() {
        return updatedString;
    }

    public void setUpdatedString(String updatedString) {
        this.updatedString = updatedString;
    }
}
