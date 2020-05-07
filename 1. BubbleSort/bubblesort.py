# bubblesort.py

def bubbleSort(array):
    n = len(array)

    # Traverse all the array elements
    for i in range(n-1, 0, -1):


        for j in range(i):
            if array[j] > array[j + 1]:
                array[j], array[j + 1] = array[j + 1], array[j]
