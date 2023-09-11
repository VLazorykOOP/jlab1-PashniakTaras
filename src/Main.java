import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean Continue = true;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("��� 1.\n������� ����� �������� (1-4): ");
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
                default:{System.out.print("�� ��");     break;}
            }
            Scanner check = new Scanner(System.in);
            System.out.println("�������� �������� ���? 1 - ���, 2 - ͳ \n");
            int cont = check.nextInt();
            if(cont == 2) {
                Continue = false;
            } else {
                Continue = true;
            }
        } while (Continue);
        System.out.println("�����������");

    }
    public static void First () {
        Scanner in = new Scanner(System.in);
        System.out.print("�������� 1: ������� ������� ��������:\n1)������-������\n2)�����-������\n3)������-�����\n");
        int choice = in.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("������ ���� �����:");
                Scanner scan = new Scanner(System.in);
                float a = scan.nextFloat();
                float b = scan.nextFloat();

                float res = a + ((a+b-1)/(a*a+2)) - (a*b)*(a*b)*(a*b);
                System.out.println("1) " + res); break;
            }
            case 2: {
                System.out.println("������ ��� �����:");
                Scanner scan = new Scanner(System.in);
                int a = scan.nextInt();
                int b = scan.nextInt();

                float res = a + ((a+b-1)/(a*a+2)) - (a*b)*(a*b)*(a*b);
                System.out.println("2) " + res); break;
            }
            case 3: {
                System.out.println("������ ���� �����:");
                Scanner scan = new Scanner(System.in);
                float a = scan.nextFloat();
                float b = scan.nextFloat();

                float res1 = a + ((a+b-1)/(a*a+2)) - (a*b)*(a*b)*(a*b);
                int res2 = (int)res1;
                System.out.println("3) " + res2); break;
            }
            default:{System.out.print("�� �� \n"); break;}
        }
    }
    public static void Second() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������ �������� a: ");
        double a = scanner.nextDouble();
        System.out.print("������ �������� b (����� �� a): ");
        double b = scanner.nextDouble();

        System.out.print("������ ����� ������ X (n <= 200): ");
        int n = scanner.nextInt();

        if (n <= 0 || n > 200) {
            System.out.println("������������� ����� ������ X.");
            return;
        }

        double[] X = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("������ �������� X[" + (i + 1) + "]: ");
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

        System.out.println("���� X(i) < a: " + sumXLessThanA);
        System.out.println("������� X(i) > b: " + productXGreaterThanB);
        System.out.println("����������� X(i) � ������� (a, b): " + maxXInRange);
        System.out.println("̳������� X(i) � ������� (a, b): " + minXInRange);
    }

    public static void Third() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������ ��������� ������� (n): ");
        int n = scanner.nextInt();

        if (n >= 15) {
            System.out.println("��������� ������� �� ���� ����� 15.");
            return;
        }

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] X = new int[n][n];

        System.out.println("������ ������� A:");
        inputMatrix(A, n, scanner);

        System.out.println("������ ������� B:");
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

        System.out.println("��������� ������� X:");
        printMatrix(X, n);
    }

    public static void Fourth() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������ �����: ");
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

        System.out.println("������� ����� � ��������� ����:");
        for (String removedWord : removedWords) {
            System.out.print(removedWord + " ");
        }

        System.out.println("\n�����, �� ��������� ���� ���������:");
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