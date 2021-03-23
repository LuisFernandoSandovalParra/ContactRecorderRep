package models;

import java.util.Comparator;

public class ComparatorContacts implements Comparator<Contact>{

	@Override
	public int compare(Contact nameOne, Contact nameTwo) {
		int compare = nameOne.getName().compareToIgnoreCase(nameTwo.getName());
		if (compare > 0) {
			return 1;
		}else if(compare == 0){
			return 0;
		}else {
			return -1;
		}
	}
}
