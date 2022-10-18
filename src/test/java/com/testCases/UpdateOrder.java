package com.testCases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.operation.ReadObject;
import com.operation.UIOperations;

public class UpdateOrder {
	WebDriver dr;
	
	ReadObject object = new ReadObject();
	UIOperations operation = new UIOperations();
	
	@Test(priority = 1)
	public void TC_001() throws Exception {
		Properties allObjects =  object.getObjectRepository();
	
		operation.perform(allObjects,"GOTOURL", "", "", "urlWebOrder","");
		operation.perform(allObjects,"SETTEXT", "iduname", "id", "Tester","");
		operation.perform(allObjects,"SETTEXT", "idupass", "id", "test","");
		operation.perform(allObjects,"CLICK", "idloginButton", "id", "","");
		
		
	
	}
	
	@Test(priority = 2)
	public void TC_002() throws Exception {
		Properties allObjects =  object.getObjectRepository();
		
		operation.perform(allObjects,"CLICK", "clickorderlink", "LINK", "","");
		operation.perform(allObjects,"SELECTDROPDOWNVALUE", "ddproduct", "NAME", "MyMoney","ByText");
		
		operation.perform(allObjects,"SETTEXT", "namequantity", "NAME", "5","");
		operation.perform(allObjects,"SETTEXT", "namepriceperunit", "NAME", "80","");
		operation.perform(allObjects,"SETTEXT", "namediscount", "NAME", "10","");
		operation.perform(allObjects,"SETTEXT", "nametotal", "NAME", "","");
		
		
		operation.perform(allObjects,"SETTEXT", "namecustomername", "NAME", "farid","");
		operation.perform(allObjects,"SETTEXT", "namestreet", "NAME", "100 john","");
		operation.perform(allObjects,"SETTEXT", "namecity", "NAME", "Brooklyn","");
		operation.perform(allObjects,"SETTEXT", "namestate", "NAME", "NY","");
		operation.perform(allObjects,"SETTEXT", "namezip", "NAME", "10010","");
		
		
		operation.perform(allObjects,"SELECTRADIOBUTTON", "forpaymentinfo", "XPATH", "","");
		operation.perform(allObjects,"SETTEXT", "namecardnum", "NAME", "1001200532149006","");
		operation.perform(allObjects,"SETTEXT", "nameexpirydate", "NAME", "12/23","");
		
		
		operation.perform(allObjects,"CLICK", "idprocess", "ID", "","");
		
	}
	
	
	@Test(priority =  3)
	public void tc003 () throws Exception {
		Properties allObjects = object.getObjectRepository();
		
		operation.perform(allObjects, "CLICK", "viewOrders_xpath", "xpath", "", "");
		operation.perform(allObjects, "CLICK", "updateButton_xpath", "xpath", null, null);
//		operation.perform(allObjects, "VERIFYTEXTISPRESENT", "listOfAllOrdersText", "text", "", "");
	}
	
	

}
