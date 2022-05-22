/**
 * DESCRIPTION: CaffeineCounter is an application that determines a person's caffeine tolerence limit(based on conditions and age) and according to that determines if they are close to exceeding their limit based on the drinks they log (using our 10 drink menu and sizes).
 * This is the backend application. Our figma also features other tools such as a maps extension to find nearby coffee/tea shops as well as progress trackers
 */

//imports
import java.util.Scanner;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        //scanner for user input
        Scanner s = new Scanner(System.in);

        //text file
        File user = new File("User Info"); //creating file - naming it database
        FileWriter fw = new FileWriter(user);
        PrintWriter pw = new PrintWriter(fw);

        //variables
        String name = "", email = "", size = "", choice = "";
        int age = 0, height = 0, weight = 0, condition = 0, type = 0, caffeine = 0, total = 0;
        double limit = 0.0;

        //intro
        System.out.println("Welcome to Caffeine Counter");
        System.out.println("A caffeine tracker designed to ensure that you don't exceed your caffeine consumption level\n");


            //log in/sign up
            System.out.println("Sign Up");
            System.out.println("Name:");
            name = s.nextLine();
            System.out.println("Email Address:");
            email = s.nextLine();

            //personal info page
            System.out.println("Thank you " + name + " an account is now registered under the email " + email);
            System.out.println("\nPlease enter some personal information to help us better assess your caffeine intake");

            System.out.println("Age: ");
            age = s.nextInt();
            s.nextLine();

            //finding caffeine limit - based on age
            if (age < 13)
                limit = 50;
            if (age < 18)
                limit = 125;
            if (age < 19)
                limit = 420;

            //other info
            System.out.println("Height: \t\t(in cm)");
            height = s.nextInt();
            s.nextLine();
            System.out.println("Weight: \t\t(in kg)");
            weight = s.nextInt();
            s.nextLine();

            //conditions
            System.out.println("Conditions or Concerns\n1. Pregnancy\n2. Diabetes\n3. Blood pressure complications\n4. None");
            System.out.println("Please select a menu option if you have any of the conditions listed above to help us better find your caffeine limit.");
            condition = s.nextInt();
            s.nextLine();

            //finding caffeine limit - based on condition
            switch (condition) {
                case 1:
                    limit = 200;
                    break;
                case 2:
                    limit = 180;
                    break;
                case 4:
                    limit = 250;
                    break;
                default:
                    limit = limit;
            }

            //writing to text file
            pw.printf("\nUSER INFO\nName: %s\nEmail: %s\nAge: %s years\nWeight: %s kg\nHeight: %s cm\nEstimated Limit: %s g",name,email, age, weight, height, limit);
            //closing text file
            pw.close();

            //log intro
            System.out.println("\nWelcome to the Caffeine Counter Log");
            System.out.println("Enter the details of your latest drink");

            //asking user for size of drink
            System.out.println("\nWhat size was consumed?\t\t(small, medium or large)");
            size = s.nextLine();

            //log menu + caffeine type
            System.out.println("\nCaffeine Type\n****************\n1. Coffee\n2. Expresso \n3. Decaf Coffee\n4. Black Coffee\n5. Latte\n6. Earl Tea\n7. Chai\n8. Green Tea\n9. Matcha\n10. Energy Drink");
            System.out.println("****************\nPlease select you caffeine type");
            type = s.nextInt();

            System.out.println("Calculating Caffeine intake...");

            //calculating caffeine in drink (average from most canadian suppliers)
            if (size.equalsIgnoreCase("small")) {
                switch (type) {
                    case 1:
                        caffeine = 140;
                        break;
                    case 2:
                        caffeine = 50;
                        break;
                    case 3:
                        caffeine = 6;
                        break;
                    case 4:
                        caffeine = 130;
                        break;
                    case 5:
                        caffeine = 150;
                        break;
                    case 6:
                        caffeine = 40;
                        break;
                    case 7:
                        caffeine = 50;
                        break;
                    case 8:
                        caffeine = 25;
                        break;
                    case 9:
                        caffeine = 60;
                        break;
                    case 10:
                        caffeine = 30;
                        break;
                    default:
                        caffeine = caffeine;
                        break;
                }
            } else if (size.equalsIgnoreCase("medium")) {
                switch (type) {
                    case 1:
                        caffeine = 205;
                        break;
                    case 2:
                        caffeine = 75;
                        break;
                    case 3:
                        caffeine = 9;
                        break;
                    case 4:
                        caffeine = 195;
                        break;
                    case 5:
                        caffeine = 170;
                        break;
                    case 6:
                        caffeine = 45;
                        break;
                    case 7:
                        caffeine = 70;
                        break;
                    case 8:
                        caffeine = 35;
                        break;
                    case 9:
                        caffeine = 75;
                        break;
                    case 10:
                        caffeine = 45;
                        break;
                    default:
                        caffeine = caffeine;
                        break;
                }
            } else if (size.equalsIgnoreCase("large")) {
                switch (type) {
                    case 1:
                        caffeine = 270;
                        break;
                    case 2:
                        caffeine = 150;
                        break;
                    case 3:
                        caffeine = 12;
                        break;
                    case 4:
                        caffeine = 260;
                        break;
                    case 5:
                        caffeine = 225;
                        break;
                    case 6:
                        caffeine = 80;
                        break;
                    case 7:
                        caffeine = 100;
                        break;
                    case 8:
                        caffeine = 50;
                        break;
                    case 9:
                        caffeine = 130;
                        break;
                    case 10:
                        caffeine = 70;
                        break;
                    default:
                        caffeine = caffeine;
                        break;
                }
            } else
                caffeine = caffeine;

            //showing user last caffeine consumption
            System.out.println("Your drink had " + caffeine + " grams of caffeine");

            //calculating the users total caffeine consumption of the day
            total = total + caffeine;

            //checking if the user is exceeding their limit
            if (total >= limit)
                System.out.println("You have exceeded your limit");
            else
                System.out.println("You are still within your caffeine intake range");
              
        }
    }