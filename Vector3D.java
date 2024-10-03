public class Vector3D {
    // Поля класу
    private double x, y, z;

    // Конструктор з параметрами (іншими конструкторами можна знехтувати для спрощення)
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Метод додавання векторів
    public Vector3D add(Vector3D other) {
        return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // Метод скалярного добутку векторів
    public double dotProduct(Vector3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    // Метод для обчислення довжини вектора
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Перевантаження методу toString для виведення
    @Override
    public String toString() {
        return String.format("Vector3D(%.2f, %.2f, %.2f)", x, y, z);
    }

    // Перевантаження методу equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vector3D)) return false;
        Vector3D other = (Vector3D) obj;
        return Double.compare(this.x, other.x) == 0 &&
               Double.compare(this.y, other.y) == 0 &&
               Double.compare(this.z, other.z) == 0;
    }

    // Головний метод для тестування
    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(1, 2, 3);
        Vector3D v2 = new Vector3D(4, 5, 6);

        System.out.println("Vector 1: " + v1);
        System.out.println("Vector 2: " + v2);

        System.out.println("Sum: " + v1.add(v2));
        System.out.println("Dot Product: " + v1.dotProduct(v2));
        System.out.println("Length of Vector 1: " + v1.length());
        System.out.println("Are vectors equal? " + v1.equals(v2));
    }
}
