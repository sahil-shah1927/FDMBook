package com.fdmgroup.DAOs;

/**
 * 
 * @author Sahil Shah
 * @version 1.0
 * @param <T>
 */
public interface Storage<T> 
{
	public void create(T object) throws Exception; 
	public T read(T object) throws Exception;
	public void update(T object);
	public void delete(T object) throws Exception;
}
