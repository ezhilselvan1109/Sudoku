import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sudoku sudoku=new Sudoku();
        sudoku.main();
    }
}
class Sudoku{
    public void main() {
        int arr[][] = new int[9][9];
        int i, j;
        for(i=0;i<9;i++){
            for(j=0;j<9;j++){
                arr[i][j]=0;
            }
        }
        Function obj=new Function();
        obj.assignFunction(arr);
        obj.printFunction(arr);
        obj.startFuction(arr);
    }
}
class Function{
public static int valueFunction(){
    int value;
    Scanner scan = new Scanner(System.in);
    try {
        System.out.print("Enter The Value: ");
        value = scan.nextInt();
        if(9<value){
            System.out.println("pls enter a number 9 and below ");
            return valueFunction();
        }
        return value;
    }catch (InputMismatchException e){
        System.out.println("pls enter Number Format !!!!!!!!!!!!!!");
        valueFunction();
    }
    return 0;
}
public static void startFuction(int arr[][]) {
    Scanner scan = new Scanner(System.in);
    try {
        System.out.print("Enter The Row Number: ");
        int row = scan.nextInt();
        System.out.print("Enter The Col Number: ");
        int col = scan.nextInt();
        int value = valueFunction();
        arr[row][col] = value;
    }catch(ArrayIndexOutOfBoundsException e ){
        System.out.println("pls enter a number 8 and below !!!!!!!!!!!!!!!!!!");
        startFuction(arr);
    }catch (InputMismatchException e){
        System.out.println("pls enter Number Format !!!!!!!!!!!!!!");
        startFuction(arr);
    }
    assignFunction(arr);
    printFunction(arr);
    while (true) {
        System.out.println("\t\t(1) - Check  (2) - Next");
        System.out.print("Enter The Choice: ");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                check(arr);
                break;
            case 2:
                startFuction(arr);
                break;
        }

    }
}


public static void printFunction(int arr[][]) {
    int i, j, k;
    System.out.print("    ");
    for (k = 0; k < 9; k++) {
        System.out.print(k+ "   ");
    }
    System.out.println();
    System.out.print("  ");
    for (k = 0; k < 4; k++) {
        System.out.print("+---+---");
    }
    System.out.println("+---+");
    for (i = 0; i < 9; i++) {
        System.out.print(i+ " | ");
        for (j = 0; j < 9; j++) {
            if(arr[i][j]==0){
                System.out.print(" " + " | ");
            }else {
                System.out.print(arr[i][j] + " | ");
            }
        }
        System.out.println();
        System.out.print("  ");
        for (k = 0; k < 4; k++) {
            System.out.print("+---+---");
        }
        System.out.println("+---+");
    }
}

public static void check(int arr[][]) {
    boolean flag1, flag2,flag3;
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            int rcv = arr[i][j];
            flag1 = checkRow(arr, i,j, rcv);
            flag2 = checkCol(arr, i,j, rcv);
            flag3 = giveGrid(arr, i,j, rcv);
            if (flag1 || flag2 || flag3) {
                System.out.println("Row: "+flag1+" Col: "+flag2+" Grid: "+flag3+" "+"Out");
                return;
            }
        }
    }
    System.out.println("\t\t\t\t\tWin");
}

public static boolean giveGrid(int[][] arr, int row,int col, int rcv){
    boolean flag=false;
    if((0<=row && row<3) && (0<=col && col<3)){
        flag=checkGrid(arr,row,col,rcv,0,3,0,3,1);
    }else if((0<=row && row<3)&& (3<=col && col<6)){
        flag=checkGrid(arr,row,col,rcv,0,3,3,6,2);
    }else if((0<=row && row<3)&& (6<=col && col<9)){
        flag=checkGrid(arr,row,col,rcv,0,3,6,9,3);
    }else if((3<=row && row<6)&&(0<=col && col<3)){
        flag=checkGrid(arr,row,col,rcv,3,6,0,3,4);
    }else if((3<=row && row<6)&& (3<=col && col<6)){
        flag=checkGrid(arr,row,col,rcv,3,6,3,6,5);
    }else if((3<=row && row<6)&& (6<=col && col<9)){
        flag=checkGrid(arr,row,col,rcv,3,6,6,9,6);
    }else if((6<=row && row<9)&&(0<=col && col<3)){
        flag=checkGrid(arr,row,col,rcv,6,9,0,3,7);
    }else if((6<=row && row<9)&&(3<=col && col<6)){
        flag=checkGrid(arr,row,col,rcv,6,9,3,6,8);
    }else if((6<=row && row<9)&& (6<=col && col<9)){
        flag=checkGrid(arr,row,col,rcv,6,9,6,9,9);
    }
    return flag;
}

public static boolean checkRow(int[][] arr, int row,int col, int rcv){
    for (int i=0;i<9;i++){
        if(i!=row && i!=col){
            if(arr[row][i]==rcv){
                System.out.println("Row: Row: "+row+" "+"col: "+i+" Value: "+arr[row][i]);
                return true;
            }
        }
    }
    return false;
}
public static boolean checkCol(int[][] arr,int row, int col, int rcv){
    for (int i=0;i<9;i++){
        if(i!=col && i!=row){
            if(arr[i][col]==rcv){
                System.out.println("Column: Row: "+row+" "+"col: "+i+" Value: "+arr[i][col]);
                return true;
            }
        }
    }
    return false;
}
public static boolean checkGrid(int[][] arr, int row, int col, int rcv, int rowStart, int rowEnd, int colStart, int colEnd,int grid){
    for(int i=rowStart;i<rowEnd;i++) {
        for (int j = colStart; j < colEnd; j++) {
            if(i!=row && j!=col){
                if(arr[i][j]==rcv){
                    System.out.println("Grid: "+grid+" "+"Row: "+row+" "+"col: "+i+" Value: "+arr[row][i]+" ");
                    return true;
                }
            }
        }
    }
    return false;
}
public static void assignFunction(int arr[][]){

    arr[0][1]=5;arr[3][1]=4;arr[6][5]=7;
    arr[0][3]=7;arr[3][3]=9;arr[6][7]=1;
    arr[0][4]=8;

    arr[1][0]=9;arr[2][0]=2;arr[4][3]=5;arr[5][2]=2;arr[7][0]=4;arr[8][0]=1;
    arr[1][2]=8;arr[2][1]=7;arr[4][5]=2;arr[5][5]=3;arr[7][1]=3;arr[8][2]=9;
    arr[1][3]=2;arr[2][2]=4;arr[4][7]=9;arr[5][6]=1;arr[7][6]=9;arr[8][3]=3;
    arr[1][4]=3;arr[2][3]=6;arr[4][8]=8;arr[5][8]=7;arr[7][5]=5;
    arr[1][6]=7;arr[2][4]=1;
    arr[1][7]=5;arr[2][7]=3;
    arr[1][8]=6;arr[2][8]=9;
    /*

    arr[0][0]=3; arr[1][0]=9;arr[2][0]=2;arr[3][0]=8;arr[4][0]=7;
    arr[0][1]=5; arr[1][1]=1;arr[2][1]=7;arr[3][1]=4;arr[4][1]=6;
    arr[0][2]=6; arr[1][2]=8;arr[2][2]=4;arr[3][2]=3;arr[4][2]=1;
    arr[0][3]=7; arr[1][3]=2;arr[2][3]=6;arr[3][3]=9;arr[4][3]=5;
    arr[0][4]=8; arr[1][4]=3;arr[2][4]=1;arr[3][4]=7;arr[4][4]=4;
    arr[0][5]=9; arr[1][5]=4;arr[2][5]=5;arr[3][5]=1;arr[4][5]=2;
    arr[0][6]=4; arr[1][6]=7;arr[2][6]=8;arr[3][6]=5;arr[4][6]=3;
    arr[0][7]=2; arr[1][7]=5;arr[2][7]=3;arr[3][7]=6;arr[4][7]=9;
    arr[0][8]=1; arr[1][8]=6;arr[2][8]=9;arr[3][8]=2;arr[4][8]=8;

    arr[5][0]=5;arr[6][0]=6;arr[7][0]=4;arr[8][0]=1;
    arr[5][1]=9;arr[6][1]=8;arr[7][1]=3;arr[8][1]=2;
    arr[5][2]=2;arr[6][2]=5;arr[7][2]=7;arr[8][2]=9;
    arr[5][3]=8;arr[6][3]=4;arr[7][3]=1;arr[8][3]=3;
    arr[5][4]=6;arr[6][4]=9;arr[7][4]=2;arr[8][4]=5;
    arr[5][5]=3;arr[6][5]=7;arr[7][5]=6;arr[8][5]=8;
    arr[5][6]=1;arr[6][6]=2;arr[7][6]=9;arr[8][6]=6;
    arr[5][7]=4;arr[6][7]=1;arr[7][7]=8;arr[8][7]=7;
    arr[5][8]=7;arr[6][8]=3;arr[7][8]=5;arr[8][8]=4;
*/
}
}