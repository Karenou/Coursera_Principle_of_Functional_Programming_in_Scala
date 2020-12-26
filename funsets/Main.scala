package funsets

object Main extends App {
  import FunSets._
//  println(contains(singletonSet(1), 1))

  // test union
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)
  val s = union(s1, s2)
  val t = union(s2, s3)
  val v = intersect(s, t)
  val a = diff(s, s1)

  val b = map(t, x => x*x)
  printSet(b)

}
