package com.evolution.bootcamp.assignment.poker.domain.handval

import com.evolution.bootcamp.assignment.poker.domain.card.Card

sealed trait HandValue

final case class HighCard(card: Card) extends HandValue
final case class Pair(card1: Card, card2: Card) extends HandValue with Ordered[Pair]{
  override def compare(that: Pair): Int = (this.maxFirst, that.maxFirst) match {
    case ((c1,c2),(c3, c4)) => {
      val difference = c1 compare c3
      if (difference == 0) c2 compare c4
      else difference
    }
  }

  private def maxFirst:(Card,Card) = if (card1 > card2) (card1,card2) else (card2,card1)
}
object Pair{
//  implicit val orderingDesc: Ordering[Pair] = (p1,p2) => - (p1 compare p2)
}

object HandValue extends Ordering[HandValue] {
  def indexOf(hand: HandValue): Int = hand match {
    case HighCard(_) => 0
    case Pair(_,_) => 1
  }

  override def compare(x: HandValue, y: HandValue): Int =
    (x, y) match {
      case (hc1: HighCard, hc2: HighCard) => hc1.card compare hc2.card
//      case (pair1: Pair, pair2: Pair) => comparePair(pair1, pair2)
      case (_, _) => indexOf(x) - indexOf(y)
    }

}

