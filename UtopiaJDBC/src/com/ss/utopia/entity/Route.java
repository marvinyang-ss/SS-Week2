/**
 * 
 */
package com.ss.utopia.entity;

/**
 * @author marvin
 *
 */
public class Route {
	private Integer id;
	private Airport origin;
	private Airport destination;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Airport getOrigin() {
		return origin;
	}
	public void setOrigin(Airport origin) {
		this.origin = origin;
	}
	public Airport getDestination() {
		return destination;
	}
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
}
