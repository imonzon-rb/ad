package com.evolution.bootcamp.assignment.poker.domain.handval.find
import com.evolution.bootcamp.assignment.poker.domain.card.Card

object HighCardFinder extends (Vector[Card] => Vector[Card]){
  override def apply(cards: Vector[Card]): Vector[Card]= {
    val highestRank = cards.sorted(Card.orderingDescendent).head
    cards.filter(_.rank == highestRank.rank)
  }
}
