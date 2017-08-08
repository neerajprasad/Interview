package thread.com.nrx;

public class TicketBooking {
	public static void main(String[] args) {
		TicketBookingSystem tbs = new TicketBookingSystem();
		Thread t1 = new Thread(tbs, "First");
		Thread t2 = new Thread(tbs, "second");
		t1.start();
		t2.start();
	}
}

class TicketBookingSystem implements Runnable {

	int ticketCount = 1;

	@Override
	public void run() {

		System.out.println("Waiting to book ticket for : " + Thread.currentThread().getName());
		synchronized (this) {

			if (ticketCount > 0) {
				System.out.println(" book ticket for : " + Thread.currentThread().getName());
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				--ticketCount;
				System.out.println("Ticket BOOKED for : " + Thread.currentThread().getName());
				System.out.println("currently ticketsAvailable = " + ticketCount);
			} else {
				System.out.println("Ticket NOT BOOKED for : " + Thread.currentThread().getName());
			}
		}
	}

}
