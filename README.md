# Guía de Algoritmos de Búsqueda, Ordenamiento y Conexión a Base de Datos

## 1. Métodos de Búsqueda

### 1.1 Búsqueda Lineal
**Descripción**: Recorre secuencialmente una lista hasta encontrar el elemento deseado.
**Característica distintiva**: Simple de implementar pero ineficiente para grandes conjuntos de datos.
**Complejidad**: O(n)

<details>
<summary>Python</summary>

```python
def busqueda_lineal(lista, objetivo):
    for i in range(len(lista)):
        if lista[i] == objetivo:
            return i
    return -1
```
</details>

<details>
<summary>Java</summary>

```java
public class BusquedaLineal {
    public static int busquedaLineal(int[] array, int objetivo) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }
}
```
</details>

<details>
<summary>C#</summary>

```csharp
public class BusquedaLineal {
    public static int BuscarLineal(int[] array, int objetivo) {
        for (int i = 0; i < array.Length; i++) {
            if (array[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }
}
```
</details>

### 1.2 Búsqueda Binaria
**Descripción**: Divide repetidamente el array ordenado por la mitad hasta encontrar el elemento.
**Característica distintiva**: Muy eficiente pero requiere que la lista esté ordenada.
**Complejidad**: O(log n)

<details>
<summary>Python</summary>

```python
def busqueda_binaria(lista, objetivo):
    izquierda, derecha = 0, len(lista) - 1
    
    while izquierda <= derecha:
        medio = (izquierda + derecha) // 2
        if lista[medio] == objetivo:
            return medio
        elif lista[medio] < objetivo:
            izquierda = medio + 1
        else:
            derecha = medio - 1
    return -1
```
</details>

<details>
<summary>Java</summary>

```java
public class BusquedaBinaria {
    public static int busquedaBinaria(int[] array, int objetivo) {
        int izquierda = 0;
        int derecha = array.length - 1;
        
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (array[medio] == objetivo) {
                return medio;
            } else if (array[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
    }
}
```
</details>

<details>
<summary>C#</summary>

```csharp
public class BusquedaBinaria {
    public static int BuscarBinario(int[] array, int objetivo) {
        int izquierda = 0;
        int derecha = array.Length - 1;
        
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (array[medio] == objetivo) {
                return medio;
            } else if (array[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
    }
}
```
</details>

## 2. Métodos de Ordenamiento

### 2.1 Bubble Sort
**Descripción**: Compara elementos adyacentes y los intercambia si están en el orden incorrecto.
**Característica distintiva**: Simple pero ineficiente para grandes conjuntos de datos.
**Complejidad**: O(n²)

<details>
<summary>Python</summary>

```python
def bubble_sort(lista):
    n = len(lista)
    for i in range(n):
        for j in range(0, n - i - 1):
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]
    return lista
```
</details>

<details>
<summary>Java</summary>

```java
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int n = array.length;
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
}
```
</details>

<details>
<summary>C#</summary>

```csharp
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
}
```
</details>

### 2.2 Quick Sort
**Descripción**: Divide el array usando un pivote y ordena recursivamente las sub-listas.
**Característica distintiva**: Muy eficiente en la práctica y usa división y conquista.
**Complejidad**: O(n log n) promedio, O(n²) peor caso

<details>
<summary>Python</summary>

```python
def quick_sort(lista):
    if len(lista) <= 1:
        return lista
    pivot = lista[len(lista) // 2]
    izquierda = [x for x in lista if x < pivot]
    medio = [x for x in lista if x == pivot]
    derecha = [x for x in lista if x > pivot]
    return quick_sort(izquierda) + medio + quick_sort(derecha)
```
</details>

<details>
<summary>Java</summary>

```java
public class QuickSort {
    public static void quickSort(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            int pivotIndex = partition(array, inicio, fin);
            quickSort(array, inicio, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, fin);
        }
    }
    
    private static int partition(int[] array, int inicio, int fin) {
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
        
        int temp = array[i + 1];
        array[i + 1] = array[fin];
        array[fin] = temp;
        
        return i + 1;
    }
}
```
</details>

<details>
<summary>C#</summary>

```csharp
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
```
</details>

## 3. Conexión con Firebase

### 3.1 Configuración inicial

<details>
<summary>Python</summary>

```python
import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore

# Inicializar Firebase
cred = credentials.Certificate("ruta/a/tu/serviceAccountKey.json")
firebase_admin.initialize_app(cred)

# Obtener instancia de Firestore
db = firestore.client()
```
</details>

<details>
<summary>Java</summary>

```java
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.FileInputStream;

public class FirebaseConfig {
    public static void inicializarFirebase() {
        try {
            FileInputStream serviceAccount = new FileInputStream("ruta/a/tu/serviceAccountKey.json");
            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
</details>