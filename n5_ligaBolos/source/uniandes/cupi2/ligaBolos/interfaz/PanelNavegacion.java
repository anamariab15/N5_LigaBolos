package uniandes.cupi2.ligaBolos.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelNavegacion  extends JPanel implements ActionListener
{


	private final static String VER_PRIMERO = "Ver primer jugador";

	private final static String VER_ULTIMO = "Ver último jugador";

	private final static String AVANZAR_JUGA = "Siguiente jugador" ;

	private final static String RETROCEDE_JUGA = "Siguiente jugador";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Asociacion con la ventana principal del interfaz.
	 */	

	private InterfazLigaBolos principal;

	/**
	 * Atributo que contiene el boton primer jugador. 
	 */
	private JButton btnverprimero;

	/**
	 * Atributo que contiene el boton retroceder. 
	 */
	private JButton btnretroceder;

	/**
	 * Atributo que contiene el boton avanzar.. 
	 */
	private JButton btnavanzar;

	/**
	 * Atributo que contiene el boton ver ultimo jugador. 
	 */
	private JButton btnverultimo;
	// -----------------------------------------------------------------
		// Constructores
		// -----------------------------------------------------------------
	
	/**
	 * Constructor del panel
	 * @param ventana Ventana principal
	 */
	public PanelNavegacion(InterfazLigaBolos ventana )
	{
		principal = ventana;
		setLayout( new GridLayout (1,4));

		setBorder( new TitledBorder( "Navegación" ) );

		btnverprimero = new JButton ("Ver primer jugador" );
		btnverprimero.setActionCommand(VER_PRIMERO);
		btnverprimero.addActionListener(this);
		add(btnverprimero);

		btnretroceder = new JButton ("<<");
		btnretroceder.setActionCommand(RETROCEDE_JUGA);
		btnretroceder.addActionListener(this);
		add(btnretroceder);

		btnavanzar = new JButton (">>");
		btnavanzar.setActionCommand(AVANZAR_JUGA);
		btnavanzar.addActionListener(this);
		add(btnavanzar);

		btnverultimo = new JButton ("Ver ultimo jugador");
		btnverultimo.setActionCommand(VER_ULTIMO);
		btnverultimo.addActionListener(this);
		add(btnverultimo);
	}
	/**
	 * Action Performed para botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String comando = e.getActionCommand();

		if(comando.equals(VER_PRIMERO))
		{
			principal.verprimero();
		}

		else if(comando.equals(VER_ULTIMO))
		{
			principal.verultimo();
		}

		else if(comando.equals(AVANZAR_JUGA))
		{
			principal.avanzar();
		}

		else if (comando.equals(RETROCEDE_JUGA))
		{
			principal.retroceder();
		}

	}

}
