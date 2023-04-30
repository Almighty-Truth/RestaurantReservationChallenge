/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicell;

/**
 *
 * @author Khalil Tobias 
 * Date: 4/17/2023
 * Instructor: Cristy charters
 * Class: Intermediate Java 
 */

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.UUID;
public class PracticeLL 
{
    // global keyboard
    public static Scanner keyboard = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        LinkedList<Reservation> chefCristy = new LinkedList<>();
        LinkedList<WalkIns> walkIns = new LinkedList<>();
         Stack<Long> reservationID = new Stack<>();
        
        int menuOption = 0;
        do
        {
            System.out.println("\nBefore: ");
            // calling the method
            menuOption = menuSelection();
            switch(menuOption)
            {
                case 1 -> {
                    addReservation(chefCristy);
                    System.out.println("\nAfter: ");
                    System.out.println(chefCristy);
                }
                case 2 -> {
                    cancelReservation(chefCristy);
                    System.out.println("\nAfter REMOVE: ");
                    System.out.println(chefCristy);
                }
                case 3 -> {
                    changeReservation(chefCristy);
                    System.out.println("\nAfter CHANGE: ");
                    System.out.println(chefCristy);
                }
                case 4 -> {
                    listOfReservations(chefCristy);
                    System.out.println("\nAll Reservations: ");
                    System.out.println(chefCristy);
                }
                case 5 -> {
                    seatReservation(chefCristy);
                    System.out.println("\nAfter Seating a Reservation: ");
                    System.out.println(chefCristy);
                }
                case 6 -> {
                    addWalkIn(walkIns);
                    System.out.println("\nAfter added WalkIn: ");
                    System.out.println(walkIns);
                }
                case 7 -> {
                    listOfWalkIns(walkIns);
                    System.out.println("\nAll WalkIns: ");
                    System.out.println(walkIns);
                }
                case 8 -> {
                    seatWalkIn(walkIns);
                    System.out.println("\nAfter seating a WalkIn: ");
                    System.out.println(walkIns);
                }   
                    
                default -> System.out.println("Thank you for using the reservation system. Bye!");
            }
        } while(menuOption != 9);
        
    }
    
   public static Reservation createReservation()
   {
        int year, month, day, hour, minute, partySize;
        String lastName, firstName;
        
        System.out.println("Please give me the last name of your party?");
        lastName = keyboard.nextLine();
        System.out.println("What is the first name?");
        firstName = keyboard.nextLine();
        System.out.println("What is the size of your party?");
        partySize = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("What year is your reservation for?");
        year = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("What month is your reservation for? (1 - 12)");
        month = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("What day is your reservation for? (1 - 31)");
        day = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("What time of day is your reservation for (Hour: 1 - 24)");
        hour = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("What minute of the hour is your reservation for (minute: 0-59) : ");
        minute = keyboard.nextInt();
        keyboard.nextLine();
        Reservation aReserv = new Reservation(year, month, day, hour, minute, lastName, firstName,
        partySize);
        
        return aReserv;
        
   }
   
   public static WalkIns getAWalkIn()
   {
       int partySize;
       String lastName, firstName;
       System.out.println("Give me the last name of the party: ");
       lastName = keyboard.nextLine();
       System.out.println("Give me the first name of the party: ");
       firstName = keyboard.nextLine();
       partySize = keyboard.nextInt();
       keyboard.nextLine();
       WalkIns aWalkin = new WalkIns(partySize, firstName, lastName);
       return aWalkin;
   }
   
   public static void addReservation(LinkedList<Reservation> theLL)
   {
       Reservation newReservation = createReservation();
       ListIterator<Reservation> it = theLL.listIterator();
       boolean added = false;
       Reservation nextReservation;
       
       while(it.hasNext() && !added)
       {
           nextReservation = it.next();
           if(nextReservation.compareTo( newReservation) >= 1)
           {
               it.previous();
               it.add( newReservation);
               added = true;
           }
       }
       if(!added)
       {
           it.add( newReservation);
       }
   }
   
   public static void cancelReservation(LinkedList<Reservation> theLL)
   {
       System.out.println("Provide the first name for the reservation to cancel the reservation: ");
       String firstName = keyboard.nextLine();
       System.out.println("Provide the last name for the reservation to cancel the reservation: ");
       String lastName = keyboard.nextLine();
       
       ListIterator<Reservation> restaurant = theLL.listIterator();
       boolean cancelRes = false;
       Reservation  nextReservation;
       
       while(restaurant.hasNext() && !cancelRes)
       {
           nextReservation = restaurant.next();
           if( nextReservation.getFirstName().equals(firstName) &&  
                   nextReservation.getLastName().equals(lastName))
           {
               restaurant.remove();
               System.out.println("Reservation has been cancelled successfully!");
               cancelRes = true;
           }
       }
       
       if(!cancelRes)
       {
           System.out.println("Sorry, reservation has not been found!");
           
       }
   }
   
   public static void changeReservation(LinkedList<Reservation> theLL)
   {
       System.out.println("Provide the first name for the reservation to be changed: ");
        String firstName = keyboard.nextLine();
        System.out.println("Provide the last name for the reservation to be changed: ");
        String lastName = keyboard.nextLine();
        
        ListIterator<Reservation> it = theLL.listIterator();
        boolean changeRes = false;
        Reservation nextReservation;
        while(it.hasNext() && !changeRes)
        {
            nextReservation = it.next();
            if(nextReservation.getFirstName().equals(firstName) && nextReservation.getLastName().equals(lastName))
            {
                System.out.println("Enrer a new party size: ");
                int partySize = keyboard.nextInt();
                keyboard.nextLine();
                Reservation newReservation;
                newReservation = new Reservation(nextReservation.getYear(), nextReservation.getMonth(),
                nextReservation.getDay(), nextReservation.getMilitaryHour(), nextReservation.getMilitaryMinute(),
                nextReservation.getLastName(), nextReservation.getFirstName(), partySize);
                
                it.set(newReservation);
                System.out.println("The reservation has been updated!");
                changeRes = true;
            }
        }
        if(!changeRes)
        {
            System.out.println("Reservation hasn't been found! Try again.");
            
        }
   }
   
   public static void listOfReservations(LinkedList<Reservation> theLL)
   {
       // adds the list of reservations
       LinkedList<Reservation> sortList = new LinkedList<>(theLL);
       sortList.sort(Reservation:: compareTo);
       
       System.out.println("Here are the lists of reservations: ");
       for(Reservation res: sortList)
       {
           System.out.println(res);
       }
   }
   
  public static void seatReservation(LinkedList<Reservation> theLL)
  {
      // seats the reservation   
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter the first name for the reservation if you wish to be seated: ");
      String firstName = keyboard.nextLine();
      System.out.println("Enter the last name for the reservation if you wish to be seated: ");
      String lastName = keyboard.nextLine();
      for(Reservation res: theLL)
      {
          if(res.getFirstName().equals(firstName) && res.getLastName().equals(lastName))
          {
             
              System.out.println(res);
              System.out.println("Reservation has been seated");
              break;
          }
          else
          {
              System.out.println("reservation not found");
          }
      }
    
//      System.out.println("Please provide the surname of the reservation you wish to seat: ");
//      String lastName = keyboard.nextLine();
//      System.out.println("Please provide the given name of the reservation you wish to seat: ");
//      int partySize = keyboard.nextInt();
//      keyboard.nextLine();
//      ListIterator<Reservation> restaurant = theLL.listIterator();
//      boolean seatedReserve = false;
//      Reservation nextReservation;
//      while(restaurant.hasNext() && !seatedReserve)
//      {
//          nextReservation = restaurant.next();
//          if(nextReservation.getLastName().equals(lastName) && nextReservation.getPartySize()
//                  == partySize)
//          {
//              restaurant.remove();
//              seatedReserve = true;
//              System.out.println("Follow me to your seat" + lastName+ " " + partySize);
//          }
//      }
//      if(seatedReserve)
//      {
//          System.out.println("We couldn't find your reservation. Try again!");
//          
//      }
//      System.out.println("Thanks for reserving this restaurant.");
  }
  
  public static void addWalkIn(LinkedList<WalkIns> theLL)
  {
      // adds the number of walk-ins 
      WalkIns newWalkIns = getAWalkIn();
      theLL.add(newWalkIns); // enter the number of
      System.out.println("Congrats, you have been placed on the walk-in list with " + newWalkIns+ " walk-ins.");
      
  }
  
  public static LinkedList<Reservation> listOfWalkIns(LinkedList<WalkIns> theLL)
  {
      LinkedList<Reservation> reservations = new LinkedList<>();
      System.out.println("Here are the list of walk-ins: ");
      if(theLL.isEmpty())
      {
          System.out.println("There aren't any walk-ins");
          
      }
      else
      {
          for (WalkIns newWalkIn : theLL) {
              System.out.println(newWalkIn.toString());
          }
      }
      return reservations;
      
  }
  public static void seatWalkIn(LinkedList<WalkIns> reservations)
  {
     if (!reservations.isEmpty()) {
        WalkIns reservation = reservations.remove();
        reservations.add(reservation);
        System.out.println("Congrats you have been seated.");
    } else {
        System.out.println("Sorry, there are no WalkIns to seat.");
    }
     
  }
  
  public static int menuSelection()
  {
      boolean errorOccurred = true;
      int menuOption = 0;
      do
      {
          try
          {
              System.out.println("Make a selection: ");
              System.out.println("1. Add a reservation");
              System.out.println("2. Cancel a reservation");
              System.out.println("3. change a reservation(number in party size only)!");
              System.out.println("4. List the reservations");
              System.out.println("5. Seat a reservation");
              System.out.println("6. Add a walk-in");
              System.out.println("7. List all the walk-ins");
              System.out.println("8. Seat a walk-in");
              System.out.println("9. Exit");
              menuOption = keyboard.nextInt();
              keyboard.nextLine();
              errorOccurred = false;
          }
          catch(InputMismatchException e)
          {
              System.out.println("You can only enter numbers 1-9");
              errorOccurred = false;
              keyboard.nextLine();
          }
      } while(errorOccurred == true || menuOption < 1 || menuOption >9);
      
      return menuOption;
  }
}
