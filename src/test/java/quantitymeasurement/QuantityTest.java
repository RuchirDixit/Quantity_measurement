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

    // Add 2 in + 2 in = 4 in
    @Test
    public void given2InchAnd2Inch_ShouldCorrectValue()
    {
        Length inch1 = new Length(Length.Unit.INCH,2.0);
        Length inch2 = new Length(Length.Unit.INCH,2.0);
        double addition = inch1.add(inch2);
        Assert.assertEquals(4.0,addition,0.0);
    }

    // Add 1 ft + 2 in = 14 in
    @Test
    public void given1FeetAnd2Inch_ShouldCorrectValue()
    {
        Length feet1 = new Length(Length.Unit.FEET,1.0);
        Length inch2 = new Length(Length.Unit.INCH,2.0);
        double addition = feet1.add(inch2);
        Assert.assertEquals(14.0,addition,0.0);
    }
    // Add 1 ft + 1 ft = 24 in
    @Test
    public void given1FeetAnd1Feet_ShouldCorrectValue()
    {
        Length feet1 = new Length(Length.Unit.FEET,1.0);
        Length feet2 = new Length(Length.Unit.FEET,1.0);
        double addition = feet1.add(feet2);
        Assert.assertEquals(24.0,addition,0.0);
    }
    // Add 2 in + 2.5 cm = 3 in
    @Test
    public void given2InchAnd2AndHalfCm_ShouldCorrectValue()
    {
        Length inch1 = new Length(Length.Unit.INCH,2.0);
        Length cm1 = new Length(Length.Unit.CM,2.5);
        double addition = inch1.add(cm1);
        Assert.assertEquals(3.0,addition,0.0);
    }
    // 1 gallon = 3.78 lt
    @Test
    public void given1GallonAndLitre_ShouldReturnEqualLength()
    {
        Length gallon1 = new Length(Length.Unit.GALLON,1.0);
        Length litre1 = new Length(Length.Unit.LITRE,3.78);
        boolean compare = gallon1.compare(litre1);
        Assert.assertTrue(compare);
    }
    // 1 lt = 1000 ml
    @Test
    public void given1LitreAnd1000Ml_ShouldReturnEqualLength()
    {
        Length litre1 = new Length(Length.Unit.LITRE,1.0);
        Length ml1 = new Length(Length.Unit.ML,1000.0);
        boolean compare = litre1.compare(ml1);
        Assert.assertTrue(compare);
    }
    // Add 1 gallon + 3.78 lt = 7.56 lt
    @Test
    public void given1GallonAndLitre_ShouldCorrectValue()
    {
        Length gallon1 = new Length(Length.Unit.GALLON,1.0);
        Length litre1 = new Length(Length.Unit.LITRE,3.78);
        double addition = gallon1.add(litre1);
        Assert.assertEquals(7.56,addition,0.0);
    }
    // Add 1 lt + 1000 ml = 2 lt
    @Test
    public void given1LitreAnd1000Ml_ShouldCorrectValue()
    {
        Length litre1 = new Length(Length.Unit.LITRE,1.0);
        Length ml1 = new Length(Length.Unit.ML,1000.0);
        double addition = litre1.add(ml1);
        Assert.assertEquals(2.0,addition,0.0);
    }
    // 1 kg = 1000 gms
    @Test
    public void given1KgAnd1000Gm_ShouldReturnEqualLength()
    {
        Length kg = new Length(Length.Unit.KG,1.0);
        Length gms = new Length(Length.Unit.GM,1000.0);
        boolean compare = kg.compare(gms);
        Assert.assertTrue(compare);
    }
    // 1 ton = 1000 kg
    @Test
    public void given1TonAnd1000Kg_ShouldReturnEqualLength()
    {
        Length ton = new Length(Length.Unit.TON,1.0);
        Length kg = new Length(Length.Unit.KG,1000.0);
        boolean compare = ton.compare(kg);
        Assert.assertTrue(compare);
    }
    // Add 1 ton + 1000 gm = 1001 kg
    @Test
    public void given1TonAnd1000Gm_ShouldCorrectValue()
    {
        Length ton = new Length(Length.Unit.TON,1.0);
        Length gm = new Length(Length.Unit.GM,1000.0);
        double addition = ton.add(gm);
        Assert.assertEquals(1001.0,addition,0.0);
    }
    // 212 F = 100 C
    @Test
    public void given212FahrenheitnAnd100Celsius_ShouldReturnEqualLength()
    {
        Length fahren = new Length(Length.Unit.FAHREN,212.0);
        Length celsius = new Length(Length.Unit.CEL,99.00000000000001);
        boolean compare = fahren.compare(celsius);
        Assert.assertTrue(compare);
    }

}
