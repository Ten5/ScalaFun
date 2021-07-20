package example

import domain.isEmptyOrInsert

case class Item(
    itemId: Int,
    itemName: String,
    itemCategory1Id: Int,
    itemTraitId: Int,
    itemQualityId: Int,
    isChampionPoint: Boolean,
    levelMin: Int,
    levelMax: Int,
    masterWritMin: Int,
    masterWritMax: Int,
    amountMin: Int,
    amountMax: Int,
    priceMin: Int,
    priceMax: Int
) {

  // Item String
  def getItemString: String = {
    val itemString: String =
      s"ItemID=${isEmptyOrInsert(itemId)}&ItemNamePattern=${isEmptyOrInsert(itemName)}"
    val itemCategory1IdString: String =
      s"ItemCategory1ID=${isEmptyOrInsert(itemCategory1Id)}"
    val itemTraitIdString: String =
      s"ItemTraitID=${isEmptyOrInsert(itemTraitId)}"
    val itemQualityIdString: String =
      s"ItemQualityID=${isEmptyOrInsert(itemQualityId)}"

    s"$itemString&$itemCategory1IdString&$itemTraitIdString&$itemQualityIdString"
  }

  // Item Level String
  def getItemLevelString: String = {
    val isChampionPointString: String = s"IsChampionPoint=$isChampionPoint"
    val levelMinString: String = s"LevelMin=${isEmptyOrInsert(levelMin)}"
    val levelMaxString: String = s"LevelMax=${isEmptyOrInsert(levelMax)}"

    s"$isChampionPointString&$levelMinString&$levelMaxString"
  }

  // Item Master Writ Voucher String
  def getItemMasterWritString: String = {
    val masterWritMinString: String =
      s"MasterWritVoucherMin=${isEmptyOrInsert(masterWritMin)}"
    val masterWritMaxString: String =
      s"MasterWritVoucherMax=${isEmptyOrInsert(masterWritMax)}"

    s"$masterWritMinString&$masterWritMaxString"
  }

  // Item Quantity String
  def getItemQuantityString: String = {
    val amountMinString: String =
      s"AmountMin=${isEmptyOrInsert(amountMin)}"
    val amountMaxString: String =
      s"AmountMax=${isEmptyOrInsert(amountMax)}"
    val priceMinString: String = s"PriceMin=${isEmptyOrInsert(priceMin)}"
    val priceMaxString: String = s"PriceMax=${isEmptyOrInsert(priceMax)}"

    s"$amountMinString&$amountMaxString&$priceMinString&$priceMaxString"
  }
}

object Item {

  def apply(
      itemId: Int = 0,
      itemName: String = "",
      itemCategory1Id: Int = 0,
      itemTraitId: Int = 0,
      itemQualityId: Int = 0,
      isChampionPoint: Boolean = false,
      levelMin: Int = 0,
      levelMax: Int = 0,
      masterWritMin: Int = 0,
      masterWritMax: Int = 0,
      amountMin: Int = 0,
      amountMax: Int = 0,
      priceMin: Int = 0,
      priceMax: Int = 0
  ): Item =
    new Item(
      itemId,
      itemName,
      itemCategory1Id,
      itemTraitId,
      itemQualityId,
      isChampionPoint,
      levelMin,
      levelMax,
      masterWritMin,
      masterWritMax,
      amountMin,
      amountMax,
      priceMin,
      priceMax
    )
}
