package org.eclipse.cdt.core.model;

/**********************************************************************
 * Copyright (c) 2002,2003 Rational Software Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v0.5
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v05.html
 * 
 * Contributors: 
 * Rational Software - Initial API and implementation
***********************************************************************/
public interface IEnumerator extends ICElement, ISourceManipulation{

	/**
	 * Returns the enumerator constant expression if any.
	 * Returns null otherwise.
	 * @return String
	 */
	String getConstantExpression();
}
