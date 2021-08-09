package com.evolution.bootcamp.assignment.poker.domain

import com.evolution.bootcamp.assignment.poker.domain.card._
import com.evolution.bootcamp.assignment.poker.domain.handval.find.HighCardFinder
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class FindHighCardHandValuesTest() extends AnyWordSpec with Matchers{
  "Find HIGH CARD hand values" when {
    "cards: As-3c" should {
      "return cards: As" in {
        val cards = Vector(Card(Ace, Spades), Card(Three, Cubs))

        val exec = HighCardFinder(cards)
        val expectedResult = Vector(Card(Ace, Spades))

        exec mustBe expectedResult
      }
    }
    "cards: 5s-3c" should {
      "return cards: 5s" in {
        val cards = Vector(Card(Five, Spades), Card(Three, Cubs))

        val exec = HighCardFinder(cards)
        val expectedResult = Vector(Card(Five, Spades))

        exec mustBe expectedResult
      }
    }
    "cards: 8s-9c" should {
      "return cards: 9c" in {
        val cards = Vector(Card(Eight, Spades), Card(Nine, Cubs))

        val exec = HighCardFinder(cards)
        val expectedResult = Vector(Card(Nine, Cubs))

        exec mustBe expectedResult
      }
    }
    "cards: Ks-Ac" should {
      "return cards: Ac" in {
        val cards = Vector(
          Card(King, Spades), Card(Ace, Cubs) )

        val exec = HighCardFinder(cards)
        val expectedResult = Vector(Card(Ace, Cubs))

        exec mustBe expectedResult
      }
    }
    "cards: As-3c-4d-3d-2s-Ks-Ac" should {
      "return As and Ac" in {
        val cards = Vector(
          Card(Ace, Spades), Card(Ace, Cubs),
          Card(Four, Diamonds), Card(Three, Diamonds),
          Card(Two, Spades), Card(King, Spades),
          Card(Queen, Spades))

        val exec = HighCardFinder(cards)
        val expectedResult = Vector(Card(Ace, Spades), Card(Ace, Cubs))

        exec mustBe expectedResult
      }
    }
    "cards: 3c-3d-3h-2h-2s-2c" should{
      "return 3c-3d-3h" in{
         val cards = Vector(
          Card(Three, Cubs), Card(Three, Diamonds),
          Card(Three, Hearts), Card(Two, Hearts),
          Card(Two, Spades), Card(Two, Cubs))

        val exec = HighCardFinder(cards)
        val expectedResult = Vector(Card(Three, Cubs), Card(Three, Diamonds),
          Card(Three, Hearts))

        exec mustBe expectedResult
      }
    }
  }
}
//"result always is in domain of cards"

