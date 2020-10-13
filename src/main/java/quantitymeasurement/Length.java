package quantitymeasurement;

public class Length {
    private final Unit unit;

    enum Unit { FEET, INCH}
    private final double value;

    public Length(Unit unit,double value) {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Length length = (Length) that;
        return Double.compare(length.value, value) == 0 && unit == length.unit;
    }
}
