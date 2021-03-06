package com.dgsoft.common.system.model;

import com.dgsoft.common.OrderModel;
import com.dgsoft.common.system.business.Subscribe;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * Created by cooper on 3/2/15.
 */
@Entity
@Table(name = "SUBSCRIBE_GROUP", catalog = "DB_PLAT_SYSTEM")
public class SubscribeGroup implements java.io.Serializable, OrderModel {

    private String id;
    private String taskName;
    private String name;
    private String iconCss;

    private Subscribe.SubscribeType type;
    private BusinessDefine businessDefine;
    private int priority;
    private Integer groupWidth;
    private Integer keyWidth;
    private Integer valueWidth;

    private Set<ViewSubscribe> viewSubscribes = new HashSet<ViewSubscribe>(0);

    public SubscribeGroup() {
    }

    public SubscribeGroup(String taskName, String name, Subscribe.SubscribeType type, BusinessDefine businessDefine, int priority, String iconCss) {
        this.taskName = taskName;
        this.name = name;
        this.type = type;
        this.businessDefine = businessDefine;
        this.priority = priority;
        this.iconCss = iconCss;
    }

    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="NAME", nullable = false, length = 30)
    @NotNull
    @Size(max = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "TASK_NAME", nullable = true, length = 200)
    @Size(max = 200)
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Column(name="ICON_CSS",nullable = true,length = 100)
    @Size(max = 100)
    public String getIconCss() {
        return iconCss;
    }

    public void setIconCss(String iconCss) {
        this.iconCss = iconCss;
    }

    @Transient
    public String getTask(){
        if ((getTaskName() == null) || getTaskName().trim().equals("")){
            return Subscribe.CREATE_TASK_NAME;
        }else{
            return getTaskName();
        }
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false, length = 20)
    @NotNull
    public Subscribe.SubscribeType getType() {
        return type;
    }

    public void setType(Subscribe.SubscribeType type) {
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEFINE_ID", nullable = false)
    @NotNull
    public BusinessDefine getBusinessDefine() {
        return businessDefine;
    }

    public void setBusinessDefine(BusinessDefine businessDefine) {
        this.businessDefine = businessDefine;
    }

    @Column(name = "PRIORITY",nullable = false)
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    @Column(name="GROUP_WIDTH",nullable = true)
    public Integer getGroupWidth() {
        return groupWidth;
    }

    public void setGroupWidth(Integer groupWidth) {
        this.groupWidth = groupWidth;
    }

    @Column(name="KEY_WIDTH",nullable = true, length = 20)
    public Integer getKeyWidth() {
        return keyWidth;
    }

    public void setKeyWidth(Integer keyWidth) {
        this.keyWidth = keyWidth;
    }

    @Column(name="VALUE_WIDTH",nullable = true, length = 20)
    public Integer getValueWidth() {
        return valueWidth;
    }

    public void setValueWidth(Integer valueWidth) {
        this.valueWidth = valueWidth;
    }

    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true, cascade = {CascadeType.ALL},mappedBy = "subscribeGroup")
    public Set<ViewSubscribe> getViewSubscribes() {
        return viewSubscribes;
    }

    public void setViewSubscribes(Set<ViewSubscribe> viewSubscribes) {
        this.viewSubscribes = viewSubscribes;
    }



    @Transient
    public List<ViewSubscribe> getViewSubscribeList(){
        List<ViewSubscribe> result = new ArrayList<ViewSubscribe>(getViewSubscribes());
        Collections.sort(result, new Comparator<ViewSubscribe>() {
            @Override
            public int compare(ViewSubscribe o1, ViewSubscribe o2) {
                return new Integer(o1.getPriority()).compareTo(o2.getPriority());
            }
        });
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscribeGroup group = (SubscribeGroup) o;

        if (id != null ? !id.equals(group.id) : group.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
