package com.testCases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.operation.ReadObject;
import com.operation.UIOperations;
import com.testData.Application_Test_Data;


public class Weborder_Login_UsingData extends Application_Test_Data{
	

	WebDriver dr;
	ReadObject object = new ReadObject();
	UIOperations operation = new UIOperations();

	@Test(priority = 1,dataProvider="Weborder_Login")
	public void TC_001(String uname, String upass) throws Exception {
		Properties allObjects = object.getObjectRepository();

		operation.perform(allObjects, "GOTOURL", "", "", "urlWebOrder", "");
		operation.perform(allObjects, "SETTEXT", "iduname", "id", uname, "");
		operation.perform(allObjects, "SETTEXT", "idupass", "id", upass, "");
		operation.perform(allObjects, "CLICK", "idloginButton", "id", "", "");
		operation.perform(allObjects, "THREAD_SLEEP", "", "", "", "");
		operation.perform(allObjects,"CLICK", "linklogout", "link", "","");
		// operation.perform(allObjects,"CLOSEBROWSER", "", "", "");
	}
	@AfterTest
	public void closeBrowser() throws Exception {
		Properties allObjects = object.getObjectRepository();
		operation.perform(allObjects, "CLOSEBROWSER", "", "", "", "");
	}
}
