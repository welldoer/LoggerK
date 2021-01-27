package net.blogjava.welldoer.appender

import io.mockk.confirmVerified
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import net.blogjava.welldoer.LoggingEvent
import kotlin.test.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class ConsoleAppenderTest {
    @Test
    fun `simple output`(@RelaxedMockK mockLoggingEvent: LoggingEvent) {
        val consoleAppender = ConsoleAppender()
        consoleAppender.append(mockLoggingEvent)

        verify(exactly = 1) { mockLoggingEvent.toString() }

        confirmVerified(mockLoggingEvent)
    }
}