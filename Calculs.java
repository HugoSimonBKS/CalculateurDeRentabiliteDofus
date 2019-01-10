/**
 * 	Classe s'occupant des calculs de coefficient et de rentabilite
 * 	@author Hugo SIMON
 *	@version 1.0
 */

public final class Calculs {
	
	/**
	 *	Coefficient de rentabilite de l'item 
	 */
	
	public static float coeff;
	
	/**
	 * 	Nombre de kamas gagnes
	 */
	
	public static int rentabilite;
	
	/**
	 * 	Methode qui va calculer le coeff et la rentabilite de l'item en lisant les textfield correspondants aux prix des ressources
	 * 	@param prixTotal prix de vente de l'item
	 */
	
	public static void calculer(int prixTotal) {
		int coutTot = 0; 
		int quanti = 0;
		int prixunit = 0;
		
		//lecture des prix
		for(Prix j : Frame.panelsPrix) {
			if(!j.prixu.getText().isEmpty()) {
				if(j.quantite.getText().isEmpty())
					quanti = 1;
				else
					quanti = Integer.parseInt(j.quantite.getText());
				prixunit = Integer.parseInt(j.prixu.getText());
					
				coutTot += (prixunit*quanti);
			}
		}
		
		//calcul
		rentabilite = prixTotal - coutTot;
		coeff = ((float)prixTotal / (float)coutTot)*100;
	}
	
}
