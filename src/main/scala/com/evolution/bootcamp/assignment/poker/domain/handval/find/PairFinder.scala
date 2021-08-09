package com.evolution.bootcamp.assignment.poker.domain.handval.find
import com.evolution.bootcamp.assignment.poker.domain.card.Card
import com.evolution.bootcamp.assignment.poker.domain.handval.Pair

object PairFinder extends (Vector[Card] => Vector[Pair]){
  override def apply(cards: Vector[Card]): Vector[Pair] =
    cards
      .groupBy(c => c.rank)
      .iterator
      .filter{case (_, v) => v.size >= 2}
      .map(_._2)
      .flatMap( cards => cards
        .combinations(2)
        .collect{case Seq(x, y) => (x, y) }
        .toVector)
      .map{ case (c1, c2) => Pair(c1,c2) }
      .toVector
      .sorted
}
