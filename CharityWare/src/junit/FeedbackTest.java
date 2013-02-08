package junit;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import hibernateEntities.User;
import hibernateManagers.UserManager;

import org.junit.Before;
import org.junit.Test;

import RESTdataEntities.Charity;
import RESTdataEntities.UserType;
import RESTdataEntities.Users;
import RESTdataEntities.UsersJpaController;
import RESTdataEntities.feedbackEntity;
import RESTservices.FeedbackResource;
import RESTservices.UsersRESTFacade;

public class FeedbackTest {

	Users users;
	feedbackEntity feedback;
	
	UsersRESTFacade urf; 
	UserType ut;
	
	@Before
	public void init(){
		
		users = new Users();
		ut = new UserType();
		short isA = (short) 1;
		
		ut.setUserTypeDescription("");
		ut.setIsActive(isA);
		ut.setTimestamp(new Timestamp(1));
		ut.setUserType("Charity Worker");
		ut.setUserTypeId(2);
		
		users.setUserId(3);
		users.setUsername("amartin");
		users.setDateCreated(new Date(1));
		users.setFeedbackEntityCollection(null);
		users.setIsActive(true);
		users.setTimestamp(new Timestamp(1));
		users.setUserEmail("amartin@ucl.ac.uk");
		users.setUserPassword("open");
		users.setUserTypeId(ut);
		
		feedback = new feedbackEntity();
		feedback.setComment("smth");
		feedback.setEmail("smth@smth.com");
		feedback.setFeedbackId(1);
		feedback.setIsReviewed(false);
		feedback.setName("alex");
		feedback.setReviewedBy(users);
		feedback.setReviewedDate(new Date(1));
		feedback.setTimestamp(new Timestamp(1));
	}
	
	@Test
	public void test() {
		List<feedbackEntity> feedbacks = FeedbackResource.getFeedbacks();
		assertEquals("Feedback returned",false,feedbacks.size()>1);
		assertThat(feedback,instanceOf(feedbackEntity.class));
	}

}
