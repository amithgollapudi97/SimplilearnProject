//----------IMPORTING PACKAGES----------
package simplilearnProject;

import java.io.File;

import java.io.IOException;

import java.util.Scanner;

import java.io.*;

import java.util.*;

public class Menu {
	
String Filename;

//----------FUNCTION TO CREATE FILE----------
public void add_file()
{
	try
{
	System.out.println("enter the file name u want add");
	Scanner n = new Scanner(System.in);
	Filename = n.next();
	File file  = new File(Filename);
	
	
	if(file.createNewFile())
	{
		System.out.println("file is created");
	
	}
		else
	{
		System.out.println("file exists");
	}
			
}

catch(Exception e)
{
	e.printStackTrace();

}
}

//----------FUNCTION TO DELETE FILE----------
public void delete_file()
{
	  
	System.out.println("enter the file name u want to delete");
	Scanner n = new Scanner(System.in);
	Filename = n.next();
	File file = new File(Filename); 
    boolean b = file.delete();
	if(b==true) 
    { 
        System.out.println("File deleted successfully"); 
    } 
    else
    { 
        System.out.println("Failed to delete the file"); 
    } 
}

//----------FUNCTION TO SEARCH A FILE----------
public void search_file()
{
	String path = "", fileName = "";
    try 
    	{
        	System.out.print("Please Enter the path-\t");
        	BufferedReader filePathReader = new BufferedReader(new InputStreamReader(System.in));
        	path = filePathReader.readLine();
        	
        	System.out.print("Please Enter file name-\t");
        	BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        	fileName = fileNameReader.readLine();

        	File directory = new File(path);
        	File[] listOfFiles = directory.listFiles();
        	for (File file : listOfFiles) 
        		{
                	String name = file.getName();
                	if (name.equals(fileName)) 
                		{
                        	System.out.println(name + " found in " + path + " directory");                	
                        	return;
                		}
        		}
        	System.out.println(fileName + " not found in " + path + " directory");
    	} 
    catch (IOException e) 
    	{e.printStackTrace();}
}

//----------MAIN CLASS----------
public static void main(String[] args) throws IOException
{
	
	boolean terminate = false;
	for(int i=1; i<=4;i++)
	{
		int option;


System.out.println("your options are");
System.out.println("1.add a file");
System.out.println("2.delete a file");
System.out.println("3.search a file");
System.out.println("0.terminate");
System.out.println("Please enter your choice");

Scanner s = new Scanner(System.in);
option = s.nextInt();

System.out.println();

//----------SWITCH CASE FOR USER OPTION----------

switch(option)
{
case 1:
	
	Menu m1 = new Menu();
	m1.add_file();
	break;
case 2:
	Menu m2 = new Menu();
	m2.delete_file();
	break;
	
case 3:
	Menu m3 = new Menu();
	m3.search_file();
	break;

case 0:
	 terminate = true;
	 break;
	default :
System.out.println("Invalid choice.");
}  

while (!terminate);

System.out.println("Bye-bye! Application Terminated...");
}
}
}
