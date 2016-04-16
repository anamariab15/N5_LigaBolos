package uniandes.cupi2.ligaBolos.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOpciones  extends JPanel implements ActionListener
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	/**
	 * Constante que representa el comando Buscar mejor promedio.
	 */
	private static final String BUSCAR_MEJOR_PROMEDIO = "Buscar mejor promedio";
	/**
	 * Constante que representa el comando Buscar por nombre.
	 */

	private static final String BUSCAR_POR_NOMBRE = "Buscar por nombre";
	/**
	 * Constante que representa el comando opción 1.
	 */
	private static final String OPCION_1 = "Opción 1";

	/**
	 * Constante que representa el comando opción 2.
	 */
	private static final String OPCION_2 = "Opción 2";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Asociacion con la ventana principal del interfaz.
	 */
	private InterfazLigaBolos principal;



	// -----------------------------------------------------------------
	// Atributos de interfaz
	// -----------------------------------------------------------------


	/**
	 * Botón para buscar la cantidad de equipos con patrocinador.
	 */
	private JButton btnBuscarpornombre;

	/**
	 * Botón para buscar el jugador con mejor promedio.
	 */
	private JButton btnBuscarmejorpromedio;

	/**
	 * Botón para buscar el equipo con el mayor promedio de estatura.
	 */
	private JButton btnOpcion1;

	/**
	 * Botón para buscar dos equipos con la misma cantidad de aficionados.
	 */
	private JButton btnOpcion2;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del panel
	 * @param ventana Ventana principal
	 */
	public PanelOpciones( InterfazLigaBolos ventana )
	{
		principal = ventana;

		setBorder( new TitledBorder( "Opciones" ) );

		JPanel panel1 = new JPanel( );
		add(panel1);

		panel1.setLayout( new GridLayout( 1, 4 ) );


		btnBuscarpornombre = new JButton( "Buscar por nombre" );
		btnBuscarpornombre.setActionCommand( BUSCAR_POR_NOMBRE);
		btnBuscarpornombre.addActionListener( this );
		panel1.add( btnBuscarpornombre );

		btnBuscarmejorpromedio = new JButton( "Burcar mejor promedio");
		btnBuscarmejorpromedio.setActionCommand(BUSCAR_MEJOR_PROMEDIO);
		btnBuscarmejorpromedio.addActionListener(this);
		panel1.add(btnBuscarmejorpromedio);

		btnOpcion1 = new JButton( "Opción 1" );
		btnOpcion1.setActionCommand( OPCION_1 );
		btnOpcion1.addActionListener( this );
		panel1.add( btnOpcion1 );

		btnOpcion2 = new JButton( "Opción 2" );
		btnOpcion2.setActionCommand( OPCION_2 );
		btnOpcion2.addActionListener( this );
		panel1.add( btnOpcion2 );



	}

	@Override
	/**
	 * Action Performed para botones.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando= e.getActionCommand();
		if (comando.equals(BUSCAR_MEJOR_PROMEDIO))
		{
			principal.buscarmejorpromedio();
		}
		else if( comando.equals(BUSCAR_POR_NOMBRE))
		{
			principal.buscarpornombre();
		}

		else if( comando.equals(OPCION_1))
		{
			principal.reqFuncional1();
		}

		else if( comando.equals(OPCION_2))
		{
			principal.reqFuncional2();
		}
	}


}

