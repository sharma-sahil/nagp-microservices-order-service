package com.nagarro.microservices.orderservice.proxy;

public class ProductBean {

	/** The product id. */
	private int productId;

	/** The product name. */
	private String productName;

	/** The unit cost. */
	private Double unitCost;

	/** The category. */
	private String category;

	/** The port. */
	private int port;

	/**
	 * Instantiates a new product.
	 */
	public ProductBean() {
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param productId
	 *            the product id
	 * @param productName
	 *            the product name
	 * @param unitCost
	 *            the unit cost
	 * @param category
	 *            the category
	 * @param port
	 *            the port
	 */
	public ProductBean(int productId, String productName, Double unitCost, String category, int port) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitCost = unitCost;
		this.category = category;
		this.port = port;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
