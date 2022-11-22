package org.example.basic;

import org.example.Models.Workspace;
import org.example.TestBase;
import org.junit.Test;

public class EditWorkSpaceTest {

    @Test
    public static void run(TestBase testBase){
        String workspaceName = "Selenuim workspace 000";
        String workspaceSummary = "a workspace for selenuim 002";
        Workspace workspace = new Workspace(workspaceName, workspaceSummary);

        testBase.login();
        testBase.createWorkspace(workspace);
    }
}
