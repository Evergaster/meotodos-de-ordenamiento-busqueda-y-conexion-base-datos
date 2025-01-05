public class QuickSort {
    public static void OrdenarRapido(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            int pivotIndex = Partition(array, inicio, fin);
            OrdenarRapido(array, inicio, pivotIndex - 1);
            OrdenarRapido(array, pivotIndex + 1, fin);
        }
    }
    
    private static int Partition(int[] array, int inicio, int fin) {
        int pivot = array[fin];
        int i = inicio - 1;
        
        for (int j = inicio; j < fin; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        int temp2 = array[i + 1];
        array[i + 1] = array[fin];
        array[fin] = temp2;
        
        return i + 1;
    }
}