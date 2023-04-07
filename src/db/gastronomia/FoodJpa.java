package db.gastronomia;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "food")
	public class FoodJpa implements JpaEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name = "food_name")
		private String foodName;
		
		@Column(name="ingredienti")
		private String ingredients;
		
		@Column(name="allergeni")
		private String allergeni;
		
		@Column(name="porzioni")
		private int porzioni;

		
		

		
		@Override
		public int hashCode() {
			return super.hashCode();
		}


		@Override
		public boolean equals(Object obj) {
				return super.equals(obj);
		}

		public int getId() {
			return id;
		}
		public String getFoodName() {
			return foodName;
		}

		public void setFoodName(String foodName) {
			this.foodName = foodName;
		}

		public String getIngredients() {
			return ingredients;
		}

		public void setIngredients(String ingredients) {
			this.ingredients = ingredients;
		}

		public String getAllergeni() {
			return allergeni;
		}

		public void setAllergeni(String allergeni) {
			this.allergeni = allergeni;
		}

		public int getPorzioni() {
			return porzioni;
		}

		public void setPorzioni(int porzioni) {
			this.porzioni = porzioni;
		}
		
		
		
	
	
}
