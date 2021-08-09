package com.evolution.bootcamp.assignment.poker.domain.card

final case class Card(rank: Rank, suite: Suite) extends Ordered[Card]{
  val name = s"$rank of $suite"

  override def toString: String = name

  override def compare(that: Card): Int =
    - (rank compare that.rank) <||> (suite compare that.suite)
}

object Card {
 implicit val orderingDescendent: Ordering[Card] =
   (x, y) => - (x.rank compare y.rank) <||>
     (x.suite compare y.suite)
}
