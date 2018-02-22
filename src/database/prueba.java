package database;

import javax.swing.JOptionPane;

public class prueba {

	public static void main(String[] args) {
		try {
			DataAccess.getConnection();
			JOptionPane.showMessageDialog(null, "Conexion satisfactoria");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error : " + e);

		}

	}

}
