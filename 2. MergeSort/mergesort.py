# mergesort.py

def mergeSort(array):
    if len(array) < 2:
        return array
    else:
        middle = len(array)//2 # Int division to force a whole number
        left = mergeSort(array[:middle])
        right = mergeSort(array[middle:])
        return merge(left, right)


def merge(left, right):
    """ Assumes left and right are sorted arrays/lists """
    result = []
    i, j = 0, 0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    # Check for any left over items
    while i < len(left):
        result.append(left[i])
        i += 1
    while j < len(right):
        result.append(right[j])
        j += 1

    return result

