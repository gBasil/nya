package dev.gbasil.nya;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.client.event.ClientChatEvent;

@Mod("nya")
public class Nya {
	final String text = "nya";
	
	public Nya() {
		MinecraftForge.EVENT_BUS.addListener(this::chat);
	}
	
	public void chat(ClientChatEvent event) {
		String message = event.getMessage();
		if (message.startsWith("/")) return;

		int repeatCount = 0;

		// get loop amount. it looks super weird but it works
		if (message.length() == 0) repeatCount = 0;
		else repeatCount = ((message.length() - 1) / text.length()) + 1;

		event.setMessage(new String(new char[Math.max(repeatCount, 1)]).replace("\0", text));
	}
}