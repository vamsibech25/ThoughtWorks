package conve;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"name",
	"useStartTime",
	"useEndTime"
})
public class Toolusage {

	public Toolusage() {
		// TODO Auto-generated constructor stub
	}
	@JsonProperty("name")
	  public String name; 

  @JsonProperty("useStartTime")
  private String useStartTime;
  
  @JsonProperty("useEndTime")
  private String useEndTime;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUseStartTime() {
	return useStartTime;
}

public void setUseStartTime(String useStartTime) {
	this.useStartTime = useStartTime;
}

public String getUseEndTime() {
	return useEndTime;
}

public void setUseEndTime(String useEndTime) {
	this.useEndTime = useEndTime;
}

}
