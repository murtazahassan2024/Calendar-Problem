import java.util.Scanner;

public class Calender
{   public static void main(String[] args)
    {
        Scanner input = new Scanner (System.in);
        
        System.out.println("Enter the year  e.g:2012");
        int year = input.nextInt();

        System.out.println("Enter the month in number e.g:7");
        int month = input.nextInt();

        if(year<=1943 || month<1 || month>12)
        {
            System.out.println("Wrong input");
        }
        else
        {
            printMonth(year, month);
        }    
    }

    static void printMonth(int year, int month)
    {
        printMonthTitle(year,month);
        printMonthBody(year,month);
    }

    static void printMonthTitle(int month, int year)
    {
        System.out.println("         " + getMonthName(month) + " " + year);
        System.out.println("––––––––––––––––––––––––––––");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    static String getMonthName(int month)
    {
        String monthName="";
        switch (month)
        {
            case 1: 
                monthName = "January"; 
            break;
            
            case 2:
                monthName = "February"; 
            break;
            
            case 3: 
                monthName = "March"; 
            break;
            
            case 4: 
                monthName = "April"; 
            break;
            
            case 5: 
                monthName = "May"; 
            break;
            
            case 6: 
                monthName = "June"; 
            break;
            
            case 7: 
                monthName = "July"; 
            break;
            
            case 8: 
                monthName = "August"; 
            break;
            
            case 9: 
                monthName = "September"; 
            break;
            
            case 10: 
                monthName = "October"; 
            break;
            
            case 11: 
                monthName = "Nevember"; 
            break;
            
            case 12: 
                monthName = "December"; 
            break;
        }
        return monthName;
    }

    static void printMonthBody(int year, int month)
    {
        int startDay = getStartDay(year, month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        for (int i = 0; i < startDay; i++)
        {
            System.out.print("    ");
        }
        for (int i = 1; i <= numberOfDaysInMonth; i++) 
        {
        if (i < 10)
        {
            System.out.print("   " + i);
        }
        else
        {
            System.out.print("  " + i);
        } 
        if ((i + startDay) % 7 == 0)
        {
            System.out.println();
        }
      }
      System.out.println();
    }

    static int getStartDay(int year, int month)
    {
        int startDay1943 = 3;
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        
        return (totalNumberOfDays + startDay1943) % 7;
    }

    static int getTotalNumberOfDays(int year, int month)
    {
        int total=0;
        for(int i=1943; i<year; i++)
        {
            if(isLeapYear(i))
            {
                total += 366;
            }
            else
            {
                total =+ 365;
            }
        }
        for(int i=1; i<month; i++)
            {
                total += getNumberOfDaysInMonth(year, i);
            }
        return total;
    }

    static int getNumberOfDaysInMonth(int year, int month)
    {
        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
        // There are 31 days in month 1,3,5,7,8,10 and 12
        {
            return 31;
        }
        else if (month == 4 || month == 6 || month == 9 || month == 11)
        {
            return 30;
        }
        else if (month == 2)
        {
            return isLeapYear(year) ? 29 : 28;
        }
        else
        {
            return 0;
        }
    }

    static boolean isLeapYear(int year) 
    {
      return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}