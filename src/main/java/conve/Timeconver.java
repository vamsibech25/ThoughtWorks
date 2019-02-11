package conve;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Timeconver {

	public Timeconver() {
		// TODO Auto-generated constructor stub
	}


  @JsonProperty("toolUsage")
  private List<Toolusage> toolUsage = new ArrayList<Toolusage>();


public List<Toolusage> getToolUsage() {
	return toolUsage;
}


public void setToolUsage(List<Toolusage> toolUsage) {
	this.toolUsage = toolUsage;
}



}
