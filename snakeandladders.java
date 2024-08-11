package placement_training_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class sl {

    private static final int BOARD_SIZE = 100;
    private static final Map<Integer, Integer> snakesAndLadders = new HashMap<>();

    static {
     
        snakesAndLadders.put(16, 6);
        snakesAndLadders.put(47, 26);
        snakesAndLadders.put(49, 11);
        snakesAndLadders.put(53, 97);
        snakesAndLadders.put(94, 19);
        snakesAndLadders.put(91, 60);
        snakesAndLadders.put(24, 2);
        snakesAndLadders.put(93, 73);
        snakesAndLadders.put(75, 95);
        snakesAndLadders.put(98, 78);
    }


    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Snake and Ladder Game!");
        System.out.println("Enter the number players:");
        int n=scanner.nextInt();
        int[] currentPlayerPosition=new int[n];
        for(int i=0;i<n;i++)
        {
        	currentPlayerPosition[i]=1;
        }
        int i=0;
        int max=Integer.MIN_VALUE;
        while (max < BOARD_SIZE) {
        	for(i=0;i<n;i++) {
        		
            System.out.println("***Press enter to roll the dice***");
            scanner.nextLine();

            int diceValue = random.nextInt(6) + 1;
            System.out.println("Player-"+(i+1)+" rolled:" + diceValue);
            currentPlayerPosition[i] += diceValue;
            if(currentPlayerPosition[i]<=100) {
            System.out.println("Current position of "+(i+1)+": " + currentPlayerPosition[i]);
            }

           

            if (snakesAndLadders.containsKey(currentPlayerPosition[i])) {
            	int cur=currentPlayerPosition[i];
                int newPosition = snakesAndLadders.get(currentPlayerPosition[i]);
                if(cur>newPosition) {
                System.out.println("Oops! You landed on a snake.. Moving to position: " + newPosition);
                currentPlayerPosition[i] = newPosition;
            }
                else {
                	System.out.println("Amazing! You landed on a ladder.. Moving to position: " + newPosition);
                    currentPlayerPosition[i] = newPosition;
                }
            }
            if (currentPlayerPosition[i] > BOARD_SIZE) {
                currentPlayerPosition[i] = BOARD_SIZE - (currentPlayerPosition[i] - BOARD_SIZE);
            }

            if(currentPlayerPosition[i]>max)
            {
            	max=currentPlayerPosition[i];
            }
            if (currentPlayerPosition[i] == BOARD_SIZE) {
                System.out.println("Congratulations! Player"+(i+1)+" Won!");
                 break;
            }
           
            System.out.println();
        }
        }

        scanner.close();
    }

    public static void main(String[] args) {
       sl game = new sl();
        game.playGame();
    }
}

