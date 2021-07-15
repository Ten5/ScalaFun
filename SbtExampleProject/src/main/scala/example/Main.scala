package example

import org.jsoup.Jsoup

object Main extends App {

  val doc = Jsoup.connect("https://eu.tamrieltradecentre.com/pc/Trade").get()
  println(doc)
}
