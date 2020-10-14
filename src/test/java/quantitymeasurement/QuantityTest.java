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

    // 3 Feet to 1 Yard
    @Test
    public void given3FeetAnd1Yard_ShouldReturnTrue()
    {
        Length feet1 = new Length(Length.Unit.FEET,3.0);
        Length yard1 = new Length(Length.Unit.YARD,1.0);
        boolean compare = feet1.compare(yard1);
        Assert.assertTrue(compare);
    }
    // 1 ft != 1 yard
    @Test
    public void given1FeetAnd1Yard_ShouldReturnNotEqualLength()
    {
        Length feet1 = new Length(Length.Unit.FEET,1.0);
        Length inch1 = new Length(Length.Unit.YARD,1.0);
        boolean compareCheck = feet1.compare(inch1);
        Assert.assertFalse(compareCheck);
    }
    // 1 in != 1 yard
    @Test
    public void given1InchAnd1Yard_ShouldReturnNotEqualLength()
    {
        Length feet1 = new Length(Length.Unit.INCH,1.0);
        Length inch1 = new Length(Length.Unit.YARD,1.0);
        boolean compareCheck = feet1.compare(inch1);
        Assert.assertFalse(compareCheck);
    }
    // 1 yard == 36 in
    @Test
    public void given1YardAnd36Inch_ShouldReturnNotEqualLength()
    {
        Length yard1 = new Length(Length.Unit.YARD,1.0);
        Length inch1 = new Length(Length.Unit.INCH,36.0);
        boolean compareCheck = yard1.compare(inch1);
        Assert.assertTrue(compareCheck);
    }
    // 36 in = 1 yard
    @Test
    public void given36InchAnd1Yard_ShouldReturnNotEqualLength()
    {
        Length yard1 = new Length(Length.Unit.YARD,1.0);
        Length inch1 = new Length(Length.Unit.INCH,36.0);
        boolean compareCheck = inch1.compare(yard1);
        Assert.assertTrue(compareCheck);
    }
    // 1 Yard = 3 Ft
    @Test
    public void given1YardAnd3Feet_ShouldReturnTrue()
    {
        Length yard1 = new Length(Length.Unit.YARD,1.0);
        Length feet1 = new Length(Length.Unit.FEET,3.0);
        boolean compare = yard1.compare(feet1);
        Assert.assertTrue(compare);
    }

    // 2 Inch = 5 cm
    @Test
    public void given2InchAnd5Cm_ShouldReturnTrue()
    {
        Length inch1 = new Length(Length.Unit.INCH,2.0);
        Length cm1 = new Length(Length.Unit.CM,5.0);
        boolean compare = inch1.compare(cm1);
        Assert.assertTrue(compare);
    }
    // 1 Inch = 2.5 cm
    @Test
    public void given1InchAnd2AndHalfCm_ShouldReturnTrue()
    {
        Length inch1 = new Length(Length.Unit.INCH,1.0);
        Length cm1 = new Length(Length.Unit.CM,2.5);
        boolean compare = inch1.compare(cm1);
        Assert.assertTrue(compare);
    }
    // 5 cm = 2 inch
    @Test
    public void given5CmAnd2Inch_ShouldReturnTrue()
    {
        Length cm1 = new Length(Length.Unit.CM,5.0);
        Length inch1 = new Length(Length.Unit.INCH,2.0);
        boolean compare = cm1.compare(inch1);
        Assert.assertTrue(compare);
    }
}
