package edu.neu.csye7374;

import java.util.List;

public class CRMStock extends Stock implements Tradeable0{


    public CRMStock(String name, double price, String good) {
        super(name, price, good);
    }

    @Override
    public void calculatePrice() {
        double avg = 0;
        List<Double> bids = getBid();
        for (double p : bids) {
            avg += p;
        }
        avg = avg / bids.size();

        setPrice(avg);
    }

     public void setBid(String bid) {
         double bidValue = Double.parseDouble(bid);
         this.bids.add(bidValue);
         calculatePrice();

    }

     public int getMetric() {
         List<Double> bids = getBid();
         if (bids.size() < 3) {
             return 0;
         }

         double previousPrice = bids.get(bids.size() - 2);
         double currentPrice = bids.get(bids.size() - 1);
         double growthRate = ((currentPrice - previousPrice) / previousPrice) * 100;

         double earliestPrice = bids.get(0);
         double longTermTrend = ((currentPrice - earliestPrice) / earliestPrice) * 100;

         int metric = 0;

         if (growthRate > 8) {
             metric += 1;
         } else if (growthRate < -8) {
             metric -= 1;
         }

         if (longTermTrend > 10) {
             metric += 2;
         } else if (longTermTrend < -10) {
             metric -= 2;
         }

         return metric;
    }


    public String getMetricValue() {
        int metric = getMetric();
        if (metric > 2) {
            return " Highly recommended: Excellent stock! ";
        } else if (metric < 0) {
            return " Warning: Not a good stock. ";
        } else {
            return " Caution: Good stock, be careful. ";
        }
    }


    @Override
    public String toString() {
        return super.toString() + ", Metric Value=" + getMetricValue();}


}
