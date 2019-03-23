// Project 3 outline

import java.util.Scanner;  // Access the Scanner class
import java.io.*;          // Access PrintWriter and related classes

public class Project_1_03 {

   public static void main(String[ ] args) throws IOException {
   
      // Declarations
      final String INPUT_FILE  = "Project_1_03_Input.txt";
      final String OUTPUT_FILE = "Project_1_03_Output.txt";
      
      double[] mileage;       // Mileage values
      double[] reimb;         // Reimbursment values
      int numElements = 0;    // # of elements possible
      int numRead = 0;        // # of elements actually read
      double averageMileage = 0.0;  // Average of valid miles
      double averageReimb = 0.0;    // Average of valid reimbursements
      double totalMileage = 0.0;    // Total of valid miles
      double totalReimb   = 0.0;    // Total of valid reimbursements
      
      // Access the input and output files
      
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
      
      // ******** End declarations, begin execution ********
      
      // Get the maximum # of elements and allocate array sizes
      numElements = inputFile.nextInt();
      mileage = new double[numElements];
      reimb = new double[numElements];
      
      // Explain the program to the user
      explainProgram(outputFile);
      
      // Begin detailed processing
      numRead = readMileage(inputFile, mileage);
      calcReimbursement(mileage,reimb,numRead);
      displayHeading(outputFile);
      displayDetails(mileage,reimb,numRead);
      totalMileage   = calcTotal(mileage,numRead);
      totalReimb     = calcTotal(reimb,numRead);
      averageMileage = calcAverage(totalMileage,numRead);
      averageReimb   = calcAverage(totalReimb,numRead);
      
   } // End main

   //************************************************************************
   
   public static void explainProgram(PrintWriter output) {
      output.println("With this program, we will be calculating the " +
                     "reimbursement that you are owed for your fuel " +
                     "expenses. For a full breakdown of the reimbursement " +
                     "scale, please see the program's instructions.");
      output.println("");
      output.println("");
   } // End explainProgram
   
   //************************************************************************
   
   public static int readMileage(Scanner input, double[] mileage) {
      int numRead = 0;
      
      while(input.hasNext() && numRead < mileage.length) {
         mileage[numRead] = input.nextDouble();
         numRead++;
      } // End while
      
      return numRead;
   } // End readMileage
   
   //************************************************************************
   
   public static double calcReimbursement(double[] mileage,
                                        double[] reimb,
                                        int numProcess) {
                                        
      for (int i = 0; i < mileage.length; i++) {
         if(mileage[i] >= 2600.0) {
            reimb[i] = 190.0 + ((mileage[i] - 2600.0) * 0.06);
         }
         else if(milage >= 1900.0) {
            reimb[i] = 165.0 + ((mileage[i] - 1900.0) * 0.08); 
         }
         else if(milage >= 1300.0) {
            reimb[i] = 140.0 + ((mileage[i] - 1300.0) * 0.10); 
         }
         else if(milage >= 900.0) {
            reimb[i] = 115.0 + ((mileage[i] - 900.0) * 0.12); 
         }
         else if(milage >= 400.0) {
            reimb[i] = 65.0 + ((mileage[i] - 400.0) * 0.15); 
         }
         else {
            reimb[i] = mileage[i] * 0.18;
         }
      }
      
      return reimb;
   } // End calcReimbursement
   
   //************************************************************************
   
   public static void displayHeading(PrintWriter output) {
   } // End displayHeading
   
   //************************************************************************
   
   public static void displayDetails(double[] mileage,
                                     double[] reimb,
                                     int numProcess) {
   } // End displayDetails
   
   //************************************************************************
   
   public static double calcAverage(double total, int numProcess) {
   
      double average = 0.0; // average of values in array1
      average = total / numProcess;
      
      return average;
   } // End calcAverage
       
   //************************************************************************
   
   public static double calcTotal(double[] array1, int numProcess) {
   
      int total = 0.0; // total of values in array1
      
      for (int i = 0; i <array1.length; i++) {
         total += array1[i];
      }
      
      return total;
   } // End calcTotal
    
} // End class