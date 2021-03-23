package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Event;

public class JPanelDeleteContact extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameField;

	public JPanelDeleteContact(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBackground(ConstantsGUI.BLUE_DARK_COLOR_BTNS);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createDeleteTitle();
		createFormulary(actionListener);
		createDeleteBtn(actionListener);
	}

	private void createDeleteTitle() {
		JLabel titleDeleteSpace = new JLabel(ConstantsGUI.TITLE_DELETE_CONTACT);
		titleDeleteSpace.setBorder(ConstantsGUI.BORDER_TITLE_PANEL);
		titleDeleteSpace.setHorizontalAlignment(SwingConstants.CENTER);
		titleDeleteSpace.setFont(ConstantsGUI.FONT_TITLE_PANEL);
		add(titleDeleteSpace, BorderLayout.NORTH);
	}

	private void createFormulary(ActionListener actionListener) {
		JPanel formularyPanel = new JPanel();
		formularyPanel.setBackground(ConstantsGUI.VEIGE_BASE_COLOR);
		formularyPanel.setBorder(ConstantsGUI.BORDER_DELETE_FORMULARY);
		formularyPanel.setLayout(new GridLayout(1, 2, 0, 5));

		JLabel nameLabel = new JLabel(ConstantsGUI.TEXT_LABEL_NAME);
		nameLabel.setFont(ConstantsGUI.FONT_FORMULARY_LABELS);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(nameLabel);

		nameField = new JTextField();
		nameField.setFont(ConstantsGUI.FONT_FORMULARY_LABELS);
		formularyPanel.add(nameField);

		add(formularyPanel, BorderLayout.CENTER);
	}

	private void createDeleteBtn(ActionListener actionListener) {
		JPanel deleteBtnPanel = new JPanel();
		deleteBtnPanel.setBackground(ConstantsGUI.BLUE_DARK_COLOR_BTNS);
		deleteBtnPanel.setBorder(ConstantsGUI.BORDER_ACCEPT_OR_CANCEL_BTN);
		deleteBtnPanel.setLayout(new GridLayout(1, 1, 10, 0));

		JButtonFormat deleteBtn = new JButtonFormat(actionListener, ConstantsGUI.IMG_DELETE_ICON,
				Event.DELETE_CONTACT.name(), ConstantsGUI.DESC_DELETE_CONTACT, ConstantsGUI.GREEN_DARK_ACCEPT_BTNS);
		deleteBtnPanel.add(deleteBtn);

		add(deleteBtnPanel, BorderLayout.SOUTH);
	}

	public String getName() {
		return nameField.getText();
	}
}