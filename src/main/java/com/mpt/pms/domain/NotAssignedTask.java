package com.mpt.pms.domain;

public class NotAssignedTask extends Task {
    public NotAssignedTask(String description, int hours) {
        super(description, hours);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
