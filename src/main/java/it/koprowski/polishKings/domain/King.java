package it.koprowski.polishKings.domain;

import java.text.DateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.junit.Before;
import org.junit.experimental.theories.DataPoint;

public class King {
	
	private String name = "someKing";
	private String authorsEmail = "author@mail.com";
	public Date startOfRule = new Date();
	public Date endOfRule = new Date();
	private int numOfChildren = 0;
	
	@Size(min = 2, max = 40)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Pattern(regexp = "[aA-zZ0-9\\.]+@[aA-zZ0-9\\.]+(\\.)+[aA-zZ0-9\\.]+")
	public String getAuthorsEmail() {
		return authorsEmail;
	}
	public void setAuthorsEmail(String _email) {
		this.authorsEmail = _email;
	}
	
	
	
	public Date getStartOfRule() {
		
		return startOfRule;
		//return DateFormat.getDateInstance(DateFormat.SHORT).format(startOfRule);
	}
	
	public String getNiceStartOfRule() {
		
		
		return DateFormat.getDateInstance(DateFormat.SHORT).format(startOfRule);
	}
	
	public void setStartOfRule(Date startOfRule) {
		this.startOfRule = startOfRule;
	}
	
	public String getNiceEndOfRule() {
		return DateFormat.getDateInstance(DateFormat.SHORT).format(endOfRule);
	}
	
	@Past
	public Date getEndOfRule() {
		return endOfRule;
		//return DateFormat.getDateInstance(DateFormat.SHORT).format(endOfRule);
	}
	public void setEndOfRule(Date endOfRule) {
		this.endOfRule = endOfRule;
	}
	
	@Min(0)
	public int getNumOfChildren() {
		return numOfChildren;
	}
	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
	}
	
}
