/**
 * 
 */
package com.harman.model;

/**
 * @author SAROY
 *
 */
public class Water {
	
	private Hydrogen h1;

	private Hydrogen h2;
	
	private Oxygen o;
	
	public Water(Hydrogen h1, Hydrogen h2, Oxygen o) {
		this.h1 = h1;
		this.h2 = h2;
		this.o = o;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Water [h1=");
		builder.append(h1.getId());
		builder.append(", h2=");
		builder.append(h2.getId());
		builder.append(", o=");
		builder.append(o.getId());
		builder.append("]");
		return builder.toString();
	}

}
