package agodatest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestChangePasswordNegative {
	
	private ChangePassword changePassword;
	private Map<String,String> testData;
	private boolean actualOutput;
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws Exception {
		changePassword = new ChangePassword();
		testData = new HashMap<String, String>();
	}

	@Test(description = "verify password when password is less than 18 char ", groups = {"Negative" })
	public void testPasswordLessThen18Char() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest1");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify password when password is having apart from allowed special charcter", groups = {"Negative" })
	public void testUnallwordSpecialCharacter() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest2");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify password when it has no upper case", groups = {"Negative" })
	public void testWithNoUpperCase() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest3");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	@Test(description = "verify password when it has no lower case", groups = {"Negative" })
	public void testWithNoLowerCase() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest4");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	@Test(description = "verify password when it has no numeric value", groups = {"Negative" })
	public void testWithNoNumericValue() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest5");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	@Test(description = "verify password when it has no special  character", groups = {"Negative" })
	public void testWithNoSpecialChar() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest6");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify password when it has repeated charcters more than 4 times", groups = {"Negative" })
	public void testMorethan4Duplicate() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest7");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify password when it has special charcters more than 4 times", groups = {"Negative" })
	public void testMorethan4SpecialChar() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest8");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify password has more than 50 percent number", groups = {"Negative" })
	public void testMorethan50PercentNumber() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest9");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify password when it does not match with old password", groups = {"Negative" })
	public void testPasswordMismatch() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest10");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	@Test(description = "verify password when it is matching more than 80 percent with old password", groups = {"Negative" })
	public void testPasswordSimilarToOldPassword() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest11");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify old password when it is entered in all capital letters", groups = {"Negative" })
	public void testPasswordWithAllCaps() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest12");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify old password when it is entered as blank", groups = {"Negative" })
	public void testOldPasswordWithEmpty() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest14");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}
	
	@Test(description = "verify password when it is entered as blank", groups = {"Negative" })
	public void testPasswordWithEmpty() throws Exception {
		testData = DataReader.readData("data.json", "NegativeTest15");
		actualOutput = changePassword.changePassword(testData.get("OldPassword"), testData.get("NewPassword"));
		Assert.assertEquals(actualOutput, false, "Verify password, New Password entered " + testData.get("NewPassword"));
	}




}
