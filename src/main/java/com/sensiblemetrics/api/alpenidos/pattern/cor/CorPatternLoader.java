package com.sensiblemetrics.api.alpenidos.pattern.cor;

import com.sensiblemetrics.api.alpenidos.pattern.cor.model.*;

public class CorPatternLoader {

    public static void main(final String args[]) {
        final Leader objDirector = new Director("王明");
        final Leader objManager = new Manager("赵强");
        final Leader objGeneralManager = new GeneralManager("李波");
        final Leader objViceGeneralManager = new ViceGeneralManager("肖红");

        objDirector.setSuccessor(objManager);
        objManager.setSuccessor(objViceGeneralManager);
        objViceGeneralManager.setSuccessor(objGeneralManager);

        final LeaveRequest lr1 = new LeaveRequest("LeaveName-01", 2);
        objDirector.handleRequest(lr1);

        final LeaveRequest lr2 = new LeaveRequest("LeaveName-02", 5);
        objDirector.handleRequest(lr2);

        final LeaveRequest lr3 = new LeaveRequest("LeaveName-03", 15);
        objDirector.handleRequest(lr3);

        final LeaveRequest lr4 = new LeaveRequest("LeaveName-04", 25);
        objDirector.handleRequest(lr4);
    }
}
