package br.com.sonner.restygwt.jacksonexample.client;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class JacksonComplexObject {

	private Integer prop1;
	private String prop2;
	private JacksonComplexObject other;
	
	public Integer getProp1() {
		return prop1;
	}
	public void setProp1(Integer prop1) {
		this.prop1 = prop1;
	}
	public String getProp2() {
		return prop2;
	}
	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}
	public JacksonComplexObject getOther() {
		return other;
	}
	public void setOther(JacksonComplexObject other) {
		this.other = other;
	}
}
