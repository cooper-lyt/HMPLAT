package com.dgsoft.house.owner.business;

import com.dgsoft.common.system.business.TaskPublish;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.bpm.EndTask;

/**
 * Created by cooper on 9/4/14.
 */
@Name("ownerTaskHandle")
@Scope(ScopeType.CONVERSATION)
public class OwnerTaskHandle{

    @In
    private TaskPublish taskPublish;


    @Transactional
    @EndTask
    public String complete() {
        if ("success".equals(taskPublish.save())) {
            return completeTask();
        }
        return null;
    }

    @In
    private OwnerBusinessHome ownerBusinessHome;

    protected String completeTask() {
        if ("updated".equals(ownerBusinessHome.update())){
            return "taskCompleted";
        }
        return null;
    }


}