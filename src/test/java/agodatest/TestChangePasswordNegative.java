package agodatest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestChangePasswordNegative {
	
	private ChangePassword changePassword;
	private Map<String,String> testData;
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws Exception {
		changePassword = new ChangePassword();
		testData = new HashMap<String, String>();
	}

	@Test(description = "verify password when password is less than 18 char ", groups = {"Positive" })
	public void testPasswordLessThen18Char() throws Exception {
		testData = DataReader.readData("data.json", "Test1");
		System.out.println(testData);
		
		boolean actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify password when password is less than 18 char ", groups = {"Positive" })
	public void testCorrectPassword() throws Exception {
		testData = DataReader.readData("data.json", "Test1");
		System.out.println(testData);
		
		boolean actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, true, "Verify password, New Password entered " + testData.get("NewPassword"));
	}


}
