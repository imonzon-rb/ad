package com.evolution.bootcamp.assignment.poker.domain.card

sealed trait Rank extends Ordered[Rank]{
  val name: String
  val weight: Int

  override def toString: String = name
  override def compare(that: Rank): Int = weight compare that.weight
}

object Rank {
  implicit def orderingDesc[A <: Rank]: Ordering[A] =
    (r1, r2) => - (r1 compare r2)
}

final case object Two extends Rank {
  override val name: String = "Two"
  override val weight: Int = 2
}

final case object Three extends Rank {
  override val name: String = "Three"
  override val weight: Int = 3
}

final case object Four extends Rank {
  override val name: String = "Four"
  override val weight: Int = 4
}

final case object Five extends Rank {
  override val name: String = "Five"
  override val weight: Int = 5
}

final case object Six extends Rank {
  override val name: String = "Six"
  override val weight: Int = 6
}

final case object Seven extends Rank {
  override val name: String = "Seven"
  override val weight: Int = 7
}

final case object Eight extends Rank {
  override val name: String = "Eight"
  override val weight: Int = 8
}

final case object Nine extends Rank {
  override val name: String = "Nine"
  override val weight: Int = 9
}

final case object Ten extends Rank {
  override val name: String = "Ten"
  override val weight: Int = 10
}

final case object Jack extends Rank {
  override val name: String = "Jack"
  override val weight: Int = 11
}

final case object Queen extends Rank {
  override val name: String = "Queen"
  override val weight: Int = 12
}

final case object King extends Rank {
  override val name: String = "King"
  override val weight: Int = 13
}

final case object Ace extends Rank {
  override val name: String = "Ace"
  override val weight: Int = 14
}