package $package$

import com.typesafe.scalalogging.LazyLogging
import org.rogach.scallop._

object Main extends LazyLogging {

  class Conf(arguments: Seq[String]) extends ScallopConf(arguments) {
    //val apples = opt[Int](required = true)
    //val bananas = opt[Int]()
    val expression: ScallopOption[String] = trailArg[String]()
    verify()
  }

  def main(args: Array[String]): Unit = {

    val conf = new Conf(args)
    conf.expression.toOption match {
      case Some(input) => println(Parse(input))
      case _           => conf.printHelp()
    }

  }

}
