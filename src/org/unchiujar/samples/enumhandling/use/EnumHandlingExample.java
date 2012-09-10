package org.unchiujar.samples.enumhandling.use;

import java.rmi.ServerException;

import javax.naming.CommunicationException;

import org.unchiujar.samples.enumhandling.CustomError;
import org.unchiujar.samples.enumhandling.SomeException;

public class EnumHandlingExample {

	private void someLogic(int receivedErrorCode){
		try {
			//received some data with an error code
			CustomError.get(receivedErrorCode).throwException();
			//do happy flow
			
		} catch (ServerException e) {
			//error handling and logging
		} catch (CommunicationException e) {
			//error handling and logging
		} catch (SomeException e) {
			//error handling and logging
		}
	}
}

