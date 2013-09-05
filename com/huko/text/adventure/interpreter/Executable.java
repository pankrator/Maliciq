package com.huko.text.adventure.interpreter;

public interface Executable {
	boolean translateCommand(String cmd);
	int execute();
}
