package by.vision.training;

public class QuickSrt {
    public static void main(String args[]) {
        char a[] = {'s', 'e', 'r', 'b', 'm', 'a', 'z'/*, 'x', 'c', 'v', 'b', 'n', 'm'*/};
        int i;

        System.out.print("Иcxoдный массив: ");
        for(i=0; i < a.length; i++) System.out.print(a[i]+" ");

        System.out.println();

        // Отсортировать массив
        Quicksort.qsort(a);

        System.out.print("Oтcopтиpoвaнный массив: ");
        for(i=0; i < a.length; i++) System.out.print(a[i]+" ");

    }
}

class Quicksort {
    // Организовать вызов фактического метода быстрой сортировки
    static void qsort(char items[]){
        qs(items, 0, items.length-1);
    }

    // Рекурсивная версия метода быстрой сортировки символов
    private static void qs(char items[], int left, int right){
    int i, j;
    char x, y;
    i = left; j = right;
    x = items[(left+right)/2];
    System.out.println("Опорный элемент - "+x);
    do {
        while((items[i] < x) && (i < right)) i++;
        System.out.println("i-ый элемент - "+items[i]);

        while((x < items[j]) && (j > left)) j--;
        System.out.println("j-ый элемент - "+items[j]);

        if(i < j){
            y = items[i];
            items[i] = items[j];
            items[j] = y;
            i++; j--;

            System.out.println("Массив после перестановки");
            for(i=0; i < items.length; i++) System.out.print(items[i]+" ");
            System.out.println();
        }
    } while(i < j);

    System.out.println("Массив после итерации");
        for(i=0; i < items.length; i++) System.out.print(items[i]+" ");
        System.out.println();

        if(left < j) qs(items, left, j);
        if(i < right) qs(items, i, right);
    }
}



