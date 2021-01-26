package net.blogjava.welldoer

import java.text.SimpleDateFormat
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LoggingEventTest {
    @Test
    fun `timestamp checking`() {
        val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-01-26 13:24:05").time
        val result = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp)
        assertEquals("2021-01-26 13:24:05", result)
    }

    @Test
    fun `sample logger output`() {
        val timestampL = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-01-26 14:31:08").time
        val message = "output message"
        val loggerName = "abc"

        assertTrue(
            "LoggingEvent\\(timestamp=.*, level=[0-9]*, message=.*, threadName=.*, threadId=[0-9]*, loggerName=.*\\)".toRegex().matches(LoggingEvent(timestampL, 0, message, loggerName).toString())
        )
        assertEquals(
            "LoggingEvent(timestamp=Tue Jan 26 14:31:08 CST 2021, level=0, message=output message, threadName=, threadId=0, loggerName=abc)",
            LoggingEvent(timestampL, 0, message, loggerName).toString()
        )
    }

}