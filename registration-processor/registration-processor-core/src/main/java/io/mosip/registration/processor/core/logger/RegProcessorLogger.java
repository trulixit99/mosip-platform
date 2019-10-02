package io.mosip.registration.processor.core.logger;

import io.mosip.kernel.core.logger.spi.Logger;
import io.mosip.kernel.logger.logback.appender.RollingFileAppender;
import io.mosip.kernel.logger.logback.factory.Logfactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * The Class RegProcessorLogger.
 * @author : Rishabh Keshari
 */
public final class RegProcessorLogger {
	
        @Value("$(registration.processor.log_directory)")
        private static String logfileLocation;

	/** The mosip rolling file appender. */
	private static RollingFileAppender mosipRollingFileAppender;
 	
	static {
		mosipRollingFileAppender = new RollingFileAppender();
		mosipRollingFileAppender.setAppend(true);
		mosipRollingFileAppender.setAppenderName("fileappender");
                mosipRollingFileAppender.setFileName(logfileLocation + "/registrationProcessor.log");
                mosipRollingFileAppender.setFileNamePattern(logfileLocation + "/registrationProcessor-%d{yyyy-MM-dd}-%i.log");
		mosipRollingFileAppender.setImmediateFlush(true);
		mosipRollingFileAppender.setMaxFileSize("1mb");
		mosipRollingFileAppender.setMaxHistory(3);
		mosipRollingFileAppender.setPrudent(false);
		mosipRollingFileAppender.setTotalCap("10mb");
	}

	/**
	 * Instantiates a new reg processor logger.
	 */
	private RegProcessorLogger() {
	}

	/**
	 * Gets the logger.
	 *
	 * @param clazz the clazz
	 * @return the logger
	 */
	public static Logger getLogger(Class<?> clazz) {
		return Logfactory.getDefaultRollingFileLogger(mosipRollingFileAppender, clazz);
	}
}
