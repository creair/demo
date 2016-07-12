package demo.bean;

import com.rapid.j2ee.framework.orm.medium.annotation.Column;
import com.rapid.j2ee.framework.orm.medium.annotation.ID;
import com.rapid.j2ee.framework.orm.medium.annotation.ID.IDMode;
import com.rapid.j2ee.framework.orm.medium.annotation.Table;

@Table("T_USER")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3208919298393118471L;

	@ID(value = IDMode.ID)
	@Column
	private String userId;

	@Column
	private String userName;

	@Column
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
