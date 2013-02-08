package junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CharityLoginTest.class,EventFetchTest.class})
public class JUnitRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CharityLoginTest.class,EventFetchTest.class);
		for ( Failure f : result.getFailures() ){
			System.out.println(f.toString());
		}
	}
	
}
