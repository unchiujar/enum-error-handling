package org.unchiujar.samples.enumhandling;

import static org.unchiujar.samples.enumhandling.ErrorCodes.COMMUNICATION_ERROR_CODE;
import static org.unchiujar.samples.enumhandling.ErrorCodes.NO_ERROR_CODE;
import static org.unchiujar.samples.enumhandling.ErrorCodes.SERVER_ERROR_CODE;
import static org.unchiujar.samples.enumhandling.ErrorCodes.SOME_ERROR_CODE;

import java.rmi.ServerException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.CommunicationException;

/**
 * List of errors received. 
 */
public enum CustomError {
	
	NO_ERROR(NO_ERROR_CODE) {
		@Override
		public void throwException() {
			// NO-OP
		}
	},
	SERVER_ERROR(SERVER_ERROR_CODE) {
		@Override
		public void throwException() throws ServerException {
			throw new ServerException("Server did something bad.");
		}
	},
	COMMUNICATION_ERROR(COMMUNICATION_ERROR_CODE) {
		@Override
		public void throwException() throws CommunicationException {
			throw new CommunicationException("Saussure is not my homeboy.");
		}
	},
	SOME_ERROR(SOME_ERROR_CODE) {
		@Override
		public void throwException() throws  SomeException {
			throw new SomeException("Something witty about yo momma.");
		}
	};

	//populate  a map of enums so they can be retrieved by error code
	private static Map<Integer, CustomError> codes = new HashMap<Integer, CustomError>();
	static {
		for (CustomError errorCode : values()) {
			codes.put(errorCode.getCode(), errorCode);
		}
	}

	/**
	 * Gets an enum associated with an error code.
	 * @param code the error code 
	 * @return a enum for the error code
	 */
	public static CustomError get(int code) {
		return codes.get(code);
	}

	public int getCode() {
		return errorCode;
	}

	private int errorCode;

	private CustomError(int errorCode) {
		this.errorCode = errorCode;
	}

	public abstract void throwException() throws ServerException,
			CommunicationException, SomeException;
}
