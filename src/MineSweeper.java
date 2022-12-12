import java.util.Scanner;

public class MineSweeper {
    public int rowNumber;
    public int colNumber;
    public String[][] arrSweeper;
    public int[][] arr;
    public String[][] arrVision;

    public MineSweeper(int row, int col) {
        this.rowNumber = row;
        this.colNumber = col;

    }

    public void makeSweeper() {
        arrSweeper = new String[rowNumber][colNumber];

        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                arrSweeper[i][j] = "_";
            }
        }
        for (int k = 0; k < (rowNumber * colNumber / 4); k++) {
            int rndRow = (int) (Math.random() * rowNumber);
            int rndCol = (int) (Math.random() * colNumber);
            arrSweeper[rndRow][rndCol] = "*";
        }

        for (int a = 0; a < rowNumber; a++) {
            for (int b = 0; b < colNumber; b++) {
                System.out.print(arrSweeper[a][b] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
    }

    public void countSweeper() {
        makeSweeper();
        arr = new int[rowNumber][colNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                arr[i][j] = 0;
            }
        }
        for (int m = 0; m < rowNumber; m++) {
            for (int n = 0; n < colNumber; n++) {
                if (arrSweeper[m][n].equals("*")) {
                    for (int k = m - 1; k <= m + 1; k++) {
                        for (int l = n - 1; l <= n + 1; l++) {
                            if (k >= 0 && l >= 0 && k < rowNumber && l < colNumber) {
                                arr[k][l] += 1;
                            }
                        }
                    }
                }
            }
        }

    }
    public void run() {
        countSweeper();
        int rowUser;
        int colUser;
        int count=0;
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz!!");
        arrVision = new String[rowNumber][colNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                arrVision[i][j] = "_";
            }
        }
        for (int a = 0; a < rowNumber; a++) {
            for (int b = 0; b < colNumber; b++) {
                System.out.print(arrVision[a][b] + " ");
            }
            System.out.println();
        }
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.print("Satır Giriniz : ");
            rowUser = scan.nextInt();
            System.out.print("Sütun Giriniz : ");
            colUser = scan.nextInt();
            if (rowUser < 0 || colUser < 0 || rowUser >= rowNumber || colUser >= colNumber) {
                System.out.println("Yanlış değer girdiniz.Lütfen tekrar deneyin.");
            }else{
                if (arrSweeper[rowUser][colUser].equals("*")){
                    System.out.println("Kaybettiniz");
                    break;
                } else{
                    arrVision[rowUser][colUser]=String.valueOf(arr[rowUser][colUser]);
                    count++;
                    for (int i = 0; i < rowNumber; i++) {
                        for (int j = 0; j < colNumber; j++) {
                            System.out.print(arrVision[i][j]+" ");

                        }
                        System.out.println();
                    }
                }
                if (count==(rowNumber*colNumber)-((rowNumber*colNumber)/4)){
                    System.out.println("Kazandınız");
                    break;
                }
            }
        }
    }
}


