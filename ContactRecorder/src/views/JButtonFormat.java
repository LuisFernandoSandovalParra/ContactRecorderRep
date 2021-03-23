package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonFormat extends JButton{

	private static final long serialVersionUID = 1L;

	public JButtonFormat(ActionListener actionListener, String pathImage, String actionCommand, String descAction, Color background) {
		setIcon(new ImageIcon(getClass().getResource(pathImage)));
		addActionListener(actionListener);
		setActionCommand(actionCommand);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setToolTipText(descAction);
		setContentAreaFilled(true);
		setBackground(background);
	}
}
