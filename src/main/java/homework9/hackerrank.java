package homework9;

import java.util.Random;

public class hackerrank {
    public static void main(String[] args) {
        Random rand = new Random();

        int x = 5;

        int[][] arr = new int[x][x];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                arr[i][j] = rand.nextInt(15);
            }
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

        int a = 0;
        int b = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(i == j) {
                    a += arr[i][j];
                }
            }
        }
        for(int i = x-1; i > 0; i--) {
            int j = 1;
            b = arr[i][j];
            j++;
        }
        System.out.println(a + " " + b);
        System.out.println(a - b);
    }
}
