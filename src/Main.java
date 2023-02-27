import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file path:");

        String filePath = sc.nextLine();

        Map<String, Integer> votes = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String fileLine = bufferedReader.readLine();

            while (fileLine != null) {

                String[] properties = fileLine.split(",");
                String candidateName = properties[0];
                Integer candidateVotes = Integer.parseInt(properties[1]);

                if (votes.containsKey(candidateName)) {
                    votes.put(candidateName, candidateVotes + votes.get(candidateName));
                } else {
                    votes.put(candidateName, candidateVotes);
                }

                fileLine = bufferedReader.readLine();
            }

            System.out.println(" ======= ");

            for (String candidate : votes.keySet()) {
                System.out.println("Candidate: " + candidate + " Votes: " + votes.get(candidate));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not found");
        } catch (IOException e) {
            System.out.println("System error");
        } finally {
            sc.close();
        }
    }
}