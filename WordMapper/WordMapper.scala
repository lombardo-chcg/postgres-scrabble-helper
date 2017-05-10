import scala.io.Source
import java.io._

val inputFile = "data/word_list.txt"
val outputFile = new File("data/scrabble_dictionary.csv")
val fileWriter = new BufferedWriter(new FileWriter(outputFile))

val scrabblePointsMap = Map(
  "a" -> 1,
  "b" -> 3,
  "c" -> 3,
  "d" -> 2,
  "e" -> 1,
  "f" -> 4,
  "g" -> 2,
  "h" -> 4,
  "i" -> 1,
  "j" -> 8,
  "k" -> 5,
  "l" -> 1,
  "m" -> 3,
  "n" -> 1,
  "o" -> 1,
  "p" -> 3,
  "q" -> 10,
  "r" -> 1,
  "s" -> 1,
  "t" -> 1,
  "u" -> 4,
  "v" -> 4,
  "w" -> 4,
  "x" -> 8,
  "y" -> 4,
  "z" -> 10
)
val chars = """[a-zA-Z]+""".r

for (word <- Source.fromFile(inputFile).getLines.filter(_.matches(chars.toString)).map(_.toLowerCase)) {
  val letterList = word.split("")
  val canonical = letterList.sorted.mkString("")
  val points = letterList.map(l => scrabblePointsMap(l)).foldLeft(0)(_ + _)

  fileWriter.write(s"""$word,$canonical,$points\n""")
}

fileWriter.close
