package hh.swd20.ExpTrack.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	public String name;
	public double price;
	public String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate date;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	public Category category;
	
	
	public Purchase() {}

	public Purchase(String name, double price, String description, LocalDate date, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.date = date;
		this.category = category;
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
