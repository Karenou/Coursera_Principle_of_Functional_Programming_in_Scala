package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
//    println("Pascal's Triangle")
//    for (row <- 0 to 10) {
//      for (col <- 0 to row)
//        print(s"${pascal(col, row)} ")
//      println()
//    }
//
//    println("test balance")
//    if (balance("())(".toList))
//      println("True")
//    else
//      println("False")

    println(countChange(300,List(500,5,50,100,20,200,10)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    // first and second row
    if (r <= 1) 1
    // left and right edges
    else if ((c == 0) || (c == r)) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def loop(chars_list: List[Char], pair: Int) : Boolean  = {
      if (pair < 0 ) false
      else if (pair > 0 && chars_list.isEmpty) false
      else if (chars_list.isEmpty && pair == 0) true
      else if (chars_list.head == '(')
        loop(chars_list.tail, pair + 1)
      else if (chars_list.head == ')')
        loop(chars_list.tail, pair - 1)
      else
        loop(chars_list.tail, pair)
    }

    loop(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    val coin = coins.sorted
    if (coin.isEmpty || money <= 0 ) 0
    else if ((money - coin.head == 0)) 1
    else
      countChange(money - coin.head, coin) +
        countChange(money, coin.tail)
  }
}
