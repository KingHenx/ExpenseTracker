package hh.swd20.ExpTrack.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		public Long id;
	
		public String name;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
		public List<Purchase> purchases;

		public Category() {}
		
		public Category(String name) {
			super();
			this.name = name;
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
		
		
}

