/**
 * 
 */
package org.bedework.sometime.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;

import javax.sql.DataSource;

/**
 * {@link Configuration} that provides H2 specific {@link Bean}s.
 * This configuration is activated with the "h2" Spring {@link Profile}.
 * 
 * @author Nicholas Blair
 */
@Configuration
@Profile("h2")
public class H2DatabaseConfiguration {
	private DataSource dataSource;

	/**
	 * @param dataSource the dataSource to set
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 
	 * @return the {@link DataFieldMaxValueIncrementer} providing schedule owner ids
	 */
	@Bean
	@Qualifier("owners")
	public DataFieldMaxValueIncrementer ownerIdSequence() {
		return new H2SequenceMaxValueIncrementer(dataSource, "ownerid_seq");
	}

	/**
	 * 
	 * @return the {@link DataFieldMaxValueIncrementer} providing statistic event ids
	 */
	@Bean
	@Qualifier("statistics")
	public DataFieldMaxValueIncrementer eventIdSequence() {
		return new H2SequenceMaxValueIncrementer(dataSource, "eventid_seq");
	}

	/**
	 * 
	 * @return the {@link DataFieldMaxValueIncrementer} providing reminder ids
	 */
	@Bean
	@Qualifier("reminders")
	public DataFieldMaxValueIncrementer reminderIdSequence() {
		return new H2SequenceMaxValueIncrementer(dataSource, "reminderid_seq");
	}
}
