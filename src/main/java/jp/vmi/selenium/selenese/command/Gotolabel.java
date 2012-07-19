package jp.vmi.selenium.selenese.command;

import com.thoughtworks.selenium.SeleniumException;

import jp.vmi.selenium.selenese.Context;

public class Gotolabel extends Command {

    private static final int LABEL = 0;

    Gotolabel(int index, String name, String[] args, String realName, boolean andWait) {
        super(index, name, args);
    }

    @Override
    public Command next(Context context) {
        Label labelCommand = context.getLabelCommand(args[LABEL]);
        if (labelCommand == null)
            throw new SeleniumException("label \"" + args[LABEL] + "\" is not found.");
        return labelCommand.next;
    }
}