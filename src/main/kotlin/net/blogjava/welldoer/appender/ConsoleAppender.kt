package net.blogjava.welldoer.appender

import net.blogjava.welldoer.LoggingEvent

class ConsoleAppender : Appender {
    private val out = System.out

    override fun append(event: LoggingEvent) {
        out.write(event.toString().toByteArray())
    }

}
