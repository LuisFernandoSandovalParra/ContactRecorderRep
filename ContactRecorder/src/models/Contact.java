package models;

public class Contact {
	private String name;
	private String phoneNumber;
	private String email;

	public Contact(String name, String phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Contact(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return ConstantsModels.NAME_TEXT + name + ConstantsModels.NUMBER_TEXT + phoneNumber + ConstantsModels.EMAIL_TEXT
				+ email;
	}
}
