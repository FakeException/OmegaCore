package me.zbackdoor.omegacore.system.util.logging;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * @author zBackDo_or_
 * @version 1.0
 *
 * @see Handler
 */
public class ConsoleLogHandler extends Handler {

    @Override
    public void publish(LogRecord record) {
        StaticLog.log(ConsoleLevel.from(record.getLevel()), record.getMessage());
    }

    @Override
    public void flush() {
        // Not implemented
    }

    @Override
    public void close() throws SecurityException {
        // Not implemented
    }
}
