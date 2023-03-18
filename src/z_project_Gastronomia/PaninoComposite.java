package z_project_Gastronomia;

import java.util.ArrayList;
import java.util.List;

public class PaninoComposite {

	private String ingrediente;
	private List<String> listaIngredienti;
	
	public PaninoComposite() {
		this.ingrediente = "panino";
		listaIngredienti = new ArrayList<>();
	}
	
	
	public String getIngrediente() {
		return ingrediente;
	}


	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}


	public void addIngredienti(String ingrediente) {
		listaIngredienti.add(ingrediente);
	}
	
	public List<String> getListaIngredienti() {
		return listaIngredienti;
	}
	
	public String toString() {
		return ingrediente + "; ";
	}
}
