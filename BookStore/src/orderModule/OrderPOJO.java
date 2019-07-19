package orderModule;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderPOJO {

	@Id
	String orderID;
	String customerName;
	String phone_Number;
	int bookQuantity;
	String bookId;
	String addressLine1;
	String orderDate;

	public OrderPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderPOJO(String orderID, String customerName, String phone_Number, int bookQuantity, String bookId,
			String addressLine1, String orderDate) {
		super();
		this.orderID = orderID;
		this.customerName = customerName;
		this.phone_Number = phone_Number;
		this.bookQuantity = bookQuantity;
		this.bookId = bookId;
		this.addressLine1 = addressLine1;
		this.orderDate = orderDate;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderPOJO [orderID=" + orderID + ", customerName=" + customerName + ", phone_Number=" + phone_Number
				+ ", bookQuantity=" + bookQuantity + ", bookId=" + bookId + ", addressLine1=" + addressLine1
				+ ", orderDate=" + orderDate + "]";
	}

}
