import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OneWayLinkTest {

//Instance variables required for testing
    private City city1 = new City("Dhaka");
    private City city2 = new City("Khulna");
    private int length = 10;
    private String direction = "one";
    private OneWayLink testLink = new OneWayLink(city1, city2, length, direction);

    // This test case checks if the OneWayLink constructor sets the instance variables correctly
    @Test
    public void testConstructor(){
        assertEquals(city1, testLink.city1);
        assertEquals(city2, testLink.city2);
        assertEquals(length, testLink.getLength());
        assertEquals(direction, testLink.getDirection());
    }

//    This test case checks if the OneWayLink object returns the correct direction
    @Test
    public void getDirectionTest(){
        assertEquals(direction, testLink.getDirection());
    }

    // This test case checks if the toString() method returns the expected string representation of the OneWayLink object
    @Test
    public void toStringTest(){
       String expectedString = city1.toString() + " " + length + " " + city2.toString() + " " + direction;
       assertEquals(expectedString, testLink.toString());
    }
}
