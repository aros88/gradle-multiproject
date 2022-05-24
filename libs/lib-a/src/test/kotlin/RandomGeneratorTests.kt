import com.example.liba.RandomGenerator
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RandomGeneratorTests {
  @Test
  fun `random generator`() {
    val n: Int = RandomGenerator().createRandomInt(10)

    assertTrue(n <= 10)
  }
}