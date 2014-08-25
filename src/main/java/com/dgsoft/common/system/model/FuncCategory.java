package com.dgsoft.common.system.model;
// Generated Apr 28, 2013 11:02:59 AM by Hibernate Tools 4.0.0

import com.dgsoft.common.OrderBeanComparator;
import com.dgsoft.common.OrderModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * FuncCategory generated by hbm2java
 */
@Entity
@Table(name = "FUNC_CATEGORY",catalog = "DB_PLAT_SYSTEM")
public class FuncCategory implements OrderModel, java.io.Serializable {

	private String id;
	private String name;
	private String icon;
	private int priority;
	private String memo;
	private Set<Function> functions = new HashSet<Function>(0);

	public FuncCategory() {
	}

	public FuncCategory(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public FuncCategory(String id, String name, String icon, int priority,
                        String memo, Set<Function> functions) {
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.priority = priority;
		this.memo = memo;
		this.functions = functions;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "uuid")
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

	@Column(name = "ICON", length = 100)
	@Size(max = 100)
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "PRIORITY", nullable = false)
	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Column(name = "MEMO", length = 100)
	@Size(max = 100)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcCategory")
    @OrderBy("priority")
	public Set<Function> getFunctions() {
		return this.functions;
	}

	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}

    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (!(obj instanceof FuncCategory)){
            return false;
        }
        return id.equals(((FuncCategory) obj).getId());
    }

    @Transient
    public List<Function> getFunctionList(){
        List<Function> result =new ArrayList<Function>(getFunctions());
        Collections.sort(result, OrderBeanComparator.getInstance());
        return result;
    }
}
