package org.krams.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.base.Objects;

@Entity
@Table(name = "USERS")
public class User extends BaseEntity implements UserDetails {
	/*
	 * CREATE TABLE `USERS` ( `ID` int(6) NOT NULL AUTO_INCREMENT, `USERNAME` VARCHAR(50) NOT NULL UNIQUE, `PASSWORD`
	 * VARCHAR(50) NOT NULL, `ENABLED` BOOLEAN NOT NULL, PRIMARY KEY (`ID`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	 */

	private static final long serialVersionUID = 6311364761937265306L;
	static Logger logger = LoggerFactory.getLogger(User.class);

	@NotNull(message = "{error.user.username.null}")
	@NotEmpty(message = "{error.user.username.empty}")
	@Size(max = 50, message = "{error.user.username.max}")
	@Column(name = "username", length = 50)
	private String username;

	@NotNull(message = "{error.user.password.null}")
	@NotEmpty(message = "{error.user.password.empty}")
	@Size(max = 50, message = "{error.user.password.max}")
	@Column(name = "password", length = 50)
	private String password;

	@Column(name = "enabled")
	private boolean enabled;

	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
	private Set<Role> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return String.format("%s(id=%d, username=%s, password=%s, roles=%s, enabled=%b)", this.getClass().getSimpleName(),
				this.getId(), this.getUsername(), this.getPassword(), this.getRoles(), this.getEnabled());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;

		if (o instanceof User) {
			final User other = (User) o;
			return Objects.equal(getId(), other.getId()) && Objects.equal(getUsername(), other.getUsername())
					&& Objects.equal(getPassword(), other.getPassword()) && Objects.equal(getEnabled(), other.getEnabled());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getUsername(), getPassword(), getEnabled());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<Role> userRoles = this.getRoles();
		if (userRoles != null) {
			for (Role role : userRoles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRolename());
				authorities.add(authority);
			}
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// return true = account is valid / not expired
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// return true = account is not locked
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// return true = password is valid / not expired
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.getEnabled();
	}

}
