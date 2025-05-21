package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private static StockMarket instance;
    private List<Tradable> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(Tradable stock) {
        stocks.add(stock);
    }

    public void showAllStocks() {
        for (Tradable stock : stocks) {
            System.out.println(stock);
        }
    }

    public void tradeStocks(String name, String bid) {
        for (Tradable stock : stocks) {
            if (stock.getID().equals(name))
                stock.setBid(bid);
        }
    }

    public void removeStock(String name) {
        int index = -1;
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getID().equals(name))
                index = i;
        }
        if (index != -1)
            stocks.remove(index);
    }

    public void simulateTrading() {

        System.out.println("---Trading Started---");

        //adding stocks
        this.addStock(new NikeStock("Nike", 25, "Nike Inc"));
        this.addStock(new RivianStock("Rivian", 35, "Rivian Automotive Inc"));
        this.addStock(new LululemonStock("Lululemon", 50, "Lululemon Athletica Inc"));
        this.addStock(new RocheStock("Roche", 43, "Roche Holdings AG"));
        this.addStock(new CRMStock("CRM", 250, "Salesforce Inc"));
        this.addStock(new ElectronicArtsStock("ElectronicArts", 30, "EA Sp Inc"));


        System.out.println("\nAll Stocks Available in the Stock Market");
        showAllStocks();

        tradeStocks("Nike", "28");
        tradeStocks("Rivian", "31");
        tradeStocks("Lululemon", "52");
        tradeStocks("Roche", "43");
        tradeStocks("CRM", "260");
        tradeStocks("ElectronicArts", "38");

        System.out.println("\nCurrent status of the Stocks after Bid 1");
        showAllStocks();

        tradeStocks("Nike", "27");
        tradeStocks("Rivian", "32");
        tradeStocks("Lululemon", "50");
        tradeStocks("Roche", "42");
        tradeStocks("CRM", "240");
        tradeStocks("ElectronicArts", "42");


        System.out.println("\nCurrent status of the Stocks after Bid 2");
        showAllStocks();

        tradeStocks("Nike", "26");
        tradeStocks("Rivian", "34");
        tradeStocks("Lululemon", "55");
        tradeStocks("Roche", "35");
        tradeStocks("CRM", "300");
        tradeStocks("ElectronicArts", "44");


        System.out.println("\nCurrent status of the Stocks after Bid 3");
        showAllStocks();

        tradeStocks("Nike", "29");
        tradeStocks("Rivian", "31");
        tradeStocks("Lululemon", "52");
        tradeStocks("Roche", "38");
        tradeStocks("CRM", "280");
        tradeStocks("ElectronicArts", "38");


        System.out.println("\nCurrent status of the Stocks after Bid 4");
        showAllStocks();

        tradeStocks("Nike", "30");
        tradeStocks("Rivian", "38");
        tradeStocks("Lululemon", "58");
        tradeStocks("Roche", "41");
        tradeStocks("CRM", "220");
        tradeStocks("ElectronicArts", "34");


        System.out.println("\nCurrent status of the Stocks after Bid 5");
        showAllStocks();

        tradeStocks("Nike", "29");
        tradeStocks("Rivian", "39");
        tradeStocks("Lululemon", "65");
        tradeStocks("Roche", "39");
        tradeStocks("CRM", "320");
        tradeStocks("ElectronicArts", "30");


        System.out.println("\nCurrent status of the Stocks after Bid 6");
        showAllStocks();

        removeStock("Nike");
        System.out.println("\nStocks available in the stock market after removing Nike Inc Stock");
        showAllStocks();
    }


}
