package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int countOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int countOfSeats = scanner.nextInt();
        Field field = new Field();
        field.Rows = countOfRows;
        field.Cols = countOfSeats;
        int countOfSoldTickets = 0;
        int totalSum = 0;
        while (true) {
            System.out.println("""
                    1. Show the seats
                    2. Buy a ticket
                    3. Statistics
                    0. Exit
                    """);
            int chooseNumber = scanner.nextInt();
            if (chooseNumber == 1) {
                field.conclusion();
            } else if (chooseNumber == 2) {
                System.out.println("Enter a row number:");
                countOfSoldTickets++;
                int rowNumber = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                int seatNumber = scanner.nextInt();
                while (!field.checkerSeat(rowNumber, seatNumber)) {
                    if (rowNumber > 9 || seatNumber > 9) {
                        System.out.println("Wrong input!");
                    } else {
                        System.out.println("That ticket has already been purchased!");
                    }
                    System.out.println("Enter a row number:");
                    countOfSoldTickets++;
                    rowNumber = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    seatNumber = scanner.nextInt();
                }
                field.savePlace(rowNumber, seatNumber);
                System.out.printf("Ticket price: $%d", ticketCost(countOfRows, countOfSeats, rowNumber));
                System.out.println();
                totalSum += ticketCost(countOfRows, countOfSeats, rowNumber);
            } else if (chooseNumber == 3) {
                System.out.printf("Number of purchased tickets: %d", countOfSoldTickets);
                System.out.println();
                float percentage = (float) countOfSoldTickets / ((float) countOfRows * (float) countOfSeats) * 100;
                System.out.printf("Percentage: %.2f", percentage);
                System.out.print("%");
                System.out.println();
                System.out.printf("Current income: $%d", totalSum);
                System.out.println();
                System.out.printf("Total income: $%d", income(countOfRows, countOfSeats));
                System.out.println();
            } else {
                break;
            }
        }
    }

    private static int income(int countOfRows, int countOfSeats) {
        int allSeats = countOfRows * countOfSeats;
        if (allSeats < 60) {
            return allSeats * 10;
        } else {
            return (countOfRows / 2 * countOfSeats * 10) +
                    ((countOfRows - countOfRows / 2) * countOfSeats * 8);
        }
    }

    private static int ticketCost(int countOfRows, int countOfSeats, int rowNumber) {
        int allSeats = countOfRows * countOfSeats;
        return allSeats < 60 ? 10 : rowNumber <= countOfRows / 2 ? 10 : 8;
    }
}