// quicksort.sc

def quickSort(lst: List[Double]): List[Double] = lst match {
  /* Sorts by picking a pivot point then splitting values into sublists.
  * Less than pivot number goes to the left, greater goes right.
  * An empty list, or list of just one item, is returned as is
  *
  */
  case Nil => lst
  case head :: Nil => lst
  case pivot :: tail => {
    // Note: partition() is an already built-in function
    val (less, greater) = tail.partition(_ < pivot)
    // Remember ::: joins two lists into one
    quickSort(less) ::: pivot :: quickSort(greater)
  }
}

// Test input with random numbers
quickSort(List.fill(50)(math.random))