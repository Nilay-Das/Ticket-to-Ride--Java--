/* Class representing a two-way link between cities
 */
public class TwoWayLink extends Link{

    /* Construct a two-way link between c1 and c2 with length len
     * The City alphanumerically smaller is stored as city1 and the other will be city2
     * add the link to both cities
     */
    public TwoWayLink(City c1, City c2, int len){
        super(c1, c2, len);
    }

    /* Overriding toString() method to return a string representation of the two-way link
     * e.g. "City1 3 City2"
     * The city names should be in sorted order, e.g. Halifax comes before Toronto
     */
    public String toString() {
        return city1.toString() + " " + length + " " + city2.toString();
    }

}
