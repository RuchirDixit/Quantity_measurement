package quantitymeasurement;

public class Length {
    enum Unit { FEET, INCH}
    private static final double FEET_TO_INCH = 12.0;
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
        return false;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Length length = (Length) that;
        return Double.compare(length.value, value) == 0 && unit == length.unit;
    }
}
