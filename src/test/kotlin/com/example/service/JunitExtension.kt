package com.example.service

import io.mockk.MockKAnnotations
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestInstancePostProcessor

class JunitExtension : TestInstancePostProcessor {
    override fun postProcessTestInstance(testInstance: Any, context: ExtensionContext) {
        MockKAnnotations.init(testInstance)
    }
}

@ExtendWith(JunitExtension::class)
annotation class Nossa