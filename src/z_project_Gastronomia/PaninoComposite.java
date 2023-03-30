package z_project_Gastronomia;

import java.util.ArrayList;
import java.util.List;

public class PaninoComposite {

	private String ingredient;
	private List<String> ingredientsList;
	
	public PaninoComposite() {
		this.ingredient = "panino";
		ingredientsList = new ArrayList<>();
	}
	
	
	public String getIngrediente() {
		return ingredient;
	}


	public void setIngrediente(String ingrediente) {
		this.ingredient = ingrediente;
	}


	public void addIngredienti(String ingrediente) {
		ingredientsList.add(ingrediente);
	}
	
	
	public List<String> getIngredientsList() {
		return ingredientsList;
	}
	
	public String toString() {
		return ingredient + "; ";
	}
}
