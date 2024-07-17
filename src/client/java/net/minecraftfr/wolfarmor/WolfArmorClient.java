package net.minecraftfr.wolfarmor;

import net.fabricmc.api.ClientModInitializer;

public class WolfArmorClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ModModelPredicateProvider.registerModModels();
	}
}
