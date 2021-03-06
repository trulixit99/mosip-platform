package io.mosip.registration.processor.message.sender.utility;

public enum NotificationStageStatus {
	
	OSI_VALIDATE_FAILED,
	
	VALIDATE_PACKET_FAILED,
	
	MANUAL_VERIFICATION_FAILED,
	
	UIN_GENERATOR_SUCCESS,
	
	BIOGRAPHIC_VERIFICATION_FAILED,
	
	DEMOGRAPHIC_VERIFICATION_FAILED,
	
	UIN_GENERATOR_PROCESSED,

	QUALITY_CHECK_FAILED

}
