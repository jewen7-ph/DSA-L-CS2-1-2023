import java.util.Scanner;


public class Stack {
static int MAXSIZE = 5;       
static int[] stack = new int[MAXSIZE]; //Array Implementation     
static int top = -1;            

static boolean IsEmpty() { //To Check if the stack is empty. 

   if(top == -1)
      return true;
   else
      return false;
}
   
static boolean IsFull() { // To Check if the stack is full. 

   if(top == MAXSIZE)
      return true;
   else
      return false;
}

static int Peek() { //To display the top value of the stack
   return stack[top];
}

static int Pop() { //To remove top data.
   int data = 0;
	
   if(!IsEmpty()) {
      data = stack[top];
      top = top - 1;   
      return data;
   } else {
      System.out.println("Could not retrieve data, Stack is empty.\n");
   }
   return 0;
}

static int push(int data) { //To insert new data to the stack.

   if(!IsFull()) {
      top = top + 1;   
      stack[top] = data;
   } else {
      System.out.println("Could not insert data, Stack is full.\n");
   }
   return 0;
}

public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    
    for (int x = 0; x < MAXSIZE; x++){
        System.out.println("Enter the Element: ");
       int num = in.nextInt();
        push(num);
    }    
        
   // push items on to the stack 

   System.out.println("Element at top of the stack: \n" + Peek());
   System.out.println("Elements: \n");
   // print stack data 
   while(!IsEmpty()) {
      int data = Pop();
      System.out.println(" "+data);
   }

   System.out.println("Stack full: \n" + IsFull());
   System.out.println("Stack empty: \n" + IsEmpty());
   
 
}
}
