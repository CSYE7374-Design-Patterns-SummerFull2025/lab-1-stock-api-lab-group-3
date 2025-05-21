package edu.neu.csye7374;

public class RocheStock extends Stock implements  Tradable {
    public RocheStock() {
        super();
    }

    public RocheStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void calculatePrice() {
        double avgBid = 0;
        for(double p : getBid()) {
            avgBid+= p;
        }
        avgBid = avgBid/getBid().size();
        // If the average bid is higher than the current price, increase the price by 2% of the difference
        if (avgBid > this.price) {
            price += (avgBid - this.price) * 0.02;
            setMetric(getMetric() + 1); // Increment the metric when price increases
        }
        // If the average bid is lower than the current price, decrease the price by 3% of the difference
        else if (avgBid < this.price) {
            price -= (this.price - avgBid) * 0.03;
            setMetric(getMetric() - 1); // Decrease the metric when price decreases
        }
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
        if(this.getMetric() < -3) {
            return " Warning: Not a good stock. ";
        } else if (this.getMetric() >= -3 && this.getMetric() <= 3) {
            return " Caution: Good stock, be careful. ";
        } else {
            return " Highly recommended: Excellent stock! ";
        }
    }

    StringBuilder sb=new StringBuilder(super.toString());

    @Override
    public String toString(){
        return super.toString()+", Metric Value=" + getMetricValue();
    }
}
