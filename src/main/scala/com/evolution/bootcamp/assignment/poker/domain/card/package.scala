package com.evolution.bootcamp.assignment.poker.domain

package object card {
  implicit class IntExtension(val num: Int){
    def `<||>`(other: => Int): Int =
      if (num == 0) other else num
  }
}
