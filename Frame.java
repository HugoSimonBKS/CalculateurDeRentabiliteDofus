import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 	Classe qui contient les elements graphiques de l'application
 * 	@author Hugo SIMON
 * 	@version 1.0
 */

public class Frame extends JFrame{

/**
 * 	Panel contenant le resultat du calcul pour l'affichage sous forme de coeff et de benefice
 */
	
	private JPanel panelRes;
	
/**
 * 	8 panels contenant des zones de texte pour la saisie du prix et de la quantite de chaque ressource necessaire au craft
 */
	public static ArrayList <Prix> panelsPrix;
	
/**
 * 	Panel permettant de saisir le prix de vente de l'item
 */
	
	private JPanel panelVente;
	
/**
 *	Bouton qui lance les calculs 
 */
	
	private JButton calculer;
	
/**
 * 	Panel qui contient toute l'UI pour la re actualiser a chaque calcul
 */
	
	private JPanel container = new JPanel();
	
/**
 * 	Zone de texte permettant de saisir le prix de vente (situe dans panelVente)
 */
	
	private JTextField prixVente;
	
/**
 * 	Zone de texte pour afficher le benef (situe dans panelRes)
 */
	
	private JTextField rentabilite;
	
/**
 * 	Zone de texte pour afficher le coeff de rentabilité de l'item
 */
	
	private JTextField coeff;
	
/**
 * 	Constructeur initialisant la frame et appelant la methode init()
 */
	
	public Frame() {
		this.setTitle("Calculateur rentabilité");
		this.setBounds(200,200,800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Frame.panelsPrix = new ArrayList<Prix>();
        for(int i = 0; i <8; i++) {
        	Frame.panelsPrix.add(new Prix());
        }
        this.init();
	}
	
/**
 * 	Methode qui va initialiser chacun des elements graphiques et appliquer le Layout au Jpanel principal
 */
	
	public void init(){
		this.setLayout(new GridBagLayout());
        this.setFocusable(true);
        this.requestFocus();
		this.calculer = new JButton("calculer");
		this.panelRes = new JPanel();
		this.rentabilite = new JTextField(8);
		this.rentabilite.setEditable(false);
		this.coeff = new JTextField(12);
		this.coeff.setEditable(false);
		this.panelRes.add(rentabilite);
		this.panelRes.add(coeff);
		this.panelVente = new JPanel(new GridBagLayout());
		calculer.addActionListener(new clicListener());
		this.container = saisie();
        this.setContentPane(container);
        this.revalidate();
	}
	
/**
 * 	Methode qui va initialiser les differents panels et les agencer
 * 	@return Retourne le JPanel general
 */
	
	public JPanel saisie() {
		JPanel pano = new JPanel();
		pano.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		// panel de Resultat
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy =1;
		pano.add(panelRes, c);
		
		//panels contenant les labels de chaque TextField
		JPanel labels = new JPanel(new GridBagLayout());
		JLabel jpr = new JLabel("prix");
		JLabel jqt = new JLabel("quantite");
		JLabel jbe = new JLabel("Benefice");
		JLabel jco = new JLabel("Coefficient");
		c.gridy = 0;
		c.gridx = 0;
		c.weightx = 3;
		labels.add(jbe, c);
		c.gridx = 1;
		labels.add(jco, c);
		c.gridx = 2;
		labels.add(jpr, c);
		c.gridx = 3;
		labels.add(jqt, c);
		c.gridx = 0;
		c.gridwidth = 2;
		pano.add(labels, c);
		
		//panelPrix
		c.gridwidth = 1;
		c.weightx = 0;
		c.gridx = 1;
		int i = 1;
		c.ipady = 10;
		for(JPanel j : panelsPrix) {
			c.gridy = i;
			pano.add(j, c);
			i++;
			System.out.println("taist" + i);
		}
		
		//panelVente
		c.gridx = 0;
		c.gridy = 0;
		JLabel jpv = new JLabel("prix de vente");
		this.prixVente = new JTextField(8);
		this.prixVente.setEditable(true);
		this.panelVente.add(prixVente, c);
		c.gridy = 1;
		this.panelVente.add(jpv,c);
		c.gridx = 1;
		c.gridy = 9;
		pano.add(panelVente, c);
		
		//Bouton calculer
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 8;
		c.ipady = 100;
		pano.add(calculer,c);
		return pano;
	}
	
	/**
	 * 	Sous classe pour implementer l'action listener pour le bouton calculer
	 * 	@author Hugo SIMON
	 *	@version 1.0
	 */
	
	public class clicListener implements ActionListener{

	/**
	 * 	Methode appelee lors du clic sur le bouton calculer
	 */
		
	  public void actionPerformed(ActionEvent e)
	  {
			  Calculs.calculer(Integer.parseInt(prixVente.getText()));
			  rentabilite.setText(""+Calculs.rentabilite);
			  coeff.setText(""+ Calculs.coeff);	
	  }
	  
	}
	
}
