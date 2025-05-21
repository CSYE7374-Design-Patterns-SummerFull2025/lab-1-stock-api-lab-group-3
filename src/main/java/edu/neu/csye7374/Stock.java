package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class Stock {

	private String ID;

	private String description;
	protected double price;

	int metric;

	List<Double> bids;

	public Stock() {
		this.ID = "";
		this.price = 0;
		this.description = "";
		this.bids = new ArrayList<>();
		this.bids.add(price);
		this.metric = 0;
	}

	public Stock(String ID, double price, String description) {
		this.ID = ID;
		this.price = price;
		this.description = description;
		this.bids = new ArrayList<>();
		this.bids.add(price);
		this.metric = 0;
	}
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public void calculatePrice() {
		double avg = 0;
		for(double p : bids) {
			avg+= p;
		}
		avg = avg/bids.size();
		if(avg > this.price ) {
			setMetric(this.metric +1);
		}else if(avg < this.price) {
			setMetric(this.metric -1);
		}
		setPrice(avg);
	}

	public List<Double> getBid(){
		return this.bids;
	}



	public void setMetric(int metric) {
		this.metric = metric;
	}

	@Override
    public String toString() {
        return "Stock{" +
                "name='" + ID + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +

                '}';
    }

	public void setDescription(String desc) {
		this.description = desc;
	}
}
