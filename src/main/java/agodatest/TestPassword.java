package agodatest;

public class TestPassword {

	public static void main(String[] args) {
		ChangePassword changePassword = new ChangePassword();
		System.out.println(changePassword.changePassword("12345678459a", "!!!ABcdef1zxcvbnmasdf"));
	}
}
