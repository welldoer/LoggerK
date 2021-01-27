package net.blogjava.welldoer

import net.blogjava.welldoer.appender.Appender
import net.blogjava.welldoer.appender.ConsoleAppender

class LogKLogger(val appender: Appender, val level: Level) : Logger {
    constructor(appender: Appender): this(appender, Level.INFO)
    constructor(): this(ConsoleAppender())

    override fun trace(msg: String) {
        filterAndLog(Level.TRACE, msg)
    }

    override fun debug(msg: String) {
        filterAndLog(Level.DEBUG, msg)
    }

    override fun info(msg: String) {
        filterAndLog(Level.INFO, msg)
    }

    override fun warn(msg: String) {
        filterAndLog(Level.WARN, msg)
    }

    override fun error(msg: String) {
        filterAndLog(Level.ERROR, msg)
    }

    private fun filterAndLog(eventLevel: Level, msg: String) {
        if (eventLevel >= level) {
            appender.append(LoggingEvent(eventLevel, msg, ""))
        }
    }
}