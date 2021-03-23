package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Event;

public class JMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanelAddContact panelAddContact;
	private JPanelFindContact panelFindContact;
	private JPanelDeleteContact panelDeleteContact;
	private JPanelListContact panelListContact;
	private JPanelInfoContactRecord panelInfoContactRecord;
	private JButtonFormat homeBtn, addBtn, searchBtn, deleteBtn, listBtn, infoBtn;

	public JMainPanel(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBorder(ConstantsGUI.BASE_BORDER_PANEL);
		setBackground(ConstantsGUI.VEIGE_BASE_COLOR);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createFirstPanel(actionListener);
	}

	public void createFirstPanel(ActionListener actionListener) {
		removeAll();
		createMenu(actionListener);
		createStartPanel();
		revalidate();
		repaint();
	}

	private void createMenu(ActionListener actionListener) {
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(ConstantsGUI.VEIGE_BASE_COLOR);
		panelMenu.setLayout(new GridLayout(1, 6, 1, 0));
		panelMenu.setBackground(Color.white);

		homeBtn = new JButtonFormat(actionListener, ConstantsGUI.IMG_HOME_ICON, Event.OPEN_HOME_SECTION.name(),
				ConstantsGUI.DESC_START, ConstantsGUI.ORANGE_COLOR_BTNS);
		panelMenu.add(homeBtn);

		addBtn = new JButtonFormat(actionListener, ConstantsGUI.IMG_ADD_ICON, Event.OPEN_ADD_SECTION.name(),
				ConstantsGUI.DESC_ADD_CONTACT, ConstantsGUI.ORANGE_COLOR_BTNS);
		panelMenu.add(addBtn);

		searchBtn = new JButtonFormat(actionListener, ConstantsGUI.IMG_SEARCH_ICON, Event.OPEN_SEARCH_SECTION.name(),
				ConstantsGUI.DESC_FIND_CONTACT, ConstantsGUI.ORANGE_COLOR_BTNS);
		panelMenu.add(searchBtn);

		deleteBtn = new JButtonFormat(actionListener, ConstantsGUI.IMG_DELETE_ICON, Event.OPEN_DELETE_SECTION.name(),
				ConstantsGUI.DESC_DELETE_CONTACT, ConstantsGUI.ORANGE_COLOR_BTNS);
		panelMenu.add(deleteBtn);

		listBtn = new JButtonFormat(actionListener, ConstantsGUI.IMG_LIST_ICON, Event.OPEN_LIST_SECTION.name(),
				ConstantsGUI.DESC_LIST_CONTACT, ConstantsGUI.ORANGE_COLOR_BTNS);
		panelMenu.add(listBtn);

		infoBtn = new JButtonFormat(actionListener, ConstantsGUI.IMG_DIAGRAM_ICON, Event.OPEN_INFO_SECTION.name(),
				ConstantsGUI.DESC_INFO_RECORD, ConstantsGUI.ORANGE_COLOR_BTNS);
		panelMenu.add(infoBtn);

		add(panelMenu, BorderLayout.NORTH);
	}

	private void createStartPanel() {
		JPanel panelStart = new JPanel();
		panelStart.setBackground(ConstantsGUI.VEIGE_BASE_COLOR);
		panelStart.setLayout(new BorderLayout());

		JLabel imageSpace = new JLabel(new ImageIcon(getClass().getResource(ConstantsGUI.IMG_MAIN_IMAGE)));
		panelStart.add(imageSpace);

		add(panelStart, BorderLayout.CENTER);
	}

	public void createAddPanel(ActionListener actionListener) {
		removeAll();
		createMenu(actionListener);
		panelAddContact = new JPanelAddContact(actionListener);
		add(panelAddContact, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public String getNameAddPanel() {
		return panelAddContact.getName();
	}

	public String getPhoneAddPanel() {
		return panelAddContact.getPhone();
	}

	public String getEmailAddPanel() {
		return panelAddContact.getEmail();
	}

	public void createSearchPanel(ActionListener actionListener) {
		removeAll();
		createMenu(actionListener);
		panelFindContact = new JPanelFindContact(actionListener);
		add(panelFindContact, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public String getNameFindPanel() {
		return panelFindContact.getName();
	}

	public void setPhoneFindPanel(String phoneNumber) {
		panelFindContact.setPhone(phoneNumber);
	}

	public void setEmailFindPanel(String email) {
		panelFindContact.setEmail(email);
	}

	public void createDeletePanel(ActionListener actionListener) {
		removeAll();
		createMenu(actionListener);
		panelDeleteContact = new JPanelDeleteContact(actionListener);
		add(panelDeleteContact, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public String getNameDeletePanel() {
		return panelDeleteContact.getName();
	}

	public void createListPanel(ActionListener actionListener) {
		removeAll();
		createMenu(actionListener);
		panelListContact = new JPanelListContact();
		add(panelListContact, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public void setListContact(ArrayList<String> contactList) {
		panelListContact.setListContact(contactList);
	}

	public void createInfoPanel(ActionListener actionListener) {
		removeAll();
		createMenu(actionListener);
		panelInfoContactRecord = new JPanelInfoContactRecord(actionListener);
		add(panelInfoContactRecord, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public void setMinorContact(String infoContact) {
		panelInfoContactRecord.setMinorContact(infoContact);
	}

	public void setMajorContact(String infoContact) {
		panelInfoContactRecord.setMajorContact(infoContact);
	}

	public void setNumberContact(int numContact) {
		panelInfoContactRecord.setNumberContact(numContact);
	}
}
