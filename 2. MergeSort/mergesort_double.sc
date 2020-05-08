// mergesort_double.sc
// This is not only intended as a Double version but also more optimised to make use of match

def merge(left: List[Double], right: List[Double]): List[Double] = (left, right) match {
  // Remember: the result of merging an empty and non-empty list is always going to be the non-empty list
  case (Nil, _) => right // If left is empty then return right
  case (_, Nil) => left  // Likewise, if right is empty return left

    // Below reads effectively as ( leftHead Cons(leftTail), rightHead Cons(rightTail) )
  case (leftHead :: leftTail, rightHead :: rightTail) =>
    // We check if leftHead or rightHead is smaller and add the result to the front of a list
    // If leftHead is smaller than leftHead Cons( result of merge(remainder of left list, right list) )
    if(leftHead < rightHead) leftHead :: merge(leftTail, right)
      // Otherwise rightHead Cons( result of merge( left list, remainder of right list) )
    else rightHead :: merge(left, rightTail)
}


def mergeSortDouble(lst: List[Double]): List[Double] = lst match {
  case Nil => lst // An empty list is already sorted so return it
  case head :: Nil => lst // If lst has only one item (a head Cons Nil) return it as it is a primitive number

    // In any other case We need to break this list into 2 pieces of both equal size
    // Then we shall sort these and merge them back together using merge()
  case _ =>
    val middle = lst.length / 2
    val (left, right) = lst.splitAt(middle)
    merge(mergeSortDouble(left), mergeSortDouble(right))
}


//val t1 = System.nanoTime
// Test input
mergeSortDouble(List(33,44,22,-10,99))
//println("Duration: ", System.nanoTime - t1)