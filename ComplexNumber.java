public class ComplexNumber {
    private double real, imaginary;

    // Статичне поле для збереження кількості створених об'єктів
    private static int instanceCount = 0;

    // Конструктор
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        instanceCount++;
    }

    // Додавання комплексних чисел
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    // Віднімання комплексних чисел
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    // Множення комплексних чисел
    public ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(real * other.real - imaginary * other.imaginary,
                real * other.imaginary + imaginary * other.real);
    }

    // Ділення комплексних чисел
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        return new ComplexNumber((real * other.real + imaginary * other.imaginary) / denominator,
                (imaginary * other.real - real * other.imaginary) / denominator);
    }

    // Модуль комплексного числа
    public double modulus() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    // Комплексне спряження
    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    // Перевантажений метод toString
    @Override
    public String toString() {
        return String.format("%.2f + %.2fi", real, imaginary);
    }

    // Перевантажений метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ComplexNumber)) return false;
        ComplexNumber other = (ComplexNumber) obj;
        return Double.compare(real, other.real) == 0 && Double.compare(imaginary, other.imaginary) == 0;
    }

    // Статичний метод для отримання кількості створених об'єктів
    public static int getInstanceCount() {
        return instanceCount;
    }

    // Головний метод для демонстрації
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(3, 4);
        ComplexNumber c2 = new ComplexNumber(1, -2);

        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println("c1 + c2: " + c1.add(c2));
        System.out.println("c1 - c2: " + c1.subtract(c2));
        System.out.println("c1 * c2: " + c1.multiply(c2));
        System.out.println("c1 / c2: " + c1.divide(c2));
        System.out.println("Modulus of c1: " + c1.modulus());
        System.out.println("Conjugate of c1: " + c1.conjugate());
        System.out.println("Are c1 and c2 equal? " + c1.equals(c2));
        System.out.println("Number of instances created: " + ComplexNumber.getInstanceCount());
    }
}
