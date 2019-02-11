package conve;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weight {

	public Weight() {
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("name")
	  public String name; 

@JsonProperty("weight")
private Integer weight;

@JsonProperty("value")
private Integer value;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getWeight() {
	return weight;
}

public void setWeight(Integer weight) {
	this.weight = weight;
}

public Integer getValue() {
	return value;
}

public void setValue(Integer value) {
	this.value = value;
}
	
}
