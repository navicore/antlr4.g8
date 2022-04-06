package $package$

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import $package$.antlr4._

class $grammar$VisitorSpec extends AnyFlatSpec with Matchers {

  "addition should" should "add" in {
    Parse("1 + 2") should be(ExprResult(Some(3)))
  }

  "multiplication" should "multiply" in {
    Parse("2 * 3") should be(ExprResult(Some(6)))
  }

  "1 ^ 2" should "fail" in {
    Parse("1 ^ 2") should be(ExprResult(None))
  }

}
