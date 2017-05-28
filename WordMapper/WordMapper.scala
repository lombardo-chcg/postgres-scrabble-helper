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
val wordsWithFriendsPointsMap = Map(
  "a" -> 1,
  "b" -> 4,
  "c" -> 4,
  "d" -> 2,
  "e" -> 1,
  "f" -> 4,
  "g" -> 3,
  "h" -> 3,
  "i" -> 1,
  "j" -> 10,
  "k" -> 5,
  "l" -> 2,
  "m" -> 4,
  "n" -> 2,
  "o" -> 1,
  "p" -> 4,
  "q" -> 10,
  "r" -> 1,
  "s" -> 1,
  "t" -> 1,
  "u" -> 2,
  "v" -> 5,
  "w" -> 4,
  "x" -> 8,
  "y" -> 3,
  "z" -> 10
)
val chars = """[a-zA-Z]+""".r

for (word <- Source.fromFile(inputFile).getLines.filter(_.matches(chars.toString)).map(_.toLowerCase)) {
  val letterList = word.split("")
  val canonical = letterList.sorted.mkString("")
  val scrabblePoints = letterList.map(l => scrabblePointsMap(l)).foldLeft(0)(_ + _)
  val wordsWithFriendsPoints = letterList.map(l => wordsWithFriendsPointsMap(l)).foldLeft(0)(_ + _)

  fileWriter.write(s"""$word,$canonical,$scrabblePoints,$wordsWithFriendsPoints\n""")
}

fileWriter.close
