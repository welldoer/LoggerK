package net.blogjava.welldoer

import java.util.*

data class LoggingEvent(val timestamp: Date, val level: Level, val message: String, val threadName: String, val threadId: Int, val loggerName: String) {
    constructor(timestamp: Long, level: Level, message: String, loggerName: String): this(Date(timestamp), level, message, "", 0, loggerName)
}
