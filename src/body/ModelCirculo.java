package body;

public class ModelCirculo {
    private double radio;
    private double area;
    private double perimetro;

    public ModelCirculo (double radio) {
        setRadio(radio);
        setArea(calcAreaFromRadio());
        setPerimetro(calcPerimetroFromRadio());
    }

    public double getRadio() {
        return radio;
    }

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public double calcAreaFromRadio() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    public double calcPerimetroFromRadio() {
        return 2 * Math.PI * this.radio;
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %f%n%s: %f%n%s: %f%n",
                "Radio", getRadio(),
                "Area", getArea(),
                "Perimetro", getPerimetro()
        );
    }
}
