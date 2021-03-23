package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMainPanel mainPanel;

	public JMainFrame(ActionListener actionListener) {
		setTitle(ConstantsGUI.TITLE_APP);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.IMG_LIST_ICON)).getImage());
		setSize(ConstantsGUI.DIMENSION_FRAME);
		setMinimumSize(ConstantsGUI.DIMENSION_FRAME);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents(actionListener);
		setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		mainPanel = new JMainPanel(actionListener);
		add(mainPanel);
	}

	public void createHomePanel(ActionListener actionListener) {
		mainPanel.createFirstPanel(actionListener);
	}

	public void createAddPanel(ActionListener actionListener) {
		mainPanel.createAddPanel(actionListener);
	}

	public String getNameAddPanel() {
		return mainPanel.getNameAddPanel();
	}

	public String getPhoneAddPanel() {
		return mainPanel.getPhoneAddPanel();
	}

	public String getEmailAddPanel() {
		return mainPanel.getEmailAddPanel();
	}

	public void createSearchPanel(ActionListener actionListener) {
		mainPanel.createSearchPanel(actionListener);
	}

	public String getNameFindPanel() {
		return mainPanel.getNameFindPanel();
	}

	public void setPhoneFindPanel(String phoneNumber) {
		mainPanel.setPhoneFindPanel(phoneNumber);
	}

	public void setEmailFindPanel(String email) {
		mainPanel.setEmailFindPanel(email);
	}

	public void createDeletePanel(ActionListener actionListener) {
		mainPanel.createDeletePanel(actionListener);
	}

	public String getNameDeletePanel() {
		return mainPanel.getNameDeletePanel();
	}

	public void createListPanel(ActionListener actionListener) {
		mainPanel.createListPanel(actionListener);
	}

	public void setListContact(ArrayList<String> contactList) {
		mainPanel.setListContact(contactList);
	}

	public void createInfoPanel(ActionListener actionListener) {
		mainPanel.createInfoPanel(actionListener);
	}

	public void setMinorContact(String infoContact) {
		mainPanel.setMinorContact(infoContact);
	}

	public void setMajorContact(String infoContact) {
		mainPanel.setMajorContact(infoContact);
	}

	public void setNumberContact(int numContact) {
		mainPanel.setNumberContact(numContact);
	}
}