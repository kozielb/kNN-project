public class Distance implements Comparable<Distance>{
    private final double distance;
    private final double typeLength;
    private String type;

    public Distance(double distance, double typeLength) {
        this.distance = distance;
        this.typeLength = typeLength;
        switch ((int) typeLength) {
            case 11 -> this.type = "Iris-setosa";
            case 15 -> this.type = "Iris-versicolor";
            case 14 -> this.type = "Iris-virginica";
        }
    }

    @Override
    public int compareTo(Distance o) {
        return Double.compare(this.distance,o.distance);
    }

    public String getType() {
        return type;
    }

    public double getTypeLength() {
        return typeLength;
    }

    @Override
    public String toString() {
        return distance+"";
    }
}
