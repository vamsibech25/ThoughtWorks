package conve;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tool {

	public Tool() {
		// TODO Auto-generated constructor stub
	}
	
	@JsonProperty("hiddenTools")
	  public String hiddenTools; 

    @JsonProperty("tools")
    private List<String> tools = new ArrayList<String>();

	public String getHiddenTools() {
		return hiddenTools;
	}

	public void setHiddenTools(String hiddenTools) {
		this.hiddenTools = hiddenTools;
	}

	public List<String> getTools() {
		return tools;
	}

	public void setTools(List<String> tools) {
		this.tools = tools;
	}





}
