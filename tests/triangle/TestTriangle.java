package triangle;

import fr.orsys.triangle.Triangle;
import fr.orsys.triangle.TriangleType;
import org.junit.*;

public class TestTriangle{

    private static Triangle t1;

    @Test
    public void testGetTriangleTypeEquilateral(){
        t1 = new Triangle(3,3,3);
        Assert.assertEquals(TriangleType.EQUILATERAL, t1.getType());
    }

    @Test
    public void testGetTriangleTypeIsosceles(){
        t1 = new Triangle(3,3,1);
        Assert.assertEquals(TriangleType.ISOSCELES, t1.getType());
    }

    @Test
    public void testGetTriangleTypeInvalidWithLengthEqualZero(){
        t1 = new Triangle(0,1,2);
        Assert.assertEquals(TriangleType.INVALID, t1.getType());
    }

    @Test
    public void testGetTriangleTypeInvalidWithLengthNegative(){
        t1 = new Triangle(-1,1,2);
        Assert.assertEquals(TriangleType.INVALID, t1.getType());
    }

    @Test
    public void testGetTriangleTypeInvalidWithLengthTooBig(){
        t1 = new Triangle(10,1,2);
        Assert.assertEquals(TriangleType.INVALID, t1.getType());
    }

    @Test
    public void testGetTriangleTypeScalene(){
        t1 = new Triangle(3,4,6);
        Assert.assertEquals(TriangleType.SCALENE, t1.getType());
    }

    @Test
    public void testGetTriangleTypeRight(){
        t1 = new Triangle(3,4,5);
        Assert.assertEquals(TriangleType.RIGHT, t1.getType());
    }


}