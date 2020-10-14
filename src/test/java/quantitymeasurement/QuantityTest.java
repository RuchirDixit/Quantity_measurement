package quantitymeasurement;

import org.junit.Assert;
import org.junit.Test;

public class QuantityTest {

    @Test
    public void given0FeetAnd0Feet_ShouldReturnEqual()
    {
        Length feet1 = new Length(Length.Unit.FEET,0.0);
        Length feet2 = new Length(Length.Unit.FEET,0.0);
        Assert.assertEquals(feet1,feet2);
    }

    @Test
    public void given0FeetAnd1Feet_ShouldReturnNotEqual()
    {
        Length feet1 = new Length(Length.Unit.FEET,0.0);
        Length feet2 = new Length(Length.Unit.FEET,1.0);
        Assert.assertNotEquals(feet1,feet2);
    }

    @Test
    public void given0InchAnd0Inch_ShouldReturnEqual()
    {
        Length inch1 = new Length(Length.Unit.INCH,0.0);
        Length inch2 = new Length(Length.Unit.INCH,0.0);
        Assert.assertEquals(inch1,inch2);
    }
    @Test
    public void given0InchAnd1Inch_ShouldReturnNotEqual()
    {
        Length inch1 = new Length(Length.Unit.INCH,0.0);
        Length inch2 = new Length(Length.Unit.INCH,1.0);
        Assert.assertNotEquals(inch1,inch2);
    }

    @Test
    public void given0FeetAnd0Inch_ShouldReturnEqualLength()
    {
        Length feet1 = new Length(Length.Unit.FEET,0.0);
        Length inch1 = new Length(Length.Unit.INCH,0.0);
        boolean compareCheck = feet1.compare(inch1);
        Assert.assertTrue(compareCheck);
    }
    @Test
    public void given1FeetAnd1Inch_ShouldReturnNotEqualLength()
    {
        Length feet1 = new Length(Length.Unit.FEET,1.0);
        Length inch1 = new Length(Length.Unit.INCH,1.0);
        boolean compareCheck = feet1.compare(inch1);
        Assert.assertFalse(compareCheck);
    }

    @Test
    public void given1FeetAnd1Feet_WhenCompared_ShouldReturnEqualLength()
    {
        Length feet1 = new Length(Length.Unit.FEET,1.0);
        Length feet2 = new Length(Length.Unit.FEET,1.0);
        boolean compareCheck = feet1.compare(feet2);
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void given1FeetAnd12Inch_ShouldReturnEqualLength()
    {
        Length feet1 = new Length(Length.Unit.FEET,1.0);
        Length inch1 = new Length(Length.Unit.INCH,12.0);
        boolean compareCheck = feet1.compare(inch1);
        Assert.assertTrue(compareCheck);
    }

    //null
    @Test
    public void givenNullFeetAndNullFeet_ShouldReturnEqual()
    {
        Length feet1 = new Length(Length.Unit.FEET,null);
        Length feet2 = new Length(Length.Unit.FEET,null);
        boolean check = feet1.equals(feet2);
        Assert.assertTrue(check);
    }
    // Reference Check
    @Test
    public void given1FeetAnd1Inch_ShouldReturnNotEqual()
    {
        Length feet1 = new Length(Length.Unit.FEET,1.0);
        Length inch1 = new Length(Length.Unit.INCH,1.0);
        Assert.assertNotEquals(feet1,inch1);
    }
    // Type Check
    @Test
    public void givenFeetAndInch_ShouldReturnNotEqual()
    {
        Length feet1 = new Length(Length.Unit.FEET);
        Length inch1 = new Length(Length.Unit.INCH);
        Assert.assertNotEquals(feet1,inch1);
    }

    // Feet to Yard
    @Test
    public void given1YardAnd3Feet_ShouldReturnTrue()
    {
        Length feet1 = new Length(Length.Unit.FEET,1.0);
        Length yard1 = new Length(Length.Unit.YARD,0.333);
        boolean compare = feet1.compare(yard1);
        Assert.assertTrue(compare);
    }
}
