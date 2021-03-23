package models;

import java.util.ArrayList;
import java.util.Iterator;

import structures.AVLTree;

public class ContactRecord {

	private AVLTree<Contact> contactTree;

	public ContactRecord() {
		contactTree = new AVLTree<>(new ComparatorContacts());
		contactTree.createTree();
	}

	public void addContact(String name, String phoneNumber, String email) throws Exception {
		if (!contactTree.isIntoTree(new Contact(name))) {
			if (name.equalsIgnoreCase(ConstantsModels.EMPTY_STRING)) {
				throw new NullPointerException();
			} else {
				contactTree.insert(new Contact(name, phoneNumber, email));
			}
		} else {
			throw new Exception();
		}
	}

	public String findContact(String name) throws Exception {
		return contactTree.findNode(new Contact(name)).getData().toString();
	}

	public Contact foundContact(String name) throws NullPointerException {
		return contactTree.findNode(new Contact(name)).getData();
	}

	public void deleteContact(String name) throws NullPointerException {
		contactTree.deleteNode(new Contact(name));
	}

	public ArrayList<String> getContactList() {
		ArrayList<String> contactList = new ArrayList<>();
		Iterator<Contact> it = contactTree.inOrder();
		while (it.hasNext()) {
			contactList.add(it.next().toString());
		}
		return contactList;
	}

	public String getMinorContact() {
		if (getContactList().isEmpty()) {
			return ConstantsModels.DEFAULT_EMPTY_SYMBOL;
		} else {
			return getContactList().get(0);
		}
	}

	public String getMajorContact() {
		if (getContactList().isEmpty()) {
			return ConstantsModels.DEFAULT_EMPTY_SYMBOL;
		} else {
			return getContactList().get(getContactList().size() - 1);
		}
	}

	public int getQuantityContacts() {
		if (getContactList().isEmpty()) {
			return 0;
		} else {
			return getContactList().size();
		}
	}
}
