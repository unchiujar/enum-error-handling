package org.unchiujar.samples.enumhandling.use;

import static org.unchiujar.samples.enumhandling.ErrorCodes.NO_ERROR_CODE;
import static org.unchiujar.samples.enumhandling.ErrorCodes.SERVER_ERROR_CODE;

public class RegularHandlingExample {

	
	private void someLogic(int receivedErrorCode) {
		switch (receivedErrorCode) {
		case NO_ERROR_CODE:
			// do error handling or throw exception
			return;
		case SERVER_ERROR_CODE:
			// do error handling or throw exception
			return;
		default:
			return;
		}

		// do happy flow
	}
}
