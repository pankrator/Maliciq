package com.huko.text.adventure.interpreter;

public class CommandInterpreter implements Executable {
	
	private String command;
	
	private String infoToPrint = "Blaaa";
	
	private String[] innerCommands;
	
	public CommandInterpreter() {}
	
	public CommandInterpreter(String command) {
		this.command = command;
	}

	@Override
	public boolean translateCommand(String cmd) {
		String[] newInnerCommands = cmd.split("\\s");
		
		if(newInnerCommands.length < 2) {
			return false;
		}
		
		if(!newInnerCommands[0].contentEquals("create")) {
			return false;
		}
		
		innerCommands = newInnerCommands;
		
		return true;
	}

	@Override
	public int execute() {
		
		if(innerCommands[0].contentEquals("create")) {
			CommandHelper.creatureCreate(Integer.parseInt(innerCommands[1]));
		}
		
		return 0;
	}
	
	public void putNewCommand(String cmd) {
		this.command = cmd;
	}
	
	public String getCommand() {
		return command;
	}

	public synchronized  String getInfoToPrint() {
		return infoToPrint;
	}

	public synchronized void setInfoToPrint(String infoToPrint) {
		this.infoToPrint = infoToPrint;
	}
	
	
	
	
}
