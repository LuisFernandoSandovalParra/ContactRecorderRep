package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelInfoContactRecord extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel majorContactField, minorContactField, numberContactField;

	public JPanelInfoContactRecord(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBackground(ConstantsGUI.BLUE_DARK_COLOR_BTNS);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createInfoTitle();
		createFormulary(actionListener);
	}

	private void createInfoTitle() {
		JLabel titleInfoSpace = new JLabel(ConstantsGUI.TITLE_INFO_PANEL);
		titleInfoSpace.setBorder(ConstantsGUI.BORDER_TITLE_PANEL);
		titleInfoSpace.setHorizontalAlignment(SwingConstants.CENTER);
		titleInfoSpace.setFont(ConstantsGUI.FONT_TITLE_PANEL);
		add(titleInfoSpace, BorderLayout.NORTH);
	}

	private void createFormulary(ActionListener actionListener) {
		JPanel formularyPanel = new JPanel();
		formularyPanel.setBackground(ConstantsGUI.VEIGE_BASE_COLOR);
		formularyPanel.setBorder(BorderFactory.createCompoundBorder(ConstantsGUI.BORDER_FORMULARY,
				BorderFactory.createLineBorder(Color.BLACK)));
		formularyPanel.setLayout(new GridLayout(6, 1, 0, 5));

		JLabel minorContact = new JLabel(ConstantsGUI.TEXT_MINOR_CONTACT_LABEL);
		minorContact.setOpaque(true);
		minorContact.setBackground(ConstantsGUI.GREEN_ACCEPT_BTNS);
		minorContact.setFont(ConstantsGUI.FONT_FORMULARY_TITLE_LABELS);
		minorContact.setBorder(BorderFactory.createLineBorder(Color.black));
		minorContact.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(minorContact);

		minorContactField = new JLabel(ConstantsGUI.SYMBOL_EMPTY);
		minorContactField.setOpaque(true);
		minorContactField.setBackground(ConstantsGUI.BLUE_LIGHT_COLOR_BTNS);
		minorContactField.setFont(ConstantsGUI.FONT_FORMULARY_INFO_TREE);
		minorContactField.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(minorContactField);

		JLabel majorContact = new JLabel(ConstantsGUI.TEXT_MAJOR_CONTACT_LABEL);
		majorContact.setOpaque(true);
		majorContact.setBackground(ConstantsGUI.GREEN_ACCEPT_BTNS);
		majorContact.setFont(ConstantsGUI.FONT_FORMULARY_TITLE_LABELS);
		majorContact.setBorder(BorderFactory.createLineBorder(Color.black));
		majorContact.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(majorContact);

		majorContactField = new JLabel(ConstantsGUI.SYMBOL_EMPTY);
		majorContactField.setOpaque(true);
		majorContactField.setBackground(ConstantsGUI.BLUE_LIGHT_COLOR_BTNS);
		majorContactField.setFont(ConstantsGUI.FONT_FORMULARY_INFO_TREE);
		majorContactField.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(majorContactField);

		JLabel numberContacts = new JLabel(ConstantsGUI.TEXT_NUM_CONTACT_LABEL);
		numberContacts.setOpaque(true);
		numberContacts.setBackground(ConstantsGUI.GREEN_ACCEPT_BTNS);
		numberContacts.setFont(ConstantsGUI.FONT_FORMULARY_TITLE_LABELS);
		numberContacts.setBorder(BorderFactory.createLineBorder(Color.black));
		numberContacts.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(numberContacts);

		numberContactField = new JLabel(ConstantsGUI.SYMBOL_EMPTY);
		numberContactField.setOpaque(true);
		numberContactField.setBackground(ConstantsGUI.BLUE_LIGHT_COLOR_BTNS);
		numberContactField.setFont(ConstantsGUI.FONT_FORMULARY_INFO_TREE);
		numberContactField.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(numberContactField);

		add(formularyPanel, BorderLayout.CENTER);
	}

	public void setMinorContact(String infoContact) {
		minorContactField.setText(infoContact);
	}

	public void setMajorContact(String infoContact) {
		majorContactField.setText(infoContact);
	}

	public void setNumberContact(int numContact) {
		numberContactField.setText(String.valueOf(numContact));
	}
}
