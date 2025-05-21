package edu.neu.csye7374;

import java.util.List;

public class ElectronicArtsStock extends Stock implements Tradable {

    public ElectronicArtsStock() {
        super();
    }

    public ElectronicArtsStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void calculatePrice() {
        double average = 0;
        List<Double> bids = getBid();
        for (double pr : bids) {
            average += pr;
        }
        average = average / bids.size();
        if (average > this.price && getMetric() >= 0) {
            setMetric(getMetric() + 4);
        } else if (average > this.price && getMetric() < 0) {
            setMetric(0);
        } else if (average < this.price && getMetric() <= 0) {
            setMetric(getMetric() - 4);
        } else if (average < this.price && getMetric() > 0) {
            setMetric(0);
        }
        setPrice(average);
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        this.bids.add(bidValue);
        calculatePrice();
    }

    @Override
    public int getMetric() {
        return this.metric;
    }

    public String getMetricValue() {
        if (this.getMetric() < -5) {
            return " Warning: risky stock. ";
        } else if (this.getMetric() >= -5 && this.getMetric() <= 5) {
            return " Caution: Good stock, be careful. ";
        } else {
            return " Highly recommended: Excellent stock! ";
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Metric Value=" + getMetricValue();
    }

}
