package com.example.projecta

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*

class UtilsTests {
  @Test
  fun `tests generateUUID`() {
    val id: UUID = generateUUID()

    assertTrue(id.toString().length == 36)
  }
}
