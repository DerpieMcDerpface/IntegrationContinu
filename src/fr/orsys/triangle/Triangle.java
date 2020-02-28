package fr.orsys.triangle;

import java.util.Arrays;
import java.util.Objects;

public class Triangle {

    private int length1;
    private int length2;
    private int length3;

    //CONSTRUCTEURS :
    public Triangle(int length1, int length2, int length3) {
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
    }

    //GETTER AND SETTERS:
    public int getLength1() {
        return length1;
    }

    public void setLength1(int length1) {
        this.length1 = length1;
    }

    public int getLength2() {
        return length2;
    }

    public void setLength2(int length2) {
        this.length2 = length2;
    }

    public int getLength3() {
        return length3;
    }

    public void setLength3(int length3) {
        this.length3 = length3;
    }

    //METHODES :
    public TriangleType getType(){
        if(this.isInvalid()){
            return TriangleType.INVALID;
        }
        else if(this.isEquilateral()){
            return TriangleType.EQUILATERAL;
        }
        else if(this.isIsosceles()){
            return TriangleType.ISOSCELES;
        }
        else if(this.isRight()){
            return TriangleType.RIGHT;
        }
        else{
            return TriangleType.SCALENE;
        }
    }

    private boolean isEquilateral(){
        return !this.isInvalid() && (length3 == length2 && length2 == length1);
    }

    private boolean isIsosceles(){
        return !this.isInvalid() && (length1 == length2)
                || (length2 == length3)
                || (length1 == length3);
    }

    private boolean isInvalid(){
        return this.isFlat() || this.hasTooBigLength() || this.hasInvalidLength();
    }

    private boolean isFlat(){
        return length1 == 0 || length2 == 0 || length3 == 0;
    }

    private boolean hasTooBigLength(){
        return isTooBig(1) || isTooBig(2) || isTooBig(3);
    }

    private boolean isTooBig(int numLength){
        switch (numLength){
            case 1:
                if(length1 > length2+length3)
                    return true;
                break;
            case 2:
                if(length2 > length1+length3)
                    return true;
                break;
            case 3:
                if(length3 > length2+length1)
                    return true;
                break;
            default:
                return false;
        }
        return false;
    }

    private boolean hasInvalidLength(){
        return isNotValidLength(length1)
                || isNotValidLength(length2)
                || isNotValidLength(length3);
    }

    private boolean isNotValidLength(int length){
        return length <= 0;
    }

    private boolean isRight(){
        return Math.pow(this.getSidesOrder()[2],2) == (Math.pow(this.getSidesOrder()[1],2)+Math.pow(this.getSidesOrder()[0],2));
    }

    private int[] getSidesOrder(){
        int[] sidesOrder = new int[3];
        sidesOrder[0] = length1;
        sidesOrder[1] = length2;
        sidesOrder[2] = length3;
        Arrays.sort(sidesOrder);
        return sidesOrder;
    }

    //OVERRIDE METHODS :

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return getLength1() == triangle.getLength1() &&
                getLength2() == triangle.getLength2() &&
                getLength3() == triangle.getLength3();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLength1(), getLength2(), getLength3());
    }

    @Override
    public String toString() {
        return "fr.orsys.triangle.Triangle{" +
                "length1=" + length1 +
                ", length2=" + length2 +
                ", length3=" + length3 +
                '}';
    }

}
