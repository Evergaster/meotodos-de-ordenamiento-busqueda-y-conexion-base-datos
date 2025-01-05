public class BubbleSort {
    public static void OrdenarBurbuja(int[] array) {
        int n = array.Length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    for (int i = 0; i < length; i++)
    {
        Console.Write(array[i] + " ");
    }
}