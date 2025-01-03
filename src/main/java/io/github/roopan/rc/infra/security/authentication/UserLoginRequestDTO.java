package io.github.roopan.rc.infra.security.authentication;

import io.github.roopan.rc.domain.model.common.AuditEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper=false)
public class UserLoginRequestDTO extends AuditEntity
{
	private static final long serialVersionUID = 1L;
	
	String username;
    String password;
}
