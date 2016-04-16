package uniandes.cupi2.ligaBolos.interfaz;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
/**
 * Panel con la imagen encabezado.
 */

public class PanelImagen extends JPanel
{
	/**
	 * Método constructor por defecto. Coloca la imagen del encabezado de la aplicación.
	 */
	public PanelImagen()
	{
		JLabel lblImagen = new JLabel( );
		ImageIcon icono = new ImageIcon( "data/imagenes/titulo.jpg" );
		lblImagen.setIcon( icono );
		add(lblImagen);
	}

}
