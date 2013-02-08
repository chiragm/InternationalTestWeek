package system;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({LoginCharitySystemTest.class,CharityFormPopTest.class})
public class DriverRunner {

		public static void main (String[] args) {
			Result results = JUnitCore.runClasses(LoginCharitySystemTest.class);
			for (Failure f:results.getFailures()){
				System.out.println(f.toString());
			}
			
//			LoginCharitySystemTest test = new LoginCharitySystemTest();
//			try {
//				test.testcLogin();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
}
