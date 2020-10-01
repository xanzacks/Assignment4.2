package com.company;
//This is p8.1
import java.util.Scanner;

public class Main {

    public static class ComboLock{
        private int counter = 0;//counter for both array
        private int currentNum = 0;//the current number
        int[] Arr = new int[] {0, 0, 0};//to store three secret number
        boolean[] Barr = new boolean[] {false, false, false};//judge by each case

        public ComboLock(int num1, int num2, int num3){//assign all three secret numbers
            Arr[0] = num1;
            Arr[1] = num2;
            Arr[2] = num3;
        }

        public void reset(){//reset all
            counter = 0;
            currentNum = 0;
            for(boolean iterate:Barr){
                iterate = false;
            }
        }

        public void turnLeft(int input){
            currentNum = currentNum - input%40;//get within 40
            if(currentNum < 0){// get the positive number when it is out of boundary
                currentNum = 40 + currentNum;
            }
            if(currentNum == Arr[counter]){//judge
                Barr[counter] = true;
            }
            else{
                Barr[counter] = false;
            }
            counter++;
        }

        public void turnRight(int input){
            currentNum = currentNum + input%40;//get within 40
            if(currentNum >= 40){// get the positive number when it is out of boundary
                currentNum = currentNum % 40;
            }
            if(currentNum == Arr[counter]){//judge
                Barr[counter] = true;
            }
            else{
                Barr[counter] = false;
            }
            counter++;
        }

        public boolean open(){
            if(Barr[0] && Barr[1] && Barr[2]){//if all true return ture
                return true;
            }
            else{
                return false;
            }
        }

    }
    public static void main(String[] args) {
	// write your code here
        System.out.print("Please input the three secret numbers for the lock, seperated by space: ");
        Scanner Userin = new Scanner(System.in);
        String input = Userin.nextLine();
        String numbers[] = input.split(" ");//get the input
        ComboLock obj = new ComboLock(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]));//object established
        do{
            System.out.print("Please input three numbers int right-left-right order to unlock: ");
            input = Userin.nextLine();
            numbers = null;
            numbers = input.split(" ");//split data
            obj.turnRight(Integer.parseInt(numbers[0]));
            obj.turnLeft(Integer.parseInt(numbers[1]));
            obj.turnRight(Integer.parseInt(numbers[2]));
            if(obj.open()){//if it is opened, give correct message and quit
                System.out.println("The lock has opened successfully");
                System.exit(1);
            }
            else{// it it is not open, ask the user to try
                System.out.println("There is something wrong with it");
            }
            System.out.println("Try again? (Y/N)");
            input = Userin.nextLine();
            obj.reset();
        }while(input.charAt(0) == 'Y');
    }
}
