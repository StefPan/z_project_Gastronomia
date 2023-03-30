package db.gastronomia;


/*	

	@Entity
	@Table(name = "food")
	public class FoodJPA implement JpaEntity {
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

		
		
		
		public int getId() {
			return id;
		}

		
		public void addArticle(ArticleEntity articleEntity) {
			if(articleEntity.getAuthors() == null) {
			articleEntity.setAuthors(new HashSet<>());
			}
			if(this.articles == null) {
			this.articles = new HashSet<>();
			}
			articleEntity.getAuthors().add(this);
			this.articles.add(articleEntity);
			}
			public void removeArticle(ArticleEntity articleEntity) {
			this.articles.remove(articleEntity);
			articleEntity.getAuthors().remove(this);
			}
		public void addFood(FoodJpa foodJpa) {
			foodJpa.setUserEntity(this);
			if (this.cars == null) {
				this.cars = new HashSet<>();
			}
			this.cars.add(carEntity);
		}
		
		@Override
		public int hashCode() {
			return super.hashCode();
		}


		@Override
		public boolean equals(Object obj) {
				return super.equals(obj);
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
*/