// mergesort.sc

def merge(left: List[Int], right: List[Int]): List[Int] =
  (left, right) match {
    case (_, Nil) => left
    case (Nil, _) => right
    case (leftHead :: leftTail, rightHead :: rightTail) =>
      if (leftHead < rightHead) leftHead :: merge(leftTail, right)
      else rightHead :: merge(left, rightTail)
  }

def mergeSort(list: List[Int]): List[Int] = {
  if (list.length < 2) list // if single element return
  else {
    val middle = list.length / 2
    val (left, right) = list.splitAt(middle)
    merge(mergeSort(left), mergeSort(right))
  }
}

val t1 = System.nanoTime
// Test input
mergeSort(List(33,44,22,-10,99))

println("Duration: ", System.nanoTime - t1)
