import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RouteCost {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        TreeSet<Link> links = new TreeSet<Link>();
        boolean flag = true;

//        Calling the methods to take the input and giving the output
        firstInput(inp);
        flag = secondInput(inp, links, flag);
        if(flag){
            output(links);
        }
    }

    public static void firstInput(Scanner inp){

        while (true) {

            //      Taking the input as a line
            String input = inp.nextLine();

            //      Breaking the input loop if input is "done"
            if (input.equals("done")) {
                break;
            }

            //     Splitting elements of the input line into an array
            String[] result = input.split(" ");


            //       Variables to store the elements of the result array
            String city1Name = null;
            String city2Name = null;
            String direction = null;
            int length = 0;

//       Checking if the input line has less than three elements or more than four elements
            if (result.length > 4 || result.length < 3) {
                System.out.println("Invalid line: " + input);
                System.exit(0);
            }

            if (result.length == 3) {

                //        Extracting the data from the result array into variables
                city1Name = result[0].trim();
                try {
                    length = Integer.parseInt(result[1].trim());
                } catch (Exception e) {
                    System.out.println("Invalid line: " + input);
                    System.exit(0);
                }
                city2Name = result[2].trim();

//        Creating the city and link objects
                City c1 = City.find(city1Name);
                City c2 = City.find(city2Name);
                Link l = new TwoWayLink(c1, c2, length);
            }

            if (result.length == 4) {

                //        Extracting the data from the result array into the variables
                city1Name = result[0].trim();
                try {
                    length = Integer.parseInt(result[1].trim());
                } catch (Exception e) {
                    System.out.println("Invalid line: " + input);
                    System.exit(0);
                }
                city2Name = result[2].trim();
                direction = result[3].trim();

                //        Creating the city and link objects
                City c1 = City.find(city1Name);
                City c2 = City.find(city2Name);

                if (!(direction.equals("one") || direction.equals("two"))) {
                    System.out.println("Invalid line: " + input);
                    System.exit(0);
                } else {
                    if (direction.equals("one")) {
                        Link l = new OneWayLink(c1, c2, length, direction);
                    }
                    if (direction.equals("two")) {
                        Link l = new TwoWayLink(c1, c2, length);
                    }
                }
            }
        }
    }

    public static boolean secondInput(Scanner inp,  TreeSet<Link> links, boolean flag){

        while (true) {

            //      Taking the input as a line
            String input = inp.nextLine();

            //      Breaking the input loop if input is "done"
            if (input.equals("done")) {
                break;
            }

            //     Splitting elements of the input line into an array
            String[] result = input.split(" ");


            //       Variables to store the elements of the result array
            String city1Name = null;
            String city2Name = null;

            //       Checking if the input line has less than two elements or more than two elements
            if (result.length != 2) {
                System.out.println("Invalid line: " + input);
                System.exit(0);
            } else {
                city1Name = result[0].trim();
                city2Name = result[1].trim();
                City c = City.find(city1Name);
                c.makeTree();
                if (!c.getLinksTo(City.find(city2Name), links)) {
                    System.out.println("Error: Route not found! " + city1Name);
                    flag = false;
                    return flag;
                }
            }
        }
        return flag;
    }

    public static void output( TreeSet<Link> links){

        int total = 0;
        System.out.println("The rail network consists of:");
        for (Link l : links) {
            System.out.println("  " + l);
            total += l.getLength();
        }
        System.out.println("The total cost is: " + total);
    }
}



