package org.unchiujar.samples.enumhandling.use;

import static org.unchiujar.samples.enumhandling.ErrorCodes.COMMUNICATION_ERROR_CODE;
import static org.unchiujar.samples.enumhandling.ErrorCodes.NO_ERROR_CODE;
import static org.unchiujar.samples.enumhandling.ErrorCodes.SERVER_ERROR_CODE;
import static org.unchiujar.samples.enumhandling.ErrorCodes.SOME_ERROR_CODE;

import java.rmi.ServerException;

import javax.naming.CommunicationException;

import org.junit.Test;
import org.unchiujar.samples.enumhandling.CustomError;
import org.unchiujar.samples.enumhandling.SomeException;

public class EnumHandlingTest {

	@Test(expected = ServerException.class)
	public void serverError() throws Exception {
		CustomError.get(SERVER_ERROR_CODE).throwException();
	}

	@Test(expected = CommunicationException.class)
	public void communicationError() throws Exception {
		CustomError.get(COMMUNICATION_ERROR_CODE).throwException();
	}

	@Test(expected = SomeException.class)
	public void uglyError() throws Exception {
		CustomError.get(SOME_ERROR_CODE).throwException();
	}

	@Test
	public void noError() throws Exception {
		CustomError.get(NO_ERROR_CODE).throwException();
	}

}
