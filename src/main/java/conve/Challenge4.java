package conve;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Challenge4 {

	public Challenge4() {
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("tools")
	  private List<Weight> tools = new ArrayList<Weight>();


	@JsonProperty("maximumWeight")
	private Integer maximumWeight;


	public List<Weight> getTools() {
		return tools;
	}


	public void setTools(List<Weight> tools) {
		this.tools = tools;
	}


	public Integer getMaximumWeight() {
		return maximumWeight;
	}


	public void setMaximumWeight(Integer maximumWeight) {
		this.maximumWeight = maximumWeight;
	}


	
}
