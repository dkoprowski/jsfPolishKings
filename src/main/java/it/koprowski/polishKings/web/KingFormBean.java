package it.koprowski.polishKings.web;

import it.koprowski.polishKings.domain.King;
import it.koprowski.polishKings.service.KingManager;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named("kingBean")
public class KingFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private King king = new King();

	private ListDataModel<King> kingsList = new ListDataModel<King>();

	@Inject
	private KingManager kingManager;

	public King getKing() {
		return king;
	}

	public void setKing(King king) {
		this.king = king;
	}

	public ListDataModel<King> getAllKings() {
		kingsList.setWrappedData(kingManager.getAllKings());
		return kingsList;
	}

	// Actions
	public String addKing() {
		kingManager.addKing(king);
		return "showPersons";
		//return null;
	}

	public String deleteKing() {
		King kingToDelete = kingsList.getRowData();
		kingManager.removeKing(kingToDelete);
		return null;
	}

	// Validators
/*
	// Business logic validation
	public void uniquePin(FacesContext context, UIComponent component,
			Object value) {

		String pin = (String) value;

		for (King person : kingManager.getAllPersons()) {
			if (person.getPin().equalsIgnoreCase(pin)) {
				FacesMessage message = new FacesMessage(
						"Person with this PIN already exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
*/
	// Multi field validation with <f:event>
	// Rule: first two digits of PIN must match last two digits of the year of
	// birth
	/*
	public void validatePinDob(ComponentSystemEvent event) {

		UIForm form = (UIForm) event.getComponent();
		UIInput pin = (UIInput) form.findComponent("pin");
		UIInput dob = (UIInput) form.findComponent("dob");

		if (pin.getValue() != null && dob.getValue() != null
				&& pin.getValue().toString().length() >= 2) {
			String twoDigitsOfPin = pin.getValue().toString().substring(0, 2);
			Calendar cal = Calendar.getInstance();
			cal.setTime(((Date) dob.getValue()));

			String lastDigitsOfDob = ((Integer) cal.get(Calendar.YEAR))
					.toString().substring(2);

			if (!twoDigitsOfPin.equals(lastDigitsOfDob)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(form.getClientId(), new FacesMessage(
						"PIN doesn't match date of birth"));
				context.renderResponse();
			}
		}
	}
	*/
	
	public void validateDate(ComponentSystemEvent event) {

		UIForm form = (UIForm) event.getComponent();
		UIInput startDate = (UIInput) form.findComponent("calendar1");
		UIInput endDate = (UIInput) form.findComponent("calendar2");

		if (startDate.getValue() != null && endDate.getValue() != null)
		{
			Calendar startCal = Calendar.getInstance();
			Calendar endCal = Calendar.getInstance();
			startCal.setTime((Date)startDate.getValue());
			endCal.setTime((Date)endDate.getValue());
			
			if(!endCal.after(startCal)){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(form.getClientId(), new FacesMessage(
						"Finish date cannot be before start date!"));
				context.renderResponse();
			}
		}
		
	}
}
