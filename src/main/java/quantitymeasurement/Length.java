package quantitymeasurement;

public class Length {
    enum Unit { FEET, INCH, YARD, CM }
    private static final double FEET_TO_INCH = 12.0;
    private static final double FEET_TO_YARD = 3.0;
    private static final double YARD_TO_INCH = 36.0;
    private static final double INCH_TO_CM = 2.5;
    private Unit unit;
    private double value;
    private String valueString;

    public Length(Unit unit,double value) {
        this.unit = unit;
        this.value = value;
    }
    public Length(Unit unit,String value) {
        this.unit = unit;
        this.valueString = value;
    }
    public Length(Unit unit) {
        this.unit = unit;
    }

    public boolean compare(Length that) {
        if (this.unit.equals(that.unit))
            return this.equals(that);
        if (this.unit.equals(Unit.FEET) && that.unit.equals(Unit.INCH))
            return Double.compare(this.value*FEET_TO_INCH,that.value) == 0;
        if (this.unit.equals(Unit.FEET) && that.unit.equals(Unit.YARD))
            return Double.compare(this.value/FEET_TO_YARD,that.value) == 0;
        if (this.unit.equals(Unit.YARD) && that.unit.equals(Unit.INCH))
            return Double.compare(this.value*YARD_TO_INCH,that.value) == 0;
        if (this.unit.equals(Unit.INCH) && that.unit.equals(Unit.YARD))
            return Double.compare(this.value/YARD_TO_INCH,that.value) == 0;
        if (this.unit.equals(Unit.YARD) && that.unit.equals(Unit.FEET))
            return Double.compare(this.value*FEET_TO_YARD,that.value) == 0;
        if (this.unit.equals(Unit.INCH) && that.unit.equals(Unit.CM))
            return Double.compare(this.value*INCH_TO_CM,that.value) == 0;
        if (this.unit.equals(Unit.CM) && that.unit.equals(Unit.INCH))
            return Double.compare(this.value/INCH_TO_CM,that.value) == 0;
            return false;
    }

    public double add(Length that)
    {
        if(this.unit.equals(Unit.INCH) && that.unit.equals(Unit.INCH))
            return this.value + that.value;
        if(this.unit.equals(Unit.FEET) && that.unit.equals(Unit.INCH))
            return this.value * FEET_TO_INCH + that.value;
        if(this.unit.equals(Unit.FEET) && that.unit.equals(Unit.FEET))
            return this.value * FEET_TO_INCH + that.value * FEET_TO_INCH;
        if(this.unit.equals(Unit.INCH) && that.unit.equals(Unit.CM))
            return this.value + that.value / INCH_TO_CM;
        return 0;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Length length = (Length) that;
        return Double.compare(length.value, value) == 0 && unit == length.unit;
    }
}
