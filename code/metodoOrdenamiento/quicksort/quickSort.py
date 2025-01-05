def quickSort(list):
    if len(list) <= 1:
        return list
    pivot = list[len(list) // 2]
    izquierda = [x for x in list if x < pivot]
    medio = [x for x in list if x == pivot]
    derecha = [x for x in list if x > pivot]
    return quickSort(izquierda) + medio + quickSort(derecha)

print(quickSort([3,6,8,10,1,2,1]))