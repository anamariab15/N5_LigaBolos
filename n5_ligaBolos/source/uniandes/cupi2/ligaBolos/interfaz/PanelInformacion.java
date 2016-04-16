package uniandes.cupi2.ligaBolos.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import uniandes.cupi2.ligaBolos.mundo.Jugador;

/**
 * Panel que contiene la información del jugador.
 * @author Ana María Bello.
 *
 */

public class PanelInformacion extends JPanel implements ActionListener
{

	private final static String AGREGAR_NUEVO_PUNTAJE = "Agregar nuevo puntaje";
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Asociacion con la ventana principal del interfaz.
	 */

	private InterfazLigaBolos principal;

	/**
	 * Atributo que contiene la imagen. 
	 */

	private JLabel lblImagen;

	/**
	 * Atributo que contiene la text nombre equipo. 
	 */

	private JTextField txtnombreequipo;

	/**
	 * Atributo que contiene el textbox nombre jugador. 
	 */

	private JTextField txtnombrejugador;

	/**
	 * Atributo que contiene el textbox partidas jugadas. 
	 */

	private JTextField txtpartidasjugadas;

	/**
	 * Atributo que contiene el textbox promedio puntos. 
	 */

	private JTextField txtpromediopuntos;

	/**
	 * Atributo que contiene el checkbox para señalar si es profesional o no. 
	 */

	private JCheckBox chkprofesional;

	/**
	 * Atributo que contiene el boton para agregar puntaje. 
	 */
	private JButton btnagregarnuevopuntaje;

	/**
	 * Atributo que representa el jugador actual del juego.
	 */
	private Jugador jugadoractual;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Constructor del panel
	 * @param ventana Ventana principal
	 */
	public PanelInformacion(InterfazLigaBolos ventana )
	{
		principal = ventana;

		setLayout(new GridLayout (1,2));

		lblImagen = new JLabel ();
		add(lblImagen);

		JPanel panelaux = new JPanel();
		add(panelaux);
		panelaux.setLayout(new GridLayout (7,2));


		panelaux.add(new JLabel ("Nombre del equipo"));
		txtnombreequipo = new JTextField();
		txtnombreequipo.setEditable(false);
		panelaux.add(txtnombreequipo);

		panelaux.add(new JLabel ("Nombre del jugador"));
		txtnombrejugador = new JTextField();
		txtnombrejugador.setEditable(false);
		panelaux.add(txtnombrejugador);

		panelaux.add(new JLabel ("Partidas jugadas"));
		txtpartidasjugadas = new JTextField();
		txtpartidasjugadas.setEditable(false);
		panelaux.add(txtpartidasjugadas);

		panelaux.add(new JLabel ("Promedio puntos"));
		txtpromediopuntos = new JTextField();
		txtpromediopuntos.setEditable(false);
		panelaux.add(txtpromediopuntos);

		panelaux.add( new JLabel ("¿Es profesional?"));
		chkprofesional = new JCheckBox();
		panelaux.add(chkprofesional);

		panelaux.add( new JLabel (""));   
		panelaux.add( new JLabel (""));   
		panelaux.add( new JLabel (""));   

		btnagregarnuevopuntaje = new JButton ("Agregar Nuevo Puntaje"); 
		btnagregarnuevopuntaje.setActionCommand(AGREGAR_NUEVO_PUNTAJE);
		btnagregarnuevopuntaje.addActionListener(this);
		panelaux.add (btnagregarnuevopuntaje );




	}

	public void actualizar(Jugador pJugador)
	{
		jugadoractual = pJugador;
		lblImagen.setIcon( new ImageIcon( pJugador.darRutaImagen()));
		txtnombreequipo.setText(pJugador.darNombreEquipo());
		txtnombrejugador.setText(pJugador.darNombreJugador());
		txtpartidasjugadas.setText(String.valueOf(pJugador.darCantidadPartidasJugadas()));
		txtpromediopuntos.setText(String.valueOf(pJugador.darPromedioPuntos()));
		chkprofesional.setEnabled(pJugador.esProfesional());

	}
	/**
	 * Action Performed para botones.
	 */

	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		if( comando.equals(AGREGAR_NUEVO_PUNTAJE))
		{
			String vingresado = JOptionPane.showInputDialog(this, "Puntaje agregar", "Agregar nuevo puntaje", JOptionPane.NO_OPTION);
			if( vingresado!= null)
			{

				if( ! vingresado.trim().isEmpty())
				{

					try
					{
						int puntaje = Integer.parseInt(vingresado);

						if( puntaje <= 0)
						{
							JOptionPane.showMessageDialog(this, "Debe ingresar un valor númerico mayor a cero", "Agregar Puntaje", JOptionPane.ERROR_MESSAGE);
						}

						else 
						{
							jugadoractual.agregarNuevoPuntaje(puntaje);
							actualizar(jugadoractual);
						}

					}

					catch (Exception f)
					{
						JOptionPane.showMessageDialog(this, "Debe ingresar un valor númerico ", "Agregar puntaje", JOptionPane.ERROR_MESSAGE);
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(this, "Debe ingresar el puntaje que desea agregar al jugador.", "Agregar nuevo puntaje", JOptionPane.ERROR_MESSAGE);
				}
			}

		}

	}


}
