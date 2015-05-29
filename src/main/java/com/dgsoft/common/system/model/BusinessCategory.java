package com.dgsoft.common.system.model;
// Generated Apr 28, 2013 11:02:59 AM by Hibernate Tools 4.0.0

import com.dgsoft.common.OrderModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * BusinessCategory generated by hbm2java
 */
@Entity
@Table(name = "BUSINESS_CATEGORY",catalog = "DB_PLAT_SYSTEM")
public class BusinessCategory implements java.io.Serializable, OrderModel {

    private static final long serialVersionUID = -4834419763249347625L;

    private String id;
    private String name;
    private int priority;
    private Set<BusinessDefine> businessDefines = new HashSet<BusinessDefine>(0);

    public BusinessCategory() {
    }

    public BusinessCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public BusinessCategory(String id, String name, Integer priority,
                            Set<BusinessDefine> businessDefines) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.businessDefines = businessDefines;
    }

    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Column(name = "PRIORITY",nullable = false)
    public int getPriority() {
        return this.priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessCategory")
    public Set<BusinessDefine> getBusinessDefines() {
        return this.businessDefines;
    }

    public void setBusinessDefines(Set<BusinessDefine> businessDefines) {
        this.businessDefines = businessDefines;
    }

    @Transient
    public List<BusinessDefine> getBusinessDefineList() {
        return new ArrayList<BusinessDefine>(getBusinessDefines());
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BusinessCategory)) {
            return false;
        }
        return id.equals(((BusinessCategory) obj).getId());
    }
}
