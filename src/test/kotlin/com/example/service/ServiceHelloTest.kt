package com.example.service

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

//@ExtendWith(MockKExtension::class)
//@MicronautTest
//@ExtendWith(JunitExtension::class)
@Nossa
internal class ServiceHelloTest {

    @InjectMockKs
    lateinit var service: ServiceHello

    @MockK
    lateinit var service2: Service2

    @BeforeEach
    fun before() {
        MockKAnnotations.init(this)
//        service2 = mockk()
//
//        service = ServiceHello(service2)
    }

    @Test
    fun `test 1`() {
        val service = ServiceHello(Service2())

        val result = service.x()

        assertEquals("Hello", result)
    }

    @Test
    fun `test 2`() {
        val result = service.x()

        assertEquals("Hello", result)
    }

    @Test
    fun `test 3`() {
        every { service2.y() } returns "Hello"

        val result = service.y()

        assertEquals("Hello", result)
    }

}
