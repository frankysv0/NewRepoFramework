package com.pojoPOC;

public class BookingDetails {

	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private Dates bookingdates;
	private String additionalneeds;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public Dates getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(Dates bookingdates) {
		this.bookingdates = bookingdates;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

}
