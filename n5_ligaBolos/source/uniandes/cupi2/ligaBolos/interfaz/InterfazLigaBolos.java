package uniandes.cupi2.ligaBolos.interfaz;

import java.awt.BorderLayout;
import java.util.Set;

import javax.swing.JFrame;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.ligaBolos.interfaz.PanelImagen;
import uniandes.cupi2.ligaBolos.interfaz.PanelOpciones;
import uniandes.cupi2.ligaBolos.interfaz.PanelInformacion;
import uniandes.cupi2.ligaBolos.mundo.Jugador;
import uniandes.cupi2.ligaBolos.mundo.LigaBolos;

public class InterfazLigaBolos extends JFrame {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Asociacion con la clase principal del mundo.
	 */
	private LigaBolos mundo;







	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------

	/**
	 * Panel con la imagen.
	 */
	private PanelImagen panelImagen;

	/**
	 * Panel con las opciones.
	 */
	private PanelOpciones panelOpciones;

	/**
	 * Panel con la Información.
	 */

	private PanelInformacion panelInformacion;

	/**
	 * Panel con la Navegación.
	 */

	private PanelNavegacion panelNavegacion;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye la ventana de la aplicación. <br>
	 * <b>post: </b> Se inicializaron los páneles con la información del sistema.
	 */

	public InterfazLigaBolos()
	{

		setLayout( new BorderLayout( ) );
		setSize( 700, 700 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		setTitle( "Liga Bolos" );

		panelImagen = new PanelImagen( );
		add( panelImagen, BorderLayout.NORTH );

		panelInformacion = new PanelInformacion(this);


		panelNavegacion = new PanelNavegacion(this);


		JPanel panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(  new BorderLayout());
		panelAuxiliar.add(panelInformacion, BorderLayout.CENTER);
		panelAuxiliar.add(panelNavegacion, BorderLayout.SOUTH);
		add( panelAuxiliar, BorderLayout.CENTER);
		panelAuxiliar.setBorder( new TitledBorder( "Información" ) );

		panelOpciones = new PanelOpciones(this  );
		add( panelOpciones, BorderLayout.SOUTH );


		try
		{
			mundo = new LigaBolos();
			mundo.darSiguienteJugador();
			panelInformacion.actualizar(mundo.darPrimerJugador());

		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Inicializar mundo", JOptionPane.ERROR_MESSAGE);
			dispose();
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			InterfazLigaBolos  interfaz = new InterfazLigaBolos();
			interfaz.setVisible (true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void avanzar()
	{
		try
		{
			Jugador siguiente = mundo.darSiguienteJugador();
			panelInformacion.actualizar(siguiente);

		}

		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Siguiente Jugador", JOptionPane.INFORMATION_MESSAGE);
		}


	}

	public void retroceder()
	{
		try
		{
			Jugador anterior = mundo.darAnteriorJugador();
			panelInformacion.actualizar(anterior);
		}
		catch (Exception e)
		{
			JOptionPane.showConfirmDialog(this, e.getMessage(), "Anterior Jugador", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void verprimero()
	{
		try
		{
			Jugador primer =mundo.darPrimerJugador();
			panelInformacion.actualizar(primer);
		}
		catch (Exception e)
		{
			JOptionPane.showConfirmDialog(this, e.getMessage(), "Desplazarse al primer jugador", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void verultimo()
	{
		try
		{
			Jugador ultimo = mundo.darUltimoJugador();
			panelInformacion.actualizar(ultimo);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Desplazarse al último jugador", JOptionPane.INFORMATION_MESSAGE);

		}
	}
	public void reqFuncional1()
	{
        
        JOptionPane.showMessageDialog(this, mundo.metodo1(), "Opción 1", JOptionPane.INFORMATION_MESSAGE);
	}

	public void reqFuncional2()
	{
      
      JOptionPane.showMessageDialog(this, mundo.metodo2(), "Opción 2", JOptionPane.INFORMATION_MESSAGE);
	}


	public void buscarpornombre()
	{
		String dato = JOptionPane.showInputDialog("Nombre del Jugador");
		if( dato != null && dato.trim().isEmpty())

			try
		{
				mundo.buscarJugadorPorNombre(dato);
		}
		catch (Exception e)
		{
			JOptionPane.showConfirmDialog(this, e.getMessage(), "Buscar por nombre", JOptionPane.ERROR_MESSAGE);
		}

		else 
			JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del jugador","Buscar por nombre", JOptionPane.ERROR_MESSAGE);

	}

	public void buscarmejorpromedio()
	{
		Jugador pJugador = mundo.darJugadorMejorPromedio();
        panelInformacion.actualizar(pJugador);
	}
}
