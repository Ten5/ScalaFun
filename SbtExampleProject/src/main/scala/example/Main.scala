package example

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

import scala.jdk.CollectionConverters.CollectionHasAsScala

object Main extends App {

  // Variables
  val searchType: String = ""
  val itemId = 17927
  val itemName: String = "Chromium+Grains"
  val itemCategory1Id: Int = 0
  val itemTraitId: Int = 0
  val itemQualityId: Int = 0
  val isChampionPoint: Boolean = false
  val levelMin: Int = 0
  val levelMax: Int = 0
  val masterWritMin: Int = 0
  val masterWritMax: Int = 0
  val amountMin: Int = 0
  val amountMax: Int = 0
  val priceMin: Int = 0
  val priceMax: Int = 14000

  val item: Item = Item(
    itemId = 17927,
    itemName = "Chromium+Grains",
    priceMax = 14000
  )

  val url = TtcUrl(searchType).constructUrl(item)

  val doc: Document = Jsoup.connect(url).get()
  println(doc.title)

  val tradeListTable: Elements = doc.select(".trade-list-table")
//  val traders: Elements = doc.select(".hidden-xs")

  for (trades <- tradeListTable.asScala)
    yield println(trades.text)
}
