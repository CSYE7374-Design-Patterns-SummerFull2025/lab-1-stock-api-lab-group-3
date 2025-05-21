package edu.neu.csye7374;

public class RivianStock extends Stock implements Tradable {

	public RivianStock() {
		super();
	}

	public RivianStock(String name, double price, String description) {
		super(name, price, description);
	}
	
	@Override
	public void calculatePrice() {
		double avg = 0;
		for(double p : getBid()) {
			avg+= p;
		}
		avg = avg/getBid().size();
		if(avg > this.price && getMetric() >= 0) {
			setMetric(getMetric() +2);
		}else if(avg > this.price && getMetric() < 0){
			setMetric(0);
		}else if(avg < this.price && getMetric() <= 0) {
			setMetric(getMetric()-2);
		}else if(avg < this.price && getMetric() > 0) {
			setMetric(0);
		}
		setPrice(avg);
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
