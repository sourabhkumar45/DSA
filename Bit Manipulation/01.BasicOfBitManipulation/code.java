// 1. You are given a number n.
// 2. Print the number produced on setting its i-th bit.
// 3. Print the number produced on unsetting its j-th bit.
// 4. Print the number produced on toggling its k-th bit.
// 5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.
// https://youtu.be/v62IKeJtj0k
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    //write your code here
    int mask = 0;
    mask = 1<<i;
    System.out.println(n | mask);
    
    mask = ~(1<<j);
    System.out.println(n & mask);
    
    mask = 1<<k;
    System.out.println(n ^ mask);
    
    mask = 1<<m;
    
    int check = n & mask;
    
    if(check==0) {
        System.out.println(false);
    } else {
        System.out.println(true);
    }
    
  }

}