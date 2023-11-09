import java.util.Arrays;
import java.util.Scanner;

class Worker implements Comparable<Worker> {
    private String lastName;
    private String initials;
    private String position;
    private int startYear;

    public Worker(String lastName, String initials, String position, int startYear) {
        this.lastName = lastName;
        this.initials = initials;
        this.position = position;
        this.startYear = startYear;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStartYear() {
        return startYear;
    }

    @Override
    public int compareTo(Worker other) {
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString() {
        return "Прізвище: " + lastName +
                ", Ініціали: " + initials +
                ", Посада: " + position +
                ", Рік надходження на роботу: " + startYear;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Worker[] workers = new Worker[5];

        System.out.println("Введіть дані працівників:");

        for (int i = 0; i < workers.length; i++) {
            System.out.println("Працівник " + (i + 1) + ":");
            try {
                System.out.print("Прізвище: ");
                String lastName = scanner.next();

                System.out.print("Ініціали: ");
                String initials = scanner.next();

                System.out.print("Посада: ");
                scanner.nextLine();  // Очистка буфера
                String position = scanner.nextLine();

                System.out.print("Рік надходження на роботу: ");
                int startYear = scanner.nextInt();

                workers[i] = new Worker(lastName, initials, position, startYear);
            } catch (Exception e) {
                System.out.println("Помилка у введенні року. Спробуйте ще раз.");
                scanner.nextLine(); // Очистка буфера введення
                i--; // Повторити введення для поточного працівника
            }
        }

        Arrays.sort(workers);

        System.out.println("\nСписок працівників у впорядкованому за абеткою порядку:");
        for (Worker worker : workers) {
            System.out.println(worker);
        }

        System.out.print("\nВведіть стаж роботи для пошуку: ");
        int requiredExperience = scanner.nextInt();

        System.out.println("\nПрацівники, стаж роботи яких перевищує " + requiredExperience + " років:");

        for (Worker worker : workers) {
            if ((2023 - worker.getStartYear()) > requiredExperience) {
                System.out.println(worker);
            }
        }
    }
}
