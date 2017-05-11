package Calc;
public class Stack  {
 
   private String[] tab;
   private int firstFree;
 
    public Stack(int MaxSize) {
        tab = new String[MaxSize];
        firstFree = 0;
    }
 
    public int getMaximumStackSize() {
        return tab.length;
    }
 
    public boolean isEmpty() {
        if (firstFree == 0) {
            return true;
        } else
            return false;
    }
 
    public int getSize() {
        return firstFree;
    }
 
    public  void push(String E) throws ArrayIndexOutOfBoundsException {
        if (firstFree < tab.length) {
            tab[firstFree] = E;
            firstFree++;
 
        } else {
            throw new ArrayIndexOutOfBoundsException(
                    "Stack overflow. Operation failed.");
        }
    }
 
    public  String pop() throws IndexOutOfBoundsException {
        if (firstFree <= 0) {
            throw new IndexOutOfBoundsException(
                    "Stack is empty. Operation failed.");
        }
 
        String temp = tab[firstFree - 1];
        firstFree--;
        return temp;
    }
    
   public String top() throws IndexOutOfBoundsException{
	   if (firstFree <= 0) {
           throw new IndexOutOfBoundsException(
                   "Stack is empty. Operation failed.");
       }
	   
	   String temp = tab[firstFree - 1];
	   return temp;
    }
  
   public void clear() {
        for (int i = 0; i < firstFree; i++) {
            tab[i] = ""; 
        } 
        firstFree = 0;
    }
}