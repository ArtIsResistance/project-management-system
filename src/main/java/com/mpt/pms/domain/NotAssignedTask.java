package com.mpt.pms.domain;

import java.time.LocalDate;
import java.util.Calendar;

public class NotAssignedTask extends Task {
    public NotAssignedTask(String description, int hours, LocalDate executionDate) {
        super(description, hours, executionDate);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
