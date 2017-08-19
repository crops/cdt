package org.eclipse.cdt.docker.launcher.cbuild;

import java.util.List;

import org.eclipse.cdt.core.ICommandLauncher;
import org.eclipse.cdt.core.settings.model.ICLanguageSettingEntry;

public interface ICommandLauncherConfiguration {

	void registerLanguageSettingEntries(
			List<? extends ICLanguageSettingEntry> entries);

	List<ICLanguageSettingEntry> verifyLanguageSettingEntries(
			List<ICLanguageSettingEntry> entries);

	ICommandLauncher getCommandLauncher();

}
