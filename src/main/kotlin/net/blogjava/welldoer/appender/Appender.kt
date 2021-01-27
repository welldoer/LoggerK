package net.blogjava.welldoer.appender

import net.blogjava.welldoer.LoggingEvent

interface Appender {
    fun append(event: LoggingEvent)
}