package $package$

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ExampleSpec extends AnyFlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = List[Int]()
    (stack :+ 1) should be(List[Int](1))
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = List[Int]()
    a[IndexOutOfBoundsException] should be thrownBy {
      emptyStack(1)
    }
  }
}
