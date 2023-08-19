package com.Api.GitHub.UtilityLayer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsClass {

	public String getCurrentDateAndTime() {
		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
	}

}
