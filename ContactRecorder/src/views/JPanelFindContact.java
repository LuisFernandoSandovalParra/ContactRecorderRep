package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Event;

public class JPanelFindContact extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JLabel phoneField, emailField;

	public JPanelFindContact(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBackground(ConstantsGUI.BLUE_DARK_COLOR_BTNS);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createFindTitle();
		createFormulary(actionListener);
		createFindBtn(actionListener);
	}

	private void createFindTitle() {
		JLabel titleFindSpace = new JLabel(ConstantsGUI.TITLE_FIND_CONTACT);
		titleFindSpace.setBorder(ConstantsGUI.BORDER_TITLE_PANEL);
		titleFindSpace.setHorizontalAlignment(SwingConstants.CENTER);
		titleFindSpace.setFont(ConstantsGUI.FONT_TITLE_PANEL);
		add(titleFindSpace, BorderLayout.NORTH);
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

		phoneField = new JLabel(ConstantsGUI.SYMBOL_EMPTY);
		phoneField.setFont(ConstantsGUI.FONT_FORMULARY_LABELS);
		phoneField.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(phoneField);

		JLabel emailLabel = new JLabel(ConstantsGUI.TEXT_LABEL_EMAIL);
		emailLabel.setFont(ConstantsGUI.FONT_FORMULARY_LABELS);
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(emailLabel);

		emailField = new JLabel(ConstantsGUI.SYMBOL_EMPTY);
		emailField.setFont(ConstantsGUI.FONT_FORMULARY_LABELS);
		emailField.setHorizontalAlignment(SwingConstants.CENTER);
		formularyPanel.add(emailField);

		add(formularyPanel, BorderLayout.CENTER);
	}

	private void createFindBtn(ActionListener actionListener) {
		JPanel findBtnPanel = new JPanel();
		findBtnPanel.setBackground(ConstantsGUI.BLUE_DARK_COLOR_BTNS);
		findBtnPanel.setBorder(ConstantsGUI.BORDER_ACCEPT_OR_CANCEL_BTN);
		findBtnPanel.setLayout(new GridLayout(1, 1, 10, 0));

		JButtonFormat findBtn = new JButtonFormat(actionListener, ConstantsGUI.IMG_SEARCH_ICON,
				Event.SEARCH_CONTACT.name(), ConstantsGUI.DESC_FIND_CONTACT, ConstantsGUI.GREEN_DARK_ACCEPT_BTNS);
		findBtnPanel.add(findBtn);

		add(findBtnPanel, BorderLayout.SOUTH);
	}

	public String getName() {
		return nameField.getText();
	}

	public void setPhone(String phoneNumber) {
		phoneField.setText(phoneNumber);
	}

	public void setEmail(String email) {
		emailField.setText(email);
	}
}