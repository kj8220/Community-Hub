package io.github.roopan.rc.infra.security.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import io.github.roopan.rc.infra.security.user.model.Role;
import io.github.roopan.rc.infra.security.user.model.User;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UserDetailsImpl implements UserDetails
{
	private static final long serialVersionUID = 1L;
	
	private final User user;
	private final Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(User user) 
	{
		this.user = user;
		
		Set<String> roleAndPermissions = new HashSet<>();
		
		List<Role> roles = user.getRoles();
		
		for (Role role : roles)
		{
			roleAndPermissions.add(role.getName());
			
			log.info("-----> Role                : "+role.getName());
			
			for(int i = 0; i<role.getPermissions().size(); i++)
			{
				log.info("-----> Permission          : "+role.getPermissions().get(i).getName());
				
				roleAndPermissions.add(role.getPermissions().get(i).getName());
			}
		}
		
		String[] roleNames = new String[roleAndPermissions.size()];
		
		log.info("-----> Roles & Permissions : "+roleAndPermissions.toString());
		
		
		this.authorities = AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
	}
	
	public User getUser() 
	{
        return user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return authorities;
	}

	@Override
	public String getPassword() 
	{
		return user.getPassword();
	}

	@Override
	public String getUsername() 
	{
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() 
	{
		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() 
	{
		return user.isEnabled();
	}
}
