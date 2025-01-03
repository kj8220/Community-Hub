package io.github.roopan.rc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.roopan.rc.domain.model.ApplicationSetings;

/**
 * Repository class for <code>ApplicationSetings</code> domain object. 
 * 
 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
 */
@Repository
public interface ApplicationSettingsRepository extends JpaRepository<ApplicationSetings, Long>
{

}