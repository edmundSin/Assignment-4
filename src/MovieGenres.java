/* Edmund Sin
  * CISC 3130-TY9
  * Professor Chuang
  * 4/8/20
  * Assignment 4
  */ 

import java.io.*;
import java.util.*;

public class MovieGenres{
  
  public static void main(String [] args)throws IOException{
    
   String fileName = "movies.csv";
   String outFile = "myoutput.txt";
   PrintWriter output = new PrintWriter(outFile);
  
   //arraylist of genres of all movies 
  ArrayList<String> genres = new ArrayList<String>();
  //all movie titles
  ArrayList<String> titles = new ArrayList<String>();
  //all movie years
  ArrayList<String> years = new ArrayList<String>();
  
  int mapValue; 
  
  readFile(fileName,genres,2);
  readFile(fileName,titles,1);
  
  //remove table headers from .csv file
  titles.remove(0);
  genres.remove(0);
  
  //call splitter method to extract years from titles
  splitter(titles,years);
  
  //new hashmap; numGenres
  Map<String, Integer> numGenres = new HashMap<String,Integer>();
  //example 1
  mapValue = getMapValue("Adventure", genres);
  numGenres.put("Adventure", mapValue);
  
  //example 2
  mapValue = getMapValue("Action", genres);
  numGenres.put("Action", mapValue);
  
  //example 3
  mapValue = getMapValue("Comedy", genres);
  numGenres.put("Comedy", mapValue);
  
  //example 4
  mapValue = getMapValue("Drama", genres);
  numGenres.put("Drama", mapValue);
  
  //print first set of keys and values (Number of movies based on genre)
  output.println("Genre       Number of Titles");
  output.println("____________________________");
                  
  for(Map.Entry pairEntry: numGenres.entrySet()){
    output.printf("%-17s%d%n", pairEntry.getKey(), pairEntry.getValue());
    }
  
  //new hashmap; numGenresPastFiveYears
  Map<String, Integer> numGenresPastFiveYears = new HashMap<String,Integer>();
  mapValue = getMapValueII("Adventure", fileName);
  numGenresPastFiveYears.put("Adventure", mapValue);
  
  mapValue = getMapValueII("Action", fileName);
  numGenresPastFiveYears.put("Action", mapValue);
  
  mapValue = getMapValueII("Comedy", fileName);
  numGenresPastFiveYears.put("Comedy", mapValue);
  
  mapValue = getMapValueII("Drama", fileName);
  numGenresPastFiveYears.put("Drama", mapValue);
  
   //print second set of keys and values (Number of movies based on genre from past 5 years)
  output.println();
  output.println("Genre       Number of Titles (2015-2019)");
  output.println("________________________________________");
                  
  for(Map.Entry pairEntry: numGenresPastFiveYears.entrySet()){
    output.printf("%-23s%d%n", pairEntry.getKey(), pairEntry.getValue());
    }
  
  //new hashmap; numGenresPerYear
  Map<String, Integer> numGenresPerYear = new HashMap<String,Integer>();
  mapValue = getMapValueIII("Adventure","1999",fileName);
  numGenresPerYear.put("Adventure in 1999", mapValue);
  
  mapValue = getMapValueIII("Action","1998",fileName);
  numGenresPerYear.put("Action in 1998", mapValue);
  
  mapValue = getMapValueIII("Comedy","1997",fileName);
  numGenresPerYear.put("Comedy in 1997", mapValue);
  
  mapValue = getMapValueIII("Drama","1996",fileName);
  numGenresPerYear.put("Drama in 1996", mapValue);
  
  //print third set of keys and values (Number of movies based on genre from example years)
  output.println();
  output.println("Genre (Release Year)       Number of Titles");
  output.println("___________________________________________");
  for(Map.Entry pairEntry: numGenresPerYear.entrySet()){
    output.printf("%-23s%d%n", pairEntry.getKey(), pairEntry.getValue());
    }

  
  output.flush();
  output.close();
  }
  
  public static void readFile(String file, ArrayList<String> list, int index)throws IOException{
    
   FileInputStream in = new FileInputStream(file);
   BufferedReader myInput = new BufferedReader(new InputStreamReader(in));
   String thisLine;
    
    while ((thisLine = myInput.readLine()) != null) {
      String str[] = thisLine.split(",");
      //fill arraylist with the genre stored at index 2
      list.add(str[index]);
                       
        }
  }
  
  //method to split year from a string
  public static void splitter(ArrayList<String> str, ArrayList<String> finished){
    
    for(int i = 0; i<str.size();i++){
   String thisLine = str.get(i);
   String stri[] = thisLine.split("\\(");
   //the movie title 
   String title = thisLine.substring(0,thisLine.length());
   //the year is in the last index of the string array of split strings, remove the char ) with substring 
   String year = stri[stri.length-1].substring(0,stri[stri.length-1].length()-1);
   //add extracted year to finished arraylist
   finished.add(year);
   }
  }
  
  //method for returning # of genres in the entire .csv movie list
  public static int getMapValue(String genre,ArrayList<String>list){
    int count=0;
    for(int i=0;i<list.size()-1;i++){
      if(list.get(i).contains(genre) || list.get(i).equals(genre))
           count++;
         }
    return count;
  }
  
  //method for returning # of genres in the past 5 years
  public static int getMapValueII( String genre, String file)throws IOException{
   
   String y1 = "2015";
   String y2 = "2016";
   String y3 = "2017";
   String y4 = "2018";
   String y5 = "2019";
   int count = 0;
   
   FileInputStream in = new FileInputStream(file);
   BufferedReader myInput = new BufferedReader(new InputStreamReader(in));
   String thisLine;
    
   while ((thisLine = myInput.readLine()) != null){
      if((thisLine.contains(y1) || thisLine.contains(y2) || thisLine.contains(y3) || thisLine.contains(y4) || thisLine.contains(y5)) 
           && thisLine.contains(genre))
        count++;
    }
    return count;
  }
  
  //method for returning # of genres per input year
  public static int getMapValueIII(String genre, String year, String file)throws IOException{
   
   FileInputStream in = new FileInputStream(file);
   BufferedReader myInput = new BufferedReader(new InputStreamReader(in));
   String thisLine;
   int count = 0;
    
   while ((thisLine = myInput.readLine()) != null){
     if(thisLine.contains(year) && thisLine.contains(genre))
       count++;
   }
   return count;
  }
}