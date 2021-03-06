package com.dgsoft.house.owner;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.ui.JpaEntityLoader;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 * User: cooperlee
 * Date: 11/04/14
 * Time: 13:26
 */
@Name("ownerEntityLoader")
public class OwnerEntityLoader extends JpaEntityLoader {

    @Override
    protected String getPersistenceContextName()
    {
        return "ownerEntityManager";
    }

    @In
    private EntityManager ownerEntityManager;

    @Override
    public EntityManager getPersistenceContext(){

        return ownerEntityManager;
    }

    public static OwnerEntityLoader instance()
    {
        if ( !Contexts.isEventContextActive() )
        {
            throw new IllegalStateException("no active event context");
        }
        return (OwnerEntityLoader) Component.getInstance(OwnerEntityLoader.class, true);
    }
}