package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by branden on 3/8/16 at 15:40.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
