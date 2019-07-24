package agodatest;

import java.util.HashMap;
import java.util.Map;

public class ChangePassword {

	private final String existingSystemPassword = "ABCDEFghijklmnopqrstuvwxyz1";

	private int numberCount = 0;
	private int specialCharCount = 0;
	private Map<Character, Integer> charMap = new HashMap<Character, Integer>();
	private String specialCharAllowed = "!@#$&*";
	private String numberString = "0123456789";
	private float numbrePercentage = 50.0f;
	private float oldPercentage = 80.0f;

	public boolean changePassword(String oldPassword, String newPassword) {
		if (!existingSystemPassword.equals(oldPassword)) {
			return false;
		}
		if (!checkIsPasswordValid(newPassword)) {
			return false;
		}

		return (checkSimilaritiesPercentage(oldPassword, newPassword));
	}

	private boolean checkIsPasswordValid(String newPassword) {
		return (checkAlphnumericWithCount(newPassword) && checkAtleastOneChar(newPassword)
				&& checkDuplicateCharsCount(newPassword) && checkSpecialCharCount()
				&& checkNumberPercenatge(newPassword));
	}

	private boolean checkAlphnumericWithCount(String newPassword) {
		return newPassword.matches("[a-zA-Z0-9!@#$&*]{18,}");
	}

	private boolean checkAtleastOneChar(String newPassword) {
		return newPassword.matches("(.*[a-z].*)") && newPassword.matches("(.*[A-Z].*)")
				&& newPassword.matches("(.*\\d.*)") && newPassword.matches("(.*[!@#$&*].*)");
	}

	private boolean checkDuplicateCharsCount(String newPassword) {
		for (int i = 0; i < newPassword.length(); i++) {
			if (charMap.containsKey(newPassword.charAt(i))) {
				charMap.put(newPassword.charAt(i), charMap.get(newPassword.charAt(i)) + 1);
				if (charMap.get(newPassword.charAt(i)) > 4) {
					return false;
				}
			} else {
				charMap.put(newPassword.charAt(i), 1);
			}
		}
		return true;
	}

	private boolean checkSpecialCharCount() {
		for (int i = 0; i < specialCharAllowed.length(); i++) {
			if (charMap.containsKey(specialCharAllowed.charAt(i))) {
				specialCharCount = specialCharCount + charMap.get(specialCharAllowed.charAt(i));
			}
		}
		if (specialCharCount > 4) {
			return false;
		}
		return true;
	}

	private boolean checkNumberPercenatge(String newPassword) {
		for (int i = 0; i < numberString.length(); i++) {
			if (charMap.containsKey(numberString.charAt(i))) {
				numberCount = numberCount + charMap.get(numberString.charAt(i));
			}
		}

		float perValue = (float) ((float) numberCount / (float) newPassword.length()) * 100;
		if (perValue < numbrePercentage) {
			return true;
		}
		return false;
	}

	private boolean checkSimilaritiesPercentage(String oldPassword, String newPassword) {
		int commonChar = 0;
		StringBuffer newPass = new StringBuffer(newPassword);
		for (int i = 0; i < oldPassword.length(); i++) {
			char check = oldPassword.charAt(i);
			for (int j = 0; j < newPass.length(); j++) {
				if (newPass.charAt(j) == check) {
					newPass.deleteCharAt(j);
					commonChar = commonChar + 1;
					break;
				}
			}
		}
		float perValue = (float) ((float) commonChar / (float) oldPassword.length()) * 100;
		if (perValue < oldPercentage) {
			return true;
		}
		return false;
	}

}
