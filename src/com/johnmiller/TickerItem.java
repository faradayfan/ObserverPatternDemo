package com.johnmiller;

public class TickerItem {
    private String company;
    private String tickerSymbol;
    private double currentPrice;
    private double dollarChange;
    private double percentChange;
    private double ytdPercentChange;
    private double fiftyTwoWeekHigh;
    private double fiftyTwoWeekLow;
    private double pToERatio;

    public TickerItem(String company,
                      String tickerSymbol,
                      double currentPrice,
                      double dollarChange,
                      double percentChange,
                      double ytdPercentChange,
                      double fiftyTwoWeekHigh,
                      double fiftyTwoWeekLow,
                      double pToERatio) {
        this.company = company;
        this.tickerSymbol = tickerSymbol;
        this.currentPrice = currentPrice;
        this.dollarChange = dollarChange;
        this.percentChange = percentChange;
        this.ytdPercentChange = ytdPercentChange;
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
        this.pToERatio = pToERatio;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getDollarChange() {
        return dollarChange;
    }

    public void setDollarChange(double dollarChange) {
        this.dollarChange = dollarChange;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    public double getYtdPercentChange() {
        return ytdPercentChange;
    }

    public void setYtdPercentChange(double ytdPercentChange) {
        this.ytdPercentChange = ytdPercentChange;
    }

    public double getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public void setFiftyTwoWeekHigh(double fiftyTwoWeekHigh) {
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
    }

    public double getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public void setFiftyTwoWeekLow(double fiftyTwoWeekLow) {
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
    }

    public double getpToERatio() {
        return pToERatio;
    }

    public void setpToERatio(double pToERatio) {
        this.pToERatio = pToERatio;
    }

    @Override
    public String toString() {
        return this.getCompany() + " " +
                this.getTickerSymbol()  + " " +
                this.getCurrentPrice()  + " " +
                this.getDollarChange()  + " " +
                this.getPercentChange()  + " " +
                this.getYtdPercentChange()  + " " +
                this.getFiftyTwoWeekHigh()  + " " +
                this.getFiftyTwoWeekLow()  + " " +
                this.getpToERatio();
    }
}
