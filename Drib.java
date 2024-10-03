public class Drib {
    private int numerator, denominator;

    // Конструктор
    public Drib(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero");
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    // НСД (Найбільший спільний дільник) для скорочення дробів
    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    // Додавання дробів
    public Drib add(Drib other) {
        return new Drib(numerator * other.denominator + other.numerator * denominator,
                denominator * other.denominator);
    }

    // Віднімання дробів
    public Drib subtract(Drib other) {
        return new Drib(numerator * other.denominator - other.numerator * denominator,
                denominator * other.denominator);
    }

    // Множення дробів
    public Drib multiply(Drib other) {
        return new Drib(numerator * other.numerator, denominator * other.denominator);
    }

    // Ділення дробів
    public Drib divide(Drib other) {
        return new Drib(numerator * other.denominator, denominator * other.numerator);
    }

    // Перевантажений метод toString
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Перевантажений метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Drib)) return false;
        Drib other = (Drib) obj;
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    // Головний метод для демонстрації
    public static void main(String[] args) {
        Drib d1 = new Drib(2, 3);
        Drib d2 = new Drib(4, 6);

        System.out.println("Drib 1: " + d1);
        System.out.println("Drib 2: " + d2);
        System.out.println("Sum: " + d1.add(d2));
        System.out.println("Difference: " + d1.subtract(d2));
        System.out.println("Product: " + d1.multiply(d2));
        System.out.println("Quotient: " + d1.divide(d2));
        System.out.println("Are Drib 1 and Drib 2 equal? " + d1.equals(d2));
    }
}
