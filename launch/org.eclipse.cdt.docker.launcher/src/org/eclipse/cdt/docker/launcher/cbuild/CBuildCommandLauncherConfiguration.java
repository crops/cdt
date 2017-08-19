package org.eclipse.cdt.docker.launcher.cbuild;

import java.util.List;

import org.eclipse.cdt.core.build.CBuildConfiguration;
import org.eclipse.cdt.core.build.IToolChain;
import org.eclipse.cdt.core.settings.model.ICLanguageSettingEntry;
import org.eclipse.core.resources.IBuildConfiguration;
import org.eclipse.core.runtime.CoreException;

public abstract class CBuildCommandLauncherConfiguration
		extends CBuildConfiguration implements ICommandLauncherConfiguration {

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

	@Override
	public void registerLanguageSettingEntries(
			List<? extends ICLanguageSettingEntry> entries) {
		System.out.println("registerLanguageSettingEntries project="
				+ getProject() + " entries=" + entries);
	}

	@Override
	public List<ICLanguageSettingEntry> verifyLanguageSettingEntries(
			List<ICLanguageSettingEntry> entries) {
		System.out.println("verifyLanguageSettingEntries project="
				+ getProject() + " entries=" + entries);
		return null;
	}

}
