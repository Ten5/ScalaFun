package example

import domain.Ternary

case class TtcUrl(baseUrl: String, searchType: String) {

  def constructUrl(item: Item): String =
    s"$baseUrl/" +
      s"$searchType&" +
      s"${item.getItemString}&" +
      s"${item.getItemLevelString}&" +
      s"${item.getItemMasterWritString}&" +
      s"${item.getItemQuantityString}"
}

object TtcUrl {

  // Base URL
  final val baseLink: String = "https://eu.tamrieltradecentre.com/pc/Trade"
  final val searchType: String = "SearchResult?SearchType=Sell"

  def apply(searchField: String): TtcUrl =
    new TtcUrl(baseLink, searchField.isBlank ?? (searchType, searchField))
}
