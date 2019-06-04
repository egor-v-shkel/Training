package by.vision.training;

public class array667 {
    public static void main(String args[]){
        int num[] = {6, 6, 7, 6};
        int count = 0;
        for (int i = 0; i < num.length - 1; i++){
            if ((i < num.length - 1 && (num[i] == num[i+1])) ^ num[i] == 7){
                count++;
            }
           /* if ( num[i] == 7){
                count++;
            }*/
        }
        System.out.print(count);
        System.out.println("New text form IDEA");
    }
}
