package z_project_Gastronomia;

public class CiboFactory {

	public Cibo createCibo(CiboType type)  {
		Cibo cibo = null;
	/*	try { */
			
			if(type==CiboType.FRIGO) {
			cibo= new CiboFrigo();
			}
			if (type==CiboType.CUOCERE) {
			cibo= new CiboDaCuocere();
			}
			else
				System.out.println("Questo tipo di cibo non è disponibile.");
			return cibo;
		}
	/*	catch(Exception e) {
			System.out.println("Eccezione generica" + e);
		}
		finally {}
	}  */
}
