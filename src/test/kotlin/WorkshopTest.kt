import org.example.Product
import kotlin.test.Test
import kotlin.test.assertEquals
import org.example.celsiusToFahrenheit
import org.example.calculateTotalElectronicsPriceOver500
import org.example.countElectronicsOver500

class WorkshopTest {

    // --- Tests for Workshop #1: Unit Converter ---

    // celsius input: 20.0
    // expected output: 68.0

    private val products = listOf(
        Product("Laptop", 35000.0, "Electronics"),
        Product("Smartphone", 25000.0, "Electronics"),
        Product("T-shirt", 450.0, "Apparel"),
        Product("Monitor", 7500.0, "Electronics"),
        Product("Keyboard", 499.0, "Electronics"),  // ไม่ถึง 500 → ไม่นับ
        Product("Jeans", 1200.0, "Apparel"),
        Product("Headphones", 1800.0, "Electronics")
    )

    @Test
    fun `test celsiusToFahrenheit with positive value`() {
        // Arrange: ตั้งค่า input และผลลัพธ์ที่คาดหวัง
        val celsiusInput = 20.0
        val expectedFahrenheit = 68.0

        // Act: เรียกใช้ฟังก์ชันที่ต้องการทดสอบ
        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)

        // Assert: ตรวจสอบว่าผลลัพธ์ที่ได้ตรงกับที่คาดหวัง
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "20°C should be 68°F")
    }

    // celsius input: 0.0
    // expected output: 32.0
    @Test
    fun `test celsiusToFahrenheit with zero`() {

    }

    // celsius input: -10.0
    // expected output: 14.0
    @Test
    fun `test celsiusToFahrenheit with negative value`() {

    }

    // test for kilometersToMiles function
    // kilometers input: 1.0
    // expected output: 0.621371
    @Test
    fun `test kilometersToMiles with one kilometer`() {

    }



    // --- Tests for Workshop #1: Unit Converter End ---

    // --- Tests for Workshop #2: Data Analysis Pipeline ---
    // ทำการแก้ไขไฟล์ Workshop2.kt ให้มีฟังก์ชันที่ต้องการทดสอบ
    // เช่น ฟังก์ชันที่คำนวณผลรวมราคาสินค้า Electronics ที่ราคา > 500 บาท
    // ในที่นี้จะสมมุติว่ามีฟังก์ชันชื่อ calculateTotalElectronicsPriceOver500 ที่รับ List<Product> และคืนค่า Double
    // จงเขียน test cases สำหรับฟังก์ชันนี้ โดยตรวจสอบผลรวมราคาสินค้า Electronics ที่ราคา > 500 บาท
    // 🚨
    @Test
    fun `test calculateTotalElectronicsPriceOver500 return correct sum`() {
        //Arrange: ตั้งค่า input และผลลัพธ์ที่คาดหวัง

        val expectedSumprice = products.filter { it.category == "Electronics" && it.price >500 }.map { it.price }.sumOf {it}

        // Act: เรียกใช้ฟังก์ชันที่ต้องการทดสอบ
        val actualSumprice = calculateTotalElectronicsPriceOver500(products)

        // Assert: ตรวจสอบว่าผลลัพธ์ที่ได้ตรงกับที่คาดหวัง
        assertEquals(expectedSumprice, actualSumprice)
    }


    // จงเขียน test cases เช็คจำนวนสินค้าที่อยู่ในหมวด 'Electronics' และมีราคามากกว่า 500 บาท
    // 🚨
    @Test
    fun `test countElectronicsOver500 returns correct count`() {
        // Arrange
        val products = listOf(
            Product("Laptop", 35000.0, "Electronics"),
            Product("Smartphone", 25000.0, "Electronics"),
            Product("T-shirt", 450.0, "Apparel"),
            Product("Monitor", 7500.0, "Electronics"),
            Product("Keyboard", 499.0, "Electronics"),  // ไม่ถึง 500 → ไม่นับ
            Product("Jeans", 1200.0, "Apparel"),
            Product("Headphones", 1800.0, "Electronics")
        )

        val expectedCount = products.count { it.category == "Electronics" && it.price >500 }

        // Act
        val actualCount = countElectronicsOver500(products)

        // Assert
        assertEquals(expectedCount, actualCount, "ควรนับสินค้า Electronics ที่ราคา > 500 ได้ถูกต้อง")
    }

    // --- Tests for Workshop #2: Data Analysis Pipeline End ---
}