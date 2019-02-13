package com.cvk.training.java8.features.functional_interface;

//@FunctionalInterface //Not Mandatory
public interface TriConsumer<T, U, V> {
	void accept(T t, U u, V v);
}
