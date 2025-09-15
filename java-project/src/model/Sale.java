package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Sale {

	private Integer id;
	private String product;
	private String category;
	private Double unitValue;
	private Integer quantity;
	private LocalDate date;
	private String seller;
	private String region;
	
	public Sale(Integer id, String product, String category, Double unitValue, Integer quantity, LocalDate date,
			String seller, String region) {
		this.id = id;
		this.product = product;
		this.category = category;
		this.unitValue = unitValue;
		this.quantity = quantity;
		this.date = date;
		this.seller = seller;
		this.region = region;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(Double unitValue) {
		this.unitValue = unitValue;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public double totalValue () {
		return unitValue * quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		StringBuilder text = new StringBuilder();
		
		text.append("Venda:\n");
		text.append("id: " + id + "\n");
		text.append("Produto : " + product + "\n");
		text.append("Categoria : " + category + "\n");
		text.append("Valor unitário: R$ " + String.format("%.2f", unitValue) + "\n");
		text.append("Quantidade : " + quantity+ "\n");
		text.append("Valor total: R$ " + String.format("%.2f", totalValue()) + "\n");
		text.append("Data: " + dateFormat.format(date) + "\n");
		text.append("Vendedor: " + seller + "\n");
		text.append("Região : " + region + "\n");
		
		return text.toString();
	}
	
	
}