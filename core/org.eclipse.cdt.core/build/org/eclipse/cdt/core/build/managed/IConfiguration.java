/**********************************************************************
 * Copyright (c) 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 * IBM - Initial API and implementation
 **********************************************************************/
package org.eclipse.cdt.core.build.managed;

import org.eclipse.core.resources.IResource;

public interface IConfiguration extends IBuildObject {
	// Schema element names
	public static final String TOOL_REF = "toolReference";
	public static final String PARENT = "parent";

	/**
	 * Returns the target for this configuration.
	 * 
	 * @return
	 */
	public ITarget getTarget();
	
	/**
	 * Returns the resource that owns the target that owns the configuration.
	 * @return
	 */
	public IResource getOwner();
	
	/**
	 * Returns the tools that are used in this configuration.
	 * 
	 * @return
	 */
	public ITool[] getTools();

	/**
	 * Sets the value of a boolean option for this configuration.
	 * 
	 * @param option The option to change.
	 * @param value The value to apply to the option.
	 * @throws BuildException
	 */
	public void setOption(IOption option, boolean value) 
		throws BuildException;	

	/**
	 * Sets the value of a string option for this configuration.
	 * 
	 * @param option The option that will be effected by change.
	 * @param value The value to apply to the option.
	 */
	public void setOption(IOption option, String value)
		throws BuildException;
	
	/**
	 * Sets the value of a list option for this configuration.
	 * 
	 * @param option The option to change.
	 * @param value The values to apply to the option.
	 */
	public void setOption(IOption option, String[] value)
		throws BuildException;
}
