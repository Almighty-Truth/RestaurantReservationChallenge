/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicell;

import java.time.LocalDateTime;

/**
 *
 * @author Student
 */
public class Reservation implements Comparable<Reservation>{
    private int year;
    private int month;
    private int day;
    private int militaryHour;
    private int militaryMinute;
    private String lastName;
    private String firstName;
    private int partySize;
    private LocalDateTime reservationTime;

    public Reservation(int year, int month, int day, int militaryHour, int militaryMinute,
            String lastName, String firstName, int partySize) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.militaryHour = militaryHour;
        this.militaryMinute = militaryMinute;
        this.lastName = lastName;
        this.firstName = firstName;
        this.partySize = partySize;
         this.reservationTime = LocalDateTime.of(year, month, day, militaryHour, 
                 militaryMinute);
    }
    
    Reservation(int partySize, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
    Reservation(WalkIns walkins, String firstName, String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMilitaryHour() {
        return militaryHour;
    }

    public void setMilitaryHour(int militaryHour) {
        this.militaryHour = militaryHour;
    }

    public int getMilitaryMinute() {
        return militaryMinute;
    }

    public void setMilitaryMinute(int militaryMinute) {
        this.militaryMinute = militaryMinute;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    @Override
    public String toString() 
    {
        return "Reservation = " + "year: " + year + ", month: " + month + ", day: " + day + ", Hour: " + militaryHour 
                + ", Minute: " + militaryMinute + ", lastName: " + lastName + ", firstName: " + firstName + ", partySize: " + partySize;
    }
    
    @Override
    public int compareTo(Reservation other)
    {
        if (this.year > other.year)
        {
            return 1;
        }
        else if (this.year < other.year)
        {
            return -1;
        }
        else
        {
            if (this.month > other.month)
            {
                return 1;
            }
            else if (this.month < other.month)
            {
                return -1;
            }
            else
            {
                if (this.day > other.day)
                {
                    return 1;
                }
                else if (this.day < other.day)
                {
                    return -1;
                }
                else
                {
                    if (this.militaryHour > other.militaryHour)
                    {
                        return 1;
                    }
                    else if (this.militaryHour < other.militaryHour)
                    {
                        return -1;
                    }
                    else
                    {
                        if (this.militaryMinute > other.militaryMinute)
                        {
                            return 1;
                        }
                        else if (this.militaryMinute < other.militaryMinute)
                        {
                            return -1;
                        }
                        else
                        {
                            return (this.lastName.compareTo(other.lastName) + this.firstName.compareTo(other.firstName));
                        }
                    }
                }
            }
        }
        
        
    }
    
}