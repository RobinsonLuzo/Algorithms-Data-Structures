# quicksort.py

def quickSort(array, start, end):
    if start < end:
        # pi is "partitioning index"
        pi = partition(array, start, end)

        # Elements are seperately sorted, leftmost first then right
        quickSort(array, start, pi - 1)
        quickSort(array, pi + 1, end)


def partition(array, start, end):
    """ For this implementation the last element is the pivot """
    indx = (start - 1)
    pivot = array[end]

    for elem in range(start, end):
        # If element in that place is less than the pivot, swap positions with pivot
        if array[elem] <= pivot:
            indx += 1
            array[indx], array[elem] = array[elem], array[indx]

    array[indx + 1], array[end] = array[end], array[indx + 1]
    return (indx + 1)
