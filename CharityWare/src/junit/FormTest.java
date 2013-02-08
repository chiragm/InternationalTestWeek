package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import hibernateEntities.Form;
import hibernateEntities.User;
import hibernateManagers.UserManager;

import org.junit.Before;
import org.junit.Test;

import RESTservices.CharityAdminServlet;

public class FormTest {

	
	Form form;
	CharityAdminServlet cas;
	
	@Before
	public void init(){
		form = new Form();
		cas = new CharityAdminServlet();
		form = cas.getFormsForUser().get(0);
		
//		form.setDateCreated(new java.sql.Date(2012,02,01));
//		form.setFields(fields);
//		form.setFormId(formId);
//		form.setFormName(formName);
//		form.setFormTypeId(formTyp);
//		form.setIsActive(isActive);
//		form.setPermissions(permissions);
//		form.setUrl(url);
	}
	
	@Test
	public void test() {
		List<Form> forms = cas.getFormsForUser();
		assertEquals("Returned more than one user", true, forms.size()>0);
	}

}
