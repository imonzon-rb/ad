package com.evolution.bootcamp.assignment.poker.domain.card

sealed trait Suite extends Ordered[Suite]{
  val name: String
  val weight: Int

  override def toString: String = name
  override def compare(that: Suite): Int = weight compare that.weight
}
object Suite{
  implicit def ordering[A <: Suite]: Ordering[A] =
    (s1, s2) => s1 compare s2
}

case object Spades extends Suite {
  override val name: String = "Spades"
  override val weight: Int = 4
}
case object Hearts extends Suite {
  override val name: String = "Hearts"
  override val weight: Int = 3
}
case object Diamonds extends Suite {
  override val name: String = "Diamonds"
  override val weight: Int = 2
}
case object Cubs extends Suite {
  override val name: String = "Cubs"
  override val weight: Int = 1
}

