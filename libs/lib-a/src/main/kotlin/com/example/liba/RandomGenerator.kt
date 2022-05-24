package com.example.liba

import kotlin.random.Random

class RandomGenerator {
  fun createRandomInt(n: Int): Int {
    return Random.nextInt(n)
  }
}
