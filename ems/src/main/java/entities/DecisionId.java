package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DecisionId implements Serializable {
	private Integer userId;
	private Integer leaveId;

	public DecisionId() {
	}

	public DecisionId(Integer userId, Integer leaveId) {
		super();
		this.userId = userId;
		this.leaveId = leaveId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leaveId == null) ? 0 : leaveId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DecisionId other = (DecisionId) obj;
		if (leaveId == null) {
			if (other.leaveId != null)
				return false;
		} else if (!leaveId.equals(other.leaveId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DecisionId [userId=" + userId + ", leaveId=" + leaveId + "]";
	}

}
