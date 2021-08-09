package com.evolution.bootcamp.assignment.poker.domain

import com.evolution.bootcamp.assignment.poker.domain.card.{Card, Cubs, Diamonds, Five, Four, Hearts, King, Ten, Three}
import com.evolution.bootcamp.assignment.poker.domain.handval.Pair
import com.evolution.bootcamp.assignment.poker.domain.handval.find.PairFinder
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.wordspec.AnyWordSpec

final class FindPairHandValueTest extends AnyWordSpec {
  "Find PAIR hand values " when {
    "cards: Tc-Kh-Kc-3c-5h-4d" should{
      "return cards: (Kc-Kh)" in{
        val cards = Vector(Card(Ten, Cubs), Card(King, Hearts),
          Card(King, Cubs), Card(Three, Cubs), Card(Five, Hearts),
          Card(Four, Diamonds))

        val exec = PairFinder(cards)
        val expectedResult :Vector[Pair] =
          Vector(Pair(Card(King, Cubs), Card(King, Hearts)))

        exec mustBe expectedResult
      }
    }
    "cards: Tc-Kh-Kc-3c-5h-4d-5d" should{
      "return cards: (Kc-Kh)-(5d-5h)" in{
        val cards = Vector(Card(Ten, Cubs), Card(King, Hearts),
          Card(King, Cubs), Card(Three, Cubs), Card(Five, Hearts),
          Card(Four, Diamonds), Card(Five, Diamonds))

        val exec = PairFinder(cards)
        val expectedResult :Vector[Pair] =
          Vector(Pair(Card(King, Cubs), Card(King, Hearts)),
            Pair(Card(Five, Diamonds), Card(Five, Hearts)))

        exec mustBe expectedResult
      }
    }
  }
}
