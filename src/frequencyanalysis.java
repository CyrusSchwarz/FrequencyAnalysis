//this is a proof of concept frequency analysis scanner. 
//Feel free to do whatever you want with this. 
//originally made by Cyrus @technophyte.com

import java.io.*;
import java.util.*;



class FrequencyAnalysis {
  public static void main(String[] args) throws IOException 
  {
    Scanner scan = new Scanner(System.in);
    //Creates a loop to create a more cohesive program
    boolean done = false;
    while (done == false)
    {
    
    //initializes variables
    String  answer, altered;
    int i, length, counter[] = new int[256];
    String ciphertext;
   


  
  
    
    
    //Asks the user what the phrase they'd like to analyze is
    System.out.println("What is the phrase you'd like to analyze? input the command (!fi) to analyze a text file");
    ciphertext = scan.nextLine();
    
    if (ciphertext.equalsIgnoreCase("!fi"))
    		{
    			try {
    	 
    					BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    	 
    					StringBuffer stringBuffer = new StringBuffer();
    					String line = null;
    	 
    					while((line =bufferedReader.readLine())!=null){
    	 
    						stringBuffer.append(line).append("\n");
    					}
    					ciphertext = stringBuffer.toString();
    	 
    			}
    			catch (IOException e)
    			{
    				
    				File f = new File("input.txt");
    				if(!f.exists()){
    				  f.createNewFile();
    				  System.out.println("File Created - Try running the program again!");
    				
    			}
    		}
    
    
    
    
 

    //This changes everything to uppercase removes everything that is not an alphabetical letter.
    ciphertext = ciphertext.toUpperCase();
    altered = ciphertext.replaceAll("[^A-Z]", "");

    //This counts the frequency of each letter in the input and displays it.
    
    // Counts frequency of every character and store in counter array
    
    length = altered.length();
    for (i = 0; i < length; i++) 
    {
        counter[(int) altered.charAt(i)]++;
    }
    // Print Frequency of characters
  
    for (i = 0; i < 256; i++) 
    {
        
        if (counter[i] != 0) {
            System.out.println((char) i + " --> " + counter[i]);
        }
       
    }
    System.out.println("Input length is " + ciphertext.length() + " characters");
    
    //Asks if the user would like to analyze another phrase. 
    System.out.println("Would you like to analyze another phrase? (Y/N)");
    System.out.println("You can put something new in the text file if you want to analyze something else via that method");
    answer = scan.nextLine();
    
    if (answer.equalsIgnoreCase("N"))
    {
        System.out.println("Exiting");
        System.exit(0);
        
    }
    
    if (answer.equalsIgnoreCase("Y"))
    {
        System.out.println("Continuing");
        
    }
        
        
        
        
        
        
    } 
    }
  }
}

   