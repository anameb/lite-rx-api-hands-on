package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part04Transform {

//========================================================================================

	// TODO Capitalize the user username, firstname and lastname
	Mono<User> capitalizeOne(Mono<User> mono) {
		return  mono.map(username -> new User(username.getUsername().toUpperCase(), username.getFirstname().toUpperCase(), username.getLastname().toUpperCase()));
	}

//========================================================================================

	// TODO Capitalize the users username, firstName and lastName
	Flux<User> capitalizeMany(Flux<User> Flux) {
		return Flux.map(username -> new User(username.getUsername().toUpperCase(),
				username.getFirstname().toUpperCase(),
				username.getLastname().toUpperCase()));
	}

//========================================================================================

	// TODO Capitalize the users username, firstName and lastName using #asyncCapitalizeUser
	Flux<User> asyncCapitalizeMany(Flux<User> Flux) {
		return Flux.flatMap(username -> asyncCapitalizeUser(username));
	}

	Mono<User> asyncCapitalizeUser(User username) {
		return Mono.just(new User(username.getUsername().toUpperCase(),
				username.getFirstname().toUpperCase(),
				username.getLastname().toUpperCase()));
	}

}
