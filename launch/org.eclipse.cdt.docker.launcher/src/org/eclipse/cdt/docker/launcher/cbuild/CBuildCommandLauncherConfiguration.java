/*******************************************************************************
 * Copyright (c) 2017 Intel, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.cdt.docker.launcher.cbuild;

import java.util.List;

import org.eclipse.cdt.core.ICommandLauncher;
import org.eclipse.cdt.core.build.CBuildConfiguration;
import org.eclipse.cdt.core.build.ICBuildCommandLauncherConfiguration;
import org.eclipse.cdt.core.build.IToolChain;
import org.eclipse.cdt.core.settings.model.ICLanguageSettingEntry;
import org.eclipse.cdt.internal.docker.launcher.ContainerCommandLauncher;
import org.eclipse.core.resources.IBuildConfiguration;
import org.eclipse.core.runtime.CoreException;

public abstract class CBuildCommandLauncherConfiguration
		extends CBuildConfiguration
		implements ICBuildCommandLauncherConfiguration {

	protected ICommandLauncher launcher;

	public CBuildCommandLauncherConfiguration(IBuildConfiguration config,
			String name) throws CoreException {
		super(config, name);
	}

	public CBuildCommandLauncherConfiguration(IBuildConfiguration config,
			String name, IToolChain toolChain) {
		super(config, name, toolChain);
	}

	public CBuildCommandLauncherConfiguration(IBuildConfiguration config,
			String name, IToolChain toolChain, String launchMode) {
		super(config, name, toolChain, launchMode);
	}

	public CBuildCommandLauncherConfiguration(IBuildConfiguration config,
			IToolChain toolChain) {
		super(config, toolChain);
	}

	protected ICommandLauncher createCommandLauncher() {
		return new ContainerCommandLauncher();
	}

	@Override
	public void registerLanguageSettingEntries(
			List<? extends ICLanguageSettingEntry> entries) {
	}

	@Override
	public List<ICLanguageSettingEntry> verifyLanguageSettingEntries(
			List<ICLanguageSettingEntry> entries) {
		return null;
	}

	@Override
	public ICommandLauncher getCommandLauncher() {
		synchronized (this) {
			if (this.launcher == null)
				this.launcher = createCommandLauncher();
		}
		return launcher;
	}

}
