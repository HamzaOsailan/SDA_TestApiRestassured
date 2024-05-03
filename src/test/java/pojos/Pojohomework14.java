package pojos;

import java.util.List;

public class Pojohomework14{
	private List<DataItem> data;
	private String message;
	private String status;

	public Pojohomework14() {
	}

	public Pojohomework14(List<DataItem> data, String message, String status) {
		this.data = data;
		this.message = message;
		this.status = status;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Pojohomework14{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}