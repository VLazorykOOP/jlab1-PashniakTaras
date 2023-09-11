import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean Continue = true;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Лаб 1.\nВиберіть номер завдання (1-4): ");
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    First(); break;
                }
                case 2: {
                    Second(); break;
                }
                case 3: {
                    Third(); break;
                }
                case 4: {
                    Fourth(); break;
                }
                default:{System.out.print("Не те…");     break;}
            }
            Scanner check = new Scanner(System.in);
            System.out.println("Дивимося завдання далі? 1 - Так, 2 - Ні \n");
            int cont = check.nextInt();
            if(cont == 2) {
                Continue = false;
            } else {
                Continue = true;
            }
        } while (Continue);
        System.out.println("Дапабачення");

    }
    public static void First () {
        Scanner in = new Scanner(System.in);
        System.out.print("Завдання 1: виберіть частину завдання:\n1)дійсний-дійсний\n2)цілий-дійсний\n3)дійсний-цілий\n");
        int choice = in.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("Введіть дійсні числа:");
                Scanner scan = new Scanner(System.in);
                float a = scan.nextFloat();
                float b = scan.nextFloat();

                float res = a + ((a+b-1)/(a*a+2)) - (a*b)*(a*b)*(a*b);
                System.out.println("1) " + res); break;
            }
            case 2: {
                System.out.println("Введіть цілі числа:");
                Scanner scan = new Scanner(System.in);
                int a = scan.nextInt();
                int b = scan.nextInt();

                float res = a + ((a+b-1)/(a*a+2)) - (a*b)*(a*b)*(a*b);
                System.out.println("2) " + res); break;
            }
            case 3: {
                System.out.println("Введіть дійсні числа:");
                Scanner scan = new Scanner(System.in);
                float a = scan.nextFloat();
                float b = scan.nextFloat();

                float res1 = a + ((a+b-1)/(a*a+2)) - (a*b)*(a*b)*(a*b);
                int res2 = (int)res1;
                System.out.println("3) " + res2); break;
            }
            default:{System.out.print("Не те… \n"); break;}
        }
    }
    public static void Second() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть значення a: ");
        double a = scanner.nextDouble();
        System.out.print("Введіть значення b (більше ніж a): ");
        double b = scanner.nextDouble();

        System.out.print("Введіть розмір масиву X (n <= 200): ");
        int n = scanner.nextInt();

        if (n <= 0 || n > 200) {
            System.out.println("Неприпустимий розмір масиву X.");
            return;
        }

        double[] X = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Введіть значення X[" + (i + 1) + "]: ");
            X[i] = scanner.nextDouble();
        }

        double sumXLessThanA = 0;
        double productXGreaterThanB = 1;
        double maxXInRange = Double.MIN_VALUE;
        double minXInRange = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (X[i] < a) {
                sumXLessThanA += X[i];
            } else if (X[i] > b) {
                productXGreaterThanB *= X[i];
            }

            if (X[i] >= a && X[i] <= b) {
                if (X[i] > maxXInRange) {
                    maxXInRange = X[i];
                }
                if (X[i] < minXInRange) {
                    minXInRange = X[i];
                }
            }
        }

        System.out.println("Сума X(i) < a: " + sumXLessThanA);
        System.out.println("Добуток X(i) > b: " + productXGreaterThanB);
        System.out.println("Максимальне X(i) в діапазоні (a, b): " + maxXInRange);
        System.out.println("Мінімальне X(i) в діапазоні (a, b): " + minXInRange);
    }

    public static void Third() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмірність матриць (n): ");
        int n = scanner.nextInt();

        if (n >= 15) {
            System.out.println("Розмірність матриць має бути менше 15.");
            return;
        }

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] X = new int[n][n];

        System.out.println("Введіть матрицю A:");
        inputMatrix(A, n, scanner);

        System.out.println("Введіть матрицю B:");
        inputMatrix(B, n, scanner);

        for (int i = 0; i < n; i++) {
            int maxBRowValue = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                maxBRowValue = Math.max(maxBRowValue, B[i][j]);
            }

            for (int j = 0; j < n; j++) {
                X[i][j] = A[i][j] * maxBRowValue;
            }
        }

        System.out.println("Результат матриці X:");
        printMatrix(X, n);
    }

    public static void Fourth() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть текст: ");
        String inputText = scanner.nextLine();

        String[] words = inputText.split("[\\s\\p{Punct}]+");

        List<String> removedWords = new ArrayList<>();
        StringBuilder remainingText = new StringBuilder();

        for (String word : words) {
            if (!hasDuplicateLetters(word)) {
                remainingText.append(word).append(" ");
            } else {
                removedWords.add(word);
            }
        }

        System.out.println("Вилучені слова з подвоєнням літер:");
        for (String removedWord : removedWords) {
            System.out.print(removedWord + " ");
        }

        System.out.println("\nТекст, що залишився після вилучення:");
        System.out.println(remainingText.toString().trim());
    }

    public static boolean hasDuplicateLetters(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
    public static void inputMatrix(int[][] matrix, int n, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}