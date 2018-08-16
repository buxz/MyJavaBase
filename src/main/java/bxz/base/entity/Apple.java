package bxz.base.entity;

/**
 * Created by SQ_BXZ on 2018-08-07.
 */
public class Apple {

	private int price;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Apple{" +
				"price=" + price +
				", name='" + name + '\'' +
				'}';
	}
}
