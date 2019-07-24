package agodatest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestChangePassword {
	
	private ChangePassword changePassword;
	private Map<String,String> testData;
	private boolean actualOutput;
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws Exception {
		changePassword = new ChangePassword();
		testData = new HashMap<String, String>();
	}

	@Test(description = "verify password is correct", groups = {"Positive" })
	public void testCorrectPassword() throws Exception {
		testData = DataReader.readData("data.json", "Test1");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, true, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify password is correct when it has exact 18 chars", groups = {"Positive" })
	public void testCorrectPassword2() throws Exception {
		testData = DataReader.readData("data.json", "Test2");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, true, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "Verify password when it has duplicate charactes max by 4", groups = {"Positive" })
	public void testCorrectPassword3() throws Exception {
		testData = DataReader.readData("data.json", "Test3");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, true, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "Verify password when it has exact 4 special charcaters", groups = {"Positive" })
	public void testCorrectPassword4() throws Exception {
		testData = DataReader.readData("data.json", "Test4");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, true, "Verify password, New Password entered " + testData.get("NewPassword"));
	}


}
