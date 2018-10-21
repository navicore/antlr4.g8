package $package$

import com.typesafe.scalalogging.LazyLogging
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import $package$.antlr.{$grammar$Lexer, $grammar$Parser}
import $package$.antlr4.{$grammar$VisitorImpl, Expr}

object Parse extends LazyLogging {

  val arithmeticVisitor = new $grammar$VisitorImpl()

  def apply(input: String): Expr = {

    logger.debug("Evaluating expression: " + input)

    val charStream = CharStreams.fromString(input)
    val lexer = new $grammar$Lexer(charStream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new $grammar$Parser(tokens)
    arithmeticVisitor.visit(parser.expr())
  }

}
