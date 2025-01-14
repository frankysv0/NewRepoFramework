package com.resourcePOC;

import com.pojoPOC.BookingDetails;
import com.pojoPOC.Dates;

public class Payload {

	static BookingDetails bd;
	static Dates d;

	public static BookingDetails bookHotelPayload(String firstname, String lastname, int totalprice,
			boolean depositpaid, String checkin, String checkout, String additionalneeds) {

		bd = new BookingDetails();
		bd.setFirstname("Stuart");
		bd.setLastname("little");
		bd.setTotalprice(234);
		bd.setDepositpaid(true);
		bd.setAdditionalneeds("Lunch");

		d = new Dates();
		d.setCheckin("2025-01-12");
		d.setCheckout("2025-01-15");

		bd.setBookingdates(d);

		return bd;

	}

	public static BookingDetails updatePayload(int totalprice, String checkin, String checkout) {

		bd.setTotalprice(987);
		d.setCheckin("2025-03-08");
		d.setCheckout("2025-03-10");

		bd.setBookingdates(d);
		return bd;
	}
}
