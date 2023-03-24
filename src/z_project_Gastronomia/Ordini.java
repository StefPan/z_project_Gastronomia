package z_project_Gastronomia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ordini {
	private String nome;
	private int quantita;
	private PaninoComposite panino;

	Scanner scanner = new Scanner(System.in);

	public Ordini() {
	}

	public Ordini(String nome, int quantita) {
		this.nome = nome;
		this.quantita = quantita;
		panino = null;
	}

	// CREA CLASSE PaninoComposite list<Panino> e assegno ordineParz=
	// add(PaninoComposite, quantità
	public Ordini(PaninoComposite panino, int quantita) {
		this.panino = panino;
		this.quantita = quantita;
		nome = null;
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

		return ("-) " + nome + " quantità: " + quantita + "\n");
	}

	public void faiOrdine() {

		ArrayList<Ordini> ordine = new ArrayList<>();
		PaninoComposite ingrd = new PaninoComposite();
		Ordini ordineParz = new Ordini();
		Ordini ordinePanino;
		String answer;
		// checkInput FA CONTROLLO SULLASTRINGA INSERITA, Methods from Ordini
		System.out.println("Vuoi fare un nuovo ordine? si/no ");
		answer = scanner.nextLine().trim();
		answer = checkInput(answer, "si", "yes", "no");

		if (answer.equalsIgnoreCase("no")) {
			System.out.println("Grazie per essere passato di qua..\nA presto!");
		}
		if (answer.equalsIgnoreCase("si") || answer.equalsIgnoreCase("yes")) {
			while (true) {
				System.out.println("Cosa vuole ordinare: Carne, Insalata, Primo o Panino?");
				String tipo = scanner.nextLine();
				tipo = checkInput(tipo, "carne", "insalata", "primo", "panino");
				if (tipo.equalsIgnoreCase("Carne")) {
					System.out.println("Che tipo di " + tipo + " desidera? RoastBeef, Pollo grigliato o Tacchino? ");
					nome = scanner.nextLine().trim();
					nome = checkInput(nome, "roastbeef", "pollo grigliato", "Tacchino arrosto");
					if (nome.equals("")) {
						break;
					}
				} else if (tipo.equalsIgnoreCase("Insalata")) {
					System.out.println("Che tipo di " + tipo + " desidera? Mista o Verde? ");
					nome = scanner.nextLine().trim();
					nome = checkInput(nome, "Mista", "Tonno", "Mediterranea");
					if (nome.equals("")) {
						break;
					}
				} else if (tipo.equalsIgnoreCase("Primo")) {
					System.out.println("Che tipo di " + tipo + " desidera? Penne al ragù o penne al pesto? ");
					nome = scanner.nextLine().trim();
					nome = checkInput(nome, "Penne al ragù", "Penne al pesto", "Lasagne");
					if (nome.equals("")) {
						break;
					}
				} else if (tipo.equalsIgnoreCase("Panino")) {
					nome = tipo;
					String ingrediente;

					System.out.println("Inserisca il primo ingrediente ? ");
					ingrediente = scanner.nextLine().trim();
					ingrd.addIngredienti(ingrediente);

					while (ingrediente != "") {
						System.out.println("Inserisca un'altro ingrediente o prema invio ? ");
						ingrediente = scanner.nextLine();
						ingrd.addIngredienti(ingrediente);
					}
//					System.out.println("Panino con: " + ingrd);
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
				if (nome.equalsIgnoreCase("panino")) {
					ordinePanino = new Ordini(ingrd.getIngrediente(), quantita);
					ordine.add(ordinePanino);
				} else {
					ordineParz = new Ordini(nome, quantita);
					ordine.add(ordineParz);
				}

				System.out.println("Desideri altro? si/no ");

				do {
					answer = scanner.nextLine().trim();

					if (answer.equalsIgnoreCase("no")) {
						break;
					}
					if (!answer.equalsIgnoreCase("si") && !answer.equalsIgnoreCase("yes")
							&& !answer.equalsIgnoreCase("no")) {
						System.out.println("Hai inserito una risposta non valida, riprova: ");
					}
				} while (!answer.equalsIgnoreCase("si") && !answer.equalsIgnoreCase("yes"));
				if (answer.equalsIgnoreCase("no")) {
					break;
				}
			}

			// SE ORDINE PRESENTE STAMPA CONTENUTO
			if (!ordine.isEmpty()) {
				System.out.println("Il tuo ordine:\n");
				for (int i = 0; i < ordine.size(); i++) {
					System.out.println(ordine.get(i));
				}
				// SE HO PANINO STAMPA INGREDIENTI PANINO
				if (!ingrd.getListaIngredienti().isEmpty()) {
					System.out.println("Ingedienti del panino: ");
					for (String ingred : ingrd.getListaIngredienti()) {
						System.out.print(" " + ingred);
					}
				}
				System.out.print("Desideri la consegna a domicilio?");
				answer=scanner.nextLine();
				answer=checkInput(answer, "si", "no");
				if(answer.equalsIgnoreCase("no")){
					System.out.print("Ok.\nIl tuo ordine sarà pronto tra " + time + " minuti");
					//dichiara time che lo calcolereai in cucina, nella gestione ordini totali
					//metti il caso sì che fa controllo da database se indirizzo corretto.
				}
			}
		}
	}

	/*
	 * controllo risposta del cliente fino a che non è si/no o tra quelle
	 * predefinite o esce dal programma
	 */
	public String checkInput(String input, String nome1, String nome2, String nome3, String nome4) {
		do {
			if (!input.equalsIgnoreCase(nome1) && !input.equalsIgnoreCase(nome2) && !input.equalsIgnoreCase(nome3)
					&& !input.equalsIgnoreCase(nome4)) {
				System.out.println("Per favore dai una risposta corretta o premi invio per uscire.\n" + " " + nome1
						+ ", " + nome2 + ", " + nome3 + " o " + nome4 + " ? ");
				input = scanner.nextLine();
				if (input.equals("")) {
					System.out.println("Hai scelto di uscire dall'applicazione. Alla prossima.");
					break;
				}
			}

		} while ((!input.equalsIgnoreCase(nome1) && !input.equalsIgnoreCase(nome2) && !input.equalsIgnoreCase(nome3)
				&& !input.equalsIgnoreCase(nome4)));

		return input;
	}

	public String checkInput(String input, String nome1, String nome2, String nome3) {
		do {
			if (!input.equalsIgnoreCase(nome1) && !input.equalsIgnoreCase(nome2) && !input.equalsIgnoreCase(nome3)) {
				System.out.println("Per favore dai una risposta corretta o premi invio per uscire.\n" + " " + nome1
						+ ", " + nome2 + " o  " + nome3 + " ? ");
				input = scanner.nextLine();
				if (input.equals("")) {
					System.out.println("Hai scelto di uscire dall'applicazione. Alla prossima.");
					break;
				}
			}

		} while ((!input.equalsIgnoreCase(nome1) && !input.equalsIgnoreCase(nome2) && !input.equalsIgnoreCase(nome3)));
		return input;
	}

	public String checkInput(String input, String nome1, String nome2) {
		do {
			if (!input.equalsIgnoreCase(nome1) && !input.equalsIgnoreCase(nome2)) {
				System.out.println("Per favore dai una risposta corretta o premi invio per uscire.\n" + " " + nome1
						+ "/" + nome2 + " ?");
				input = scanner.nextLine();
				if (input.equals("")) {
					System.out.println("Hai scelto di uscire dall'applicazione. Alla prossima.");
					break;
				}
			}

		} while ((!input.equalsIgnoreCase(nome1) && !input.equalsIgnoreCase(nome2)));

		return input;
	}

}