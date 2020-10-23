package org.jasig.schedassist.model;

import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

/**
 * User: mike Date: 10/22/20 Time: 22:47
 */
public interface Database {
  /**
   *
   * @return the {@link DataFieldMaxValueIncrementer} providing schedule owner ids
   */
  DataFieldMaxValueIncrementer ownerIdSequence();

  /**
   *
   * @return the {@link DataFieldMaxValueIncrementer} providing statistic event ids
   */
  DataFieldMaxValueIncrementer eventIdSequence();

  /**
   *
   * @return the {@link DataFieldMaxValueIncrementer} providing reminder ids
   */
  DataFieldMaxValueIncrementer reminderIdSequence();
}
