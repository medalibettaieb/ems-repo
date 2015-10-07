package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Leave
 *
 */
@Entity
@Table(name = "T_LEAVE")
public class Leave implements Serializable {

	private Integer id;
	private Date startDate;
	private Double duration;
	private String leaveDescription;
	private static final long serialVersionUID = 1L;

	private User leaveRequestor;
	private List<Decision> decisions;

	public Leave() {
		super();
	}

	public Leave(Date startDate, Double duration, String leaveDescription) {
		super();
		this.startDate = startDate;
		this.duration = duration;
		this.leaveDescription = leaveDescription;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Double getDuration() {
		return this.duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public String getLeaveDescription() {
		return leaveDescription;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	public User getLeaveRequestor() {
		return leaveRequestor;
	}

	public void setLeaveRequestor(User leaveRequestor) {
		this.leaveRequestor = leaveRequestor;
	}

	public void setLeaveDescription(String leaveDescription) {
		this.leaveDescription = leaveDescription;
	}

	@OneToMany(mappedBy = "leave")
	public List<Decision> getDecisions() {
		return decisions;
	}

	public void setDecisions(List<Decision> decisions) {
		this.decisions = decisions;
	}

}
