package agodatest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestChangePassword {
	
	private ChangePassword changePassword;
	private Map<String,String> testData;
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws Exception {
		changePassword = new ChangePassword();
		testData = new HashMap<String, String>();
	}

	@Test(description = "verify password is correct", groups = {"Negative" })
	public void testCorrectPassword() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest1");
		boolean actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify password is correct 2", groups = {"Negative" })
	public void testCorrectPassword2() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest2");
		boolean actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}

}
