import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Visitor {

    private String fullName;
    private int age;
    private LocalDate dateOfVisit;
    private LocalTime timeOfVisit;
    private String comments;
    private String assistPerson;

    private static Logger logger = LogManager.getLogger(Visitor.class.getName());

    public Visitor(String fullName, int age, LocalDate dateOfVisit, LocalTime timeOfVisit, String comments, String assistPerson){

        this.fullName = fullName;
        this.age = age;
        this.dateOfVisit = dateOfVisit;
        this.timeOfVisit = timeOfVisit;
        this.comments = comments;
        this.assistPerson = assistPerson;
    }

    public void save(){

        String their_full_name = fullName.trim().toLowerCase().replace(" ","_");

        try {

            File folder = new File("Files");
            File file = new File("Files/visitor_" + their_full_name +".txt");

            folder.mkdir();

            FileWriter myWriter = new FileWriter(file.getPath());

            myWriter.write("Full Name: " + fullName + "\nAge: " + age + "\nDate of visit: " + dateOfVisit + "\nTime of visit: " + timeOfVisit + "\nComment: " + comments + "\nAssistant: " + assistPerson + "\n");
            myWriter.close();
            logger.info("Successfully wrote to the file.");

            load(file);

        }catch (IOException e){

            logger.error(e.getMessage());
            e.printStackTrace();
        }

    }
    public void load(File file){

        try{

            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }

            reader.close();
            logger.info("Successfully read everything from the file.");

        }catch (Exception e){

            logger.error(e.getMessage());
            e.printStackTrace();
        }

    }

}
