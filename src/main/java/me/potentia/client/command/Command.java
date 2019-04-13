package me.potentia.client.command;

public abstract class Command {
	
	public abstract boolean onCommand(String command, String[] args);
	
	public String getDescription() {
		return "No description";
	}
	
	public abstract String getUsage();

}
