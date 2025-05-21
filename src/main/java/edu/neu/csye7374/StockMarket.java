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


        System.out.println("\nAll Stocks Available in the Stock Market");
        showAllStocks();

        tradeStocks("Nike", "280");


        System.out.println("\nCurrent status of the Stocks after Bid 1");
        showAllStocks();

        tradeStocks("Nike", "27");


        System.out.println("\nCurrent status of the Stocks after Bid 2");
        showAllStocks();

        tradeStocks("Nike", "26");


        System.out.println("\nCurrent status of the Stocks after Bid 3");
        showAllStocks();

        tradeStocks("Nike", "29");


        System.out.println("\nCurrent status of the Stocks after Bid 4");
        showAllStocks();

        tradeStocks("Nike", "30");


        System.out.println("\nCurrent status of the Stocks after Bid 5");
        showAllStocks();

        tradeStocks("Nike", "29");


        System.out.println("\nCurrent status of the Stocks after Bid 6");
        showAllStocks();

        removeStock("Nike");
        System.out.println("\nStocks available in the stock market after removing Nike Inc Stock");
        showAllStocks();
    }


}
