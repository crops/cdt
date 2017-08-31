/*******************************************************************************
 * Copyright (c) 2017 Intel, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.cdt.core.build;

import java.util.List;

import org.eclipse.cdt.core.ICommandLauncher;
import org.eclipse.cdt.core.settings.model.ICLanguageSettingEntry;

public interface ICBuildCommandLauncherConfiguration {

	void registerLanguageSettingEntries(
			List<? extends ICLanguageSettingEntry> entries);

	List<ICLanguageSettingEntry> verifyLanguageSettingEntries(
			List<ICLanguageSettingEntry> entries);

	ICommandLauncher getCommandLauncher();


}
