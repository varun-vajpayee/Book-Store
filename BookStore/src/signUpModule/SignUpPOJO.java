package signUpModule;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SignUpPOJO {
	@Id
	String phone_Number;
	String password;
	String email_address;
	String addressLine1;
	String addressLine2;
	String city;
	String pinCode;

	public SignUpPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUpPOJO(String phone_Number, String password, String email_address, String addressLine1,
			String addressLine2, String city, String pinCode) {
		super();
		this.phone_Number = phone_Number;
		this.password = password;
		this.email_address = email_address;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.pinCode = pinCode;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "SignUpPOJO [phone_Number=" + phone_Number + ", password=" + password + ", email_address="
				+ email_address + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", pinCode=" + pinCode + "]";
	}

}
