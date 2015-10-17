package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Decision
 *
 */
@Entity
public class Decision implements Serializable {
	private StateEnum state;
	private DecisionId decisionId;
	private Date dateOfTheDecision;
	private static final long serialVersionUID = 1L;

	private User user;
	private Leave leave;

	public Decision() {
		super();
	}

	public Decision(StateEnum state, User user, Leave leave) {
		this.state = state;
		this.user = user;
		this.leave = leave;
		this.dateOfTheDecision = new Date();
		this.decisionId = new DecisionId(user.getId(), leave.getId());
	}

	public Date getDateOfTheDecision() {
		return this.dateOfTheDecision;
	}

	public void setDateOfTheDecision(Date dateOfTheDecision) {
		this.dateOfTheDecision = dateOfTheDecision;
	}


	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	@EmbeddedId
	public DecisionId getDecisionId() {
		return decisionId;
	}

	public void setDecisionId(DecisionId decisionId) {
		this.decisionId = decisionId;
	}

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id", updatable = false, insertable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "leaveId", referencedColumnName = "id", updatable = false, insertable = false)
	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}

}
