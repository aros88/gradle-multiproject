package com.example.projectb

import com.example.projecta.generateUUID
import com.example.liba.RandomGenerator

fun main() {
  println("Project Started...")

  println("UUID generated! ${generateUUID()}")
  println("Random generated! ${RandomGenerator().createRandomInt(10)}")
}
