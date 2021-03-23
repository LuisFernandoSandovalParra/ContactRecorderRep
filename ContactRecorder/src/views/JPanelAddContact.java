package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Event;

public class JPanelAddContact extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameField, phoneField, emailField;

	public JPanelAddContact(ActionListener actionListener) {
		setLayout(new BorderLayout(0, 2));
		setBackground(ConstantsGUI.BLUE_DARK_COLOR_BTNS);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createAddTitle();
		createFormulary(actionListener);
		createAddOrClearBtn(actionListener);
	}

	private void createAddTitle() {
		JLabel titleAddSpace = new JLabel(ConstantsGUI.TITLE_ADD_PANEL);
		titleAddSpace.setBorder(ConstantsGUI.BORDER_TITLE_PANEL);
		titleAddSpace.setHorizontalAlignment(SwingConstants.CENTER);
		titleAddSpace.setFont(ConstantsGUI.FONT_TITLE_PANEL);
		add(titleAddSpace, BorderLayout.NORTH);
	}

	private void createFormulary(ActionListener actionListener) {
		JPanel formularyPanel = new JPanel();
		formularyPanel.setBackground(ConstantsGUI.VEIGE_BASE_COLOR);
		formularyPanel.setBorder(ConstantsGUI.BORDER_FORMULARY);
		formularyPanel.setLayout(new GridLayout(3, 2, 0, 5));

		JLabel nameLabel = new JLabel(ConstantsGUI.TEXT_LABEL_NAME);
		nameLabel.setFont(ConstantsGUI.FONT_FORMULARY_LABELS);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(nameLabel);

		nameField = new JTextField();
		nameField.setFont(ConstantsGUI.FONT_FORMULARY_LABELS);
		formularyPanel.add(nameField);

		JLabel phoneLabel = new JLabel(ConstantsGUI.TEXT_LABEL_PHONE);
		phoneLabel.setFont(ConstantsGUI.FONT_FORMULARY_LABELS);
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(phoneLabel);

		phoneField = new JTextField();
		phoneField.setFont(ConstantsGUI.FONT_FORMULARY_LABELS);
		formularyPanel.add(phoneField);

		JLabel emailLabel = new JLabel(ConstantsGUI.TEXT_LABEL_EMAIL);
		emailLabel.setFont(ConstantsGUI.FONT_FORMULARY_LABELS);
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(emailLabel);

		emailField = new JTextField();
		emailField.setFont(ConstantsGUI.FONT_FORMULARY_LABELS);
		formularyPanel.add(emailField);

		add(formularyPanel, BorderLayout.CENTER);
	}

	private void createAddOrClearBtn(ActionListener actionListener) {
		JPanel addOrCleanPanel = new JPanel();
		addOrCleanPanel.setBackground(ConstantsGUI.BLUE_DARK_COLOR_BTNS);
		addOrCleanPanel.setBorder(ConstantsGUI.BORDER_ACCEPT_OR_CANCEL_BTN);
		addOrCleanPanel.setLayout(new GridLayout(1, 2, 5, 0));

		JButtonFormat clearBtn = new JButtonFormat(actionListener, ConstantsGUI.IMG_TRASH_ICON,
				Event.CLEAR_ADD_SECTION.name(), ConstantsGUI.DESC_CLEAR_FORM, ConstantsGUI.RED_CANCEL_BTNS);
		addOrCleanPanel.add(clearBtn);

		JButtonFormat addBtn = new JButtonFormat(actionListener, ConstantsGUI.IMG_TICK_ICON, Event.ADD_CONTACT.name(),
				ConstantsGUI.DESC_ADD_CONTACT, ConstantsGUI.GREEN_DARK_ACCEPT_BTNS);
		addOrCleanPanel.add(addBtn);

		add(addOrCleanPanel, BorderLayout.SOUTH);
	}

	public String getName() {
		return nameField.getText();
	}

	public String getPhone() {
		return phoneField.getText();
	}

	public String getEmail() {
		return emailField.getText();
	}

}
