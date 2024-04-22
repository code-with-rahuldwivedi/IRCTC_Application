package in.ashokit.bainding;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickat_data")
public class Ticket {

	@Id
	@GeneratedValue
	private Integer ticketId;
	private String ticketStatus;
	private String trainNum;
	private String name;
	private LocalDate dob;
	private String gender;
	private LocalDate doj;
	private String source;
	private String destination;
	
	public Integer getTicketId() {
		return ticketId;
	}
	
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	
	public String getTicketStatus() {
		return ticketStatus;
	}
	
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	public String getTrainNum() {
		return trainNum;
	}
	
	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public LocalDate getDoj() {
		return doj;
	}
	
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}

	
}
