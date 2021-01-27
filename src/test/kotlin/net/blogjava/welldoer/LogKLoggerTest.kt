package net.blogjava.welldoer

import io.mockk.confirmVerified
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import net.blogjava.welldoer.appender.ConsoleAppender
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.Test

@ExtendWith(MockKExtension::class)
class LogKLoggerTest {
    @Test
    fun `default msg output`(@RelaxedMockK mockConsoleAppender: ConsoleAppender) {
        val logKLogger = LogKLogger(mockConsoleAppender)
        logKLogger.trace("trace info")
        logKLogger.debug("debug info")
        logKLogger.info("info")
        logKLogger.warn("warn info")
        logKLogger.error("error info")

        verify(exactly = 3) { mockConsoleAppender.append(any())}

        confirmVerified(mockConsoleAppender)
    }
}