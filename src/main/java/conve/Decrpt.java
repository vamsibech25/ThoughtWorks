package conve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Decrpt {

	public Decrpt() {
		// TODO Auto-generated constructor stub
	}
	  @JsonProperty("encryptedMessage")
	  public String encryptedMessage; 

	  @JsonProperty("key")
	  public Integer key;



	public String getEncryptedMessage() {
		return encryptedMessage;
	}

	public void setEncryptedMessage(String encryptedMessage) {
		this.encryptedMessage = encryptedMessage;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}
}

