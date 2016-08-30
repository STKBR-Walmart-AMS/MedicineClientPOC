package com.softtek.medicine.model;

import java.io.Serializable;

import com.bmc.arsys.api.Entry;

public class EntryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1220624156678059464L;
	private Entry entry;

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

}
