package cinema;

import java.util.Arrays;
import java.util.Set;

public class Field {
    int Rows;
    int Cols;
    private final char[][] Seats = new char[9][9];

    public Field(int countOfRows, int countOfSeats) {
        Rows = countOfRows;
        Cols = countOfSeats;
    }
    public Field() {
        initSeats();
    }

    private void initSeats() {
        for (char[] row : Seats) {
            Arrays.fill(row, 'S');
        }
    }
    public boolean checkerSeat(int rowNumber, int seatNumber){
        if(rowNumber > 9 || seatNumber > 9){
            return false;
        }
        return Seats[rowNumber - 1][seatNumber - 1] != 'B';
    }
    public void savePlace(int rowNumber, int seatNumber){
        Seats[rowNumber - 1][seatNumber - 1] = 'B';
    }
    public void conclusion(){
        System.out.println("Cinema:");
        System.out.print(" ");
        for(int i = 1; i <= Cols;i++){
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < Rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < Cols; j++) {
                System.out.print(" " + Seats[i][j]);
            }
            System.out.println();
        }
    }
}
