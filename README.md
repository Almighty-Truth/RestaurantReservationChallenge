# RestaurantReservationChallenge
Using the skeleton provided, display a menu of options for the user:
1. Make a Reservation
2. Change a Reservation
3. Cancel a Reservation
4. List all of the Reservations
5. Seat a Reservation
6. Add a Walk-In
7. List all of the Walk-Ins
8. Seat a Walk-In
9. Exit
Keep looping and displaying the menu, processing the user’s request. Each menu option calls a
corresponding public void method(), which in turn interacts with the user by asking for data that
is needed to then create a Reservation object(s) and pass it to the corresponding method in the
Helper class, to add, change, or remove either the linkedList of reservation objects or add and
remove to the queue of walk-in reservation objects.
Each of the following methods are called depending on the menu option that was selected:
1. public void addReservation(LinkedList<Reservation> theLL)
2. public void changeReservation(LinkedList<Reservation> theLL)
3. public void cancelReservation(LinkedList<Reservation> theLL)
4. public void listAllReservations(LinkedList<Reservation> theLL)
5. public void seatAReservation(LinkedList<Reservation> theLL)
6. public void addAWalkIn(Queue<Reservation> theQ)
7. public void listAllWalkIns(Queue<Reservation> theQ)
8. public Reservation seatAWalkIn(Queue<Reservation> theQ)
Use a linkedList of reservation objects and a queue of reservation objects.
Code all the methods that will affect the linkedList:
 public void addReservation(LinkedList<Reservation>): add a reservation object to
linkedList in the order of ascending dates
 public void changeReservation(LinkedList<Reservation>): iterate through the
linkedList to find a reservation object in the linkedList, set it to the new reservation with
the changed party size. Must stay in same order of ascending dates.
 public void cancelReservation(LinkedList<Reservation>): find a reservation object
in the linkedList, remove it
 public void listAllReserv(LinkedList<Reservation>): iterate through the reservation
linkedList and print each reservation objects in the order of ascending dates.
Code all the methods that will affect the queue:
 public void addAWalkInQueue(Queue<Reservation>): add a reservation object to the
queue in FIFO order
 public void listAllWalkIns(Queue<Reservation>): iterate through the reservation
queue and print all reservation objects in the queue in FIFO order
 public void seatAWalkIn(Queue<Reservation>): iterate through the reservation
queue and remove the first reservation object in the queue
