import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 	JPanel correspondant a une ligne de ressource
 * 	@author Hugo SIMON
 *	@version 1.0
 */

public class Prix extends JPanel {
	
	/**
	 *  Prix unitaire de la ressource
	 */
	
	protected JTextField prixu;
	
	/**
	 * 	Quantitee necessaire
	 */
	
	protected JTextField quantite;
	
	/**
	 * 	Constructeur permettant de setup la ligne
	 */
	
	public Prix() {
		this.prixu = new JTextField(12);
		this.quantite = new JTextField(8);
		this.add(prixu);
		this.add(quantite);
	}

}
