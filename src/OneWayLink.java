import java.lang.reflect.Constructor;
/* Class representing a one-way link between cities
 */
public class OneWayLink extends Link {

//    Instance variables
    private String direction;

    /* Overriding constructor to construct a one-way link between c1 and c2 with length len and direction
     * add the link to the starting city
     */
    public OneWayLink(City c1, City c2, int len, String direction){
        super(c1, c2, len, direction);
        this.direction = direction;
        c1.addLink(this);
    }

//    Getters
    public String getDirection(){
        return this.direction;
    }

    /* Overriding toString() method to return a string representation of the one-way link
     * e.g. "City1 3 City2 one"
     */
    public String toString() {
        return city1.toString() + " " + length + " " + city2.toString() + " " + "one";
    }
}
