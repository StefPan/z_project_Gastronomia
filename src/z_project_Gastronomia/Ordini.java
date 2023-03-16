package z_project_Gastronomia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ordini {
	private String nome;
	private int quantita;

	Scanner scanner = new Scanner(System.in);

	public Ordini() {
	}

	public Ordini(String nome, int quantita) {
		this.nome = nome;
		this.quantita = quantita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "Prodotto: " + nome + " quantità: " + quantita + "\n";
	}

	public void faiOrdine() {
		ArrayList<Ordini> ordine = new ArrayList<>();
		List<String> listaPanino = new ArrayList<>();
		Ordini ordineParz;
		String answer;
		System.out.println("Vuoi fare un nuovo ordine? si/no ");
		do {
			answer = scanner.nextLine().trim();
			if (!answer.equalsIgnoreCase("si") && !answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
				System.out
						.println("Hai inserito un comando non corretto, Riprova.\n\nVuoi fare un nuovo ordine? si/no ");
				answer = scanner.nextLine().trim();
			}
		} while (!answer.equalsIgnoreCase("si") && !answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));

		if (answer.equalsIgnoreCase("no")) {
			System.out.println("Grazie per essere passato di qua..\nA presto!");
		}
		if (answer.equalsIgnoreCase("si") || answer.equalsIgnoreCase("yes")) {
			while (true) {
				System.out.println("Cosa vuole ordinare: Carne, Insalata, Primo o Panino?");
				String tipo = scanner.nextLine();
				if (tipo.equalsIgnoreCase("Carne")) {
					System.out.println("Che tipo di " + tipo + " desidera? RoastBeef, Pollo grigliato o Tacchino? ");
					nome = scanner.nextLine().trim();
				} else if (tipo.equalsIgnoreCase("Insalata")) {
					System.out.println("Che tipo di " + tipo + " desidera? Mista o Verde? ");
					nome = scanner.nextLine().trim();
				} else if (tipo.equalsIgnoreCase("Primo")) {
					System.out.println("Che tipo di " + tipo + " desidera? Penne al ragù o penne al pesto? ");
					nome = scanner.nextLine().trim();
				} else if (tipo.equalsIgnoreCase("Panino")) {
					nome = tipo;
					String ingrediente;

					System.out.println("Inserisca il primo ingrediente ? ");
					ingrediente = scanner.nextLine().trim();

					listaPanino.add(ingrediente);

					while (ingrediente != "") {
						System.out.println("Inserisca un'altro ingrediente o prema invio ? ");
						ingrediente = scanner.nextLine();
						listaPanino.add(ingrediente);
					}
					System.out.println(listaPanino);
				}

				else {
					System.out.println("Hai inserito una risposta non valida, riprova: ");
					do {
						tipo = scanner.nextLine();

						if (!tipo.equalsIgnoreCase("carne") && !tipo.equalsIgnoreCase("insalata")
								&& !tipo.equalsIgnoreCase("primo") && !tipo.equalsIgnoreCase("panino")) {
							System.out.println("Hai inserito una risposta non valida, riprova: ");
						}
					} while (!tipo.equalsIgnoreCase("carne") && !tipo.equalsIgnoreCase("insalata")
							&& !tipo.equalsIgnoreCase("primo") && !tipo.equalsIgnoreCase("panino"));

				}

				System.out.println("Quante porzioni desidera? Indicare un numero da 1 a 10 ");
				int quantita = scanner.nextInt();
				scanner.nextLine();
				ordineParz = new Ordini(nome, quantita);
				ordine.add(ordineParz);
				System.out.println("Desideri altro? si/no ");

				do {
					answer = scanner.nextLine().trim();

					if (answer.equalsIgnoreCase("no")) {
						break;
					}
					if (!answer.equalsIgnoreCase("si") && !answer.equalsIgnoreCase("yes")&& !answer.equalsIgnoreCase("no")) {
						System.out.println("Hai inserito una risposta non valida, riprova: ");
					}
				} while (!answer.equalsIgnoreCase("si") && !answer.equalsIgnoreCase("yes"));
				if (answer.equalsIgnoreCase("no")) {
					break;
				}
			}

		}
		System.out.println("Il tuo ordine:\n");
		for (int i = 0; i < ordine.size(); i++) {
			System.out.println(ordine.get(i));
		}
		return;
	}

}