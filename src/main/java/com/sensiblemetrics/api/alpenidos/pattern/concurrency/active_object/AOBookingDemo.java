package com.sensiblemetrics.api.alpenidos.pattern.concurrency.active_object;

public class AOBookingDemo {

    static class BookingServant extends ActiveObject<Integer> {

        private int totalTicket;

        public BookingServant(int aTotalTicket) {
            this.totalTicket = aTotalTicket;
        }

        public int buyTicket(int numberTicket) {
            // simulate processing time
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (numberTicket > this.totalTicket) {
                return 0;
            }

            this.totalTicket -= numberTicket;
            return numberTicket;
        }

        public int remainTicket() {
            return totalTicket;
        }
    }

    static class BookingProxy {

        private final BookingServant scheduler;

        public BookingProxy(BookingServant aScheduler) {
            this.scheduler = aScheduler;
        }

        public ActiveObject.Callback<Integer> buyTicket(int numberTicket) throws InterruptedException {
            return this.scheduler.enqueue(() -> this.scheduler.buyTicket(numberTicket));
        }
    }

    static class BookingClient extends Thread {

        private final BookingProxy proxy;
        private final String name;

        public BookingClient(String name, BookingServant scheduler) {
            this.proxy = new BookingProxy(scheduler);
            this.name = name;
        }

        @Override
        public void run() {
            int numTicket = (int) (Math.random() * 200);

            try {
                final ActiveObject.Callback<Integer> re = this.proxy.buyTicket(numTicket);
                System.out.println("Client " + this.name + " set buy command: " + numTicket + " ticket(s)");

                while (!re.isDone()) {
                }

                if (re.isSuccess()) {
                    System.out.println("Client " + name + " bought: " + re.getRes() + " ticket(s)");
                } else {
                    System.out.println("Client " + name + " bought fail");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(final String[] args) throws InterruptedException {
        final BookingServant bookingServant = new BookingServant(400);

        final BookingClient client1 = new BookingClient("C1", bookingServant);
        final BookingClient client2 = new BookingClient("C2", bookingServant);
        final BookingClient client3 = new BookingClient("C3", bookingServant);
        final BookingClient client4 = new BookingClient("C4", bookingServant);
        final BookingClient client5 = new BookingClient("C5", bookingServant);

        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();

        client1.join();
        client2.join();
        client3.join();
        client4.join();
        client5.join();

        System.out.println("Remain: " + bookingServant.remainTicket());
    }
}
