package pojos;

public class BookingResponsePojo {
    private Integer bookingid;
    private BookingPojo booking;
//    {
//        "bookingid": 390,
//            "booking": {
//        "firstname": "John",
//                "lastname": "Doe",
//                "totalprice": 111,
//                "depositpaid": true,
//                "bookingdates": {
//            "checkin": "2018-01-01",
//                    "checkout": "2019-01-01"
//        },
//        "additionalneeds": "Extra pillows please"
//    }
//    }

    public BookingResponsePojo() {
    }

    public BookingResponsePojo(Integer bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
