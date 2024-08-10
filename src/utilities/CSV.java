package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {
    // This function will read data from a CSV file and return it as a list.
    // List<String[]> is an example of a collection. It is read as 'list of string arrays'. Collections allow you to add elements dynamically.
    // each element in the list will be an array.
    public static List<String[]> read(String file) {
        // Create new linked list called 'data'.
        // "The reason we use a linked list of chunks is so that the garbage collector has the opportunity to release chunks earlier
        // once our algorithm has iterated past them for the last time."
        List<String[]> data = new LinkedList<String[]>();
        // Declare the variable to hold each line of the file outside. And define it inside the
        String datarow;
        try {
            // Buffered Readers: https://www.baeldung.com/java-filereader-vs-bufferedreader#:~:text=FileReader%20can%20be%20enough%20if,BufferedReader%20is%20the%20better%20option.
            BufferedReader br = new BufferedReader(new FileReader(file));
            // once we have this reader open, we want to read each line.
            // we set data row to the line being read, and while that line being read is not null, then execute below statements.
            while ((datarow = br.readLine()) != null) {
                // We want to split the line so:
                String[] dataRecords = datarow.split(",");
                // And then append the array 'dataRecords' to the linked list 'data'.
                data.add(dataRecords);
            }
        }
        // catch exceptions.
        catch (FileNotFoundException e) {
            System.out.println("COULD NOT FIND FILE");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("COULD NOT READ FILE");
            e.printStackTrace();
        }
        // return created dataset.
        return data;
    }
}
