package org.generation.toddes.seguranca;

import java.util.Collection;

import org.generation.toddes.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{
	
	//atributos
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	//construtor
	public UserDetailsImpl(Usuario user) {
		this.userName = user.getEmailUsuario();
		this.password = user.getSenhaUsuario();
	}
	
	public UserDetailsImpl() {} //construtor vazio

	
	// botão direito > source > Override/Implements Methods
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
