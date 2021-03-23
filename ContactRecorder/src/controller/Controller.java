package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.ContactRecord;
import views.JMainFrame;

public class Controller implements ActionListener {

	private ContactRecord contactRecord;
	private JMainFrame jMainFrame;

	public Controller() {
		contactRecord = new ContactRecord();
		loadDefaultTestData();
		jMainFrame = new JMainFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Event.valueOf(e.getActionCommand())) {
		case OPEN_HOME_SECTION:
			jMainFrame.createHomePanel(this);
			break;
		case OPEN_ADD_SECTION:
			jMainFrame.createAddPanel(this);
			break;
		case OPEN_SEARCH_SECTION:
			jMainFrame.createSearchPanel(this);
			break;
		case OPEN_DELETE_SECTION:
			jMainFrame.createDeletePanel(this);
			break;
		case OPEN_LIST_SECTION:
			showListPanel();
			break;
		case OPEN_INFO_SECTION:
			showInfoPanel();
			break;
		case CLEAR_ADD_SECTION:
			clearAddContact();
			break;
		case ADD_CONTACT:
			addContact();
			break;
		case SEARCH_CONTACT:
			searchContact();
			break;
		case DELETE_CONTACT:
			deleteContact();
			break;
		default:
			break;
		}
	}

	private void addContact() {
		try {
			contactRecord.addContact(jMainFrame.getNameAddPanel(), jMainFrame.getPhoneAddPanel(),
					jMainFrame.getEmailAddPanel());
			JOptionPane.showMessageDialog(null, ConstantsCtn.MESSAGE_SUCCESS_ADD, ConstantsCtn.TITLE_SUCCESS_ADD,
					JOptionPane.INFORMATION_MESSAGE);
			jMainFrame.createAddPanel(this);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, ConstantsCtn.WARNING_MESSAGE_INPUT, ConstantsCtn.TITLE_OBLIGATORY_INPUT,
					JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ConstantsCtn.MESSAGE_CONTACT_EXIST, ConstantsCtn.TITLE_CONTACT_EXIST,
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void clearAddContact() {
		if (JOptionPane.showConfirmDialog(null, ConstantsCtn.QUESTION_CLEAR_FORMULARY, ConstantsCtn.TITLE_CLEAR_MESSAGE,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			jMainFrame.createAddPanel(this);
		}
	}

	private void searchContact() {
		try {
			jMainFrame.setPhoneFindPanel(contactRecord.foundContact(jMainFrame.getNameFindPanel()).getPhoneNumber());
			jMainFrame.setEmailFindPanel(contactRecord.foundContact(jMainFrame.getNameFindPanel()).getEmail());
		} catch (NullPointerException e) {
			jMainFrame.setPhoneFindPanel(ConstantsCtn.SIMBOL_IS_EMPTY);
			jMainFrame.setEmailFindPanel(ConstantsCtn.SIMBOL_IS_EMPTY);
			JOptionPane.showMessageDialog(null, ConstantsCtn.MESSAGE_NOT_EXIST_CONTACT,
					ConstantsCtn.TITLE_NOT_EXIST_CONTACT, JOptionPane.WARNING_MESSAGE);
		}
	}

	private void deleteContact() {
		try {
			if (JOptionPane.showConfirmDialog(null, ConstantsCtn.QUESTION_DELETE_CONTACT, ConstantsCtn.TITLE_DELETE,
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				contactRecord.deleteContact(jMainFrame.getNameDeletePanel());
				JOptionPane.showMessageDialog(null, ConstantsCtn.SUCCESS_DELETE_PROCESS,
						ConstantsCtn.TITLE_SUCCESS_DELETE, JOptionPane.INFORMATION_MESSAGE);
				jMainFrame.createDeletePanel(this);
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, ConstantsCtn.MESSAGE_NOT_EXIST_DELETE,
					ConstantsCtn.TITLE_NOT_EXIST_CONTACT, JOptionPane.WARNING_MESSAGE);
		}
	}

	private void showListPanel() {
		jMainFrame.createListPanel(this);
		jMainFrame.setListContact(contactRecord.getContactList());
	}

	private void showInfoPanel() {
		jMainFrame.createInfoPanel(this);
		jMainFrame.setMinorContact(contactRecord.getMinorContact());
		jMainFrame.setMajorContact(contactRecord.getMajorContact());
		jMainFrame.setNumberContact(contactRecord.getQuantityContacts());
	}

	private void loadDefaultTestData() {
		try {
			contactRecord.addContact("Luis Fernando", "3208317055", "luisandop@gmail.com");
			contactRecord.addContact("Maria Alejandra", "3157894654", "Marianspa@gmail.com");
			contactRecord.addContact("Pedro Velasquez", "3004875963", "pedrovelasquezco@gmail.com");
			contactRecord.addContact("Luis Alfonso", "3006557446", "simacluis@gmail.com");
			contactRecord.addContact("Santiago Castro", "3124869574", "shantsky@outlook.com");
			contactRecord.addContact("Anayive Parra", "3132009758", "anayivep@gmail.com");
			contactRecord.addContact("Fabian Alonso", "3112569847", "fabAlon25@gmail.com");
			contactRecord.addContact("Cristhian Castro", "3156478952", "cristhianCC@gmail.com");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ConstantsCtn.MESSAGE_CONTACT_EXIST, ConstantsCtn.TITLE_CONTACT_EXIST,
					JOptionPane.WARNING_MESSAGE);
		}
	}
}