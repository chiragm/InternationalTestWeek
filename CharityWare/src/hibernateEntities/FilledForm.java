package hibernateEntities;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.envers.Audited;

import javax.persistence.Entity;

@Entity
@Audited
@XmlRootElement(name = "filledForm")
public class FilledForm {
	
	private Integer filled_form_id;
	private FormFields form_field_id;
	private List<FormFields> form_fields;
	private String value;
	private User user_id;
	private Integer record_id;
	private Boolean isActive;
	private Timestamp timestamp;
	
	
	public FilledForm(){}
	public FilledForm(User user, FormFields form_field_id){
		this.form_field_id=form_field_id;
		this.user_id = user;
		this.record_id=new Integer(1);
		this.isActive=true;
		this.timestamp= new Timestamp(Calendar.DATE);
	}
	
	@XmlElement
	public Integer getFilled_form_id() {
		return filled_form_id;
	}
	public void setFilled_form_id(Integer filled_form_id) {
		this.filled_form_id = filled_form_id;
	}
	
	@XmlElement
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@XmlElement(name = "user")
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	
	@XmlElement
	public Integer getRecord_id() {
		return record_id;
	}
	public void setRecord_id(Integer record_id) {
		this.record_id = record_id;
	}
	@XmlElement
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@XmlElement
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@XmlElement(name = "formFields")
	public FormFields getForm_field_id() {
		return form_field_id;
	}
	public void setForm_field_id(FormFields form_field_id) {
		this.form_field_id = form_field_id;
	}
	@XmlElement
	public List<FormFields> getForm_fields() {
		return form_fields;
	}
	public void setForm_fields(List<FormFields> form_fields) {
		this.form_fields = form_fields;
	}
}
