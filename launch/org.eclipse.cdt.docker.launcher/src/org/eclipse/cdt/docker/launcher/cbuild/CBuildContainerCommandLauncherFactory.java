package org.eclipse.cdt.docker.launcher.cbuild;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.cdt.core.ICommandLauncher;
import org.eclipse.cdt.core.ICommandLauncherFactory;
import org.eclipse.cdt.core.build.ICBuildConfiguration;
import org.eclipse.cdt.core.settings.model.ICConfigurationDescription;
import org.eclipse.cdt.core.settings.model.ICLanguageSettingEntry;
import org.eclipse.cdt.docker.launcher.DockerLaunchUIPlugin;
import org.eclipse.core.resources.IBuildConfiguration;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

public class CBuildContainerCommandLauncherFactory
		implements ICommandLauncherFactory {

	public CBuildContainerCommandLauncherFactory() {
		super();
	}

	protected <A> Collection<A> getConfigurationAdapters(IProject project,
			Class<A> adapter) {
		List<A> results = new ArrayList<A>();
		try {
			for (IBuildConfiguration config : project.getBuildConfigs()) {
				ICBuildConfiguration cbc = config
						.getAdapter(ICBuildConfiguration.class);
				if (cbc != null) {
					A cconfig = cbc.getAdapter(adapter);
					if (cconfig != null)
						results.add(cconfig);
				}
			}
		} catch (CoreException e) {
			DockerLaunchUIPlugin.log(IStatus.ERROR, "Could not get adapter="
					+ adapter + " for project=" + project);
		}
		return results;
	}

	protected <A> A getDefaultConfiguration(IProject project,
			Class<A> adapter) {
		Collection<A> configs = getConfigurationAdapters(project, adapter);
		return (configs.size() > 0) ? configs.iterator().next() : null;
	}

	@Override
	public ICommandLauncher getCommandLauncher(IProject project) {
		ICommandLauncherConfiguration comConfig = getDefaultConfiguration(
				project, ICommandLauncherConfiguration.class);
		if (comConfig != null)
			return comConfig.getCommandLauncher();
		return null;
	}

	@Override
	public ICommandLauncher getCommandLauncher(
			ICConfigurationDescription cfgd) {
		return getCommandLauncher(cfgd.getProjectDescription().getProject());
	}

	@Override
	public void registerLanguageSettingEntries(IProject project,
			List<? extends ICLanguageSettingEntry> entries) {
		ICommandLauncherConfiguration comConfig = getDefaultConfiguration(
				project, ICommandLauncherConfiguration.class);
		if (comConfig != null)
			comConfig.registerLanguageSettingEntries(entries);
	}

	@Override
	public List<ICLanguageSettingEntry> verifyLanguageSettingEntries(
			IProject project, List<ICLanguageSettingEntry> entries) {
		ICommandLauncherConfiguration comConfig = getDefaultConfiguration(
				project, ICommandLauncherConfiguration.class);
		List<ICLanguageSettingEntry> results = null;
		if (comConfig != null)
			results = comConfig.verifyLanguageSettingEntries(entries);
		return results;
	}

}
