package com.dgsoft.house.model;
// Generated Jul 12, 2013 11:32:23 AM by Hibernate Tools 4.0.0

import com.dgsoft.common.utils.persistence.UniqueVerify;
import com.google.common.collect.Iterators;
import org.hibernate.annotations.GenericGenerator;
import org.jboss.seam.international.StatusMessage;

import java.util.*;
import javax.persistence.*;
import javax.swing.tree.TreeNode;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Section generated by hbm2java
 */
@Entity
@Table(name = "SECTION", catalog = "HOUSE_INFO")
@UniqueVerify(name = "name", severity = StatusMessage.Severity.ERROR, field = {"name"})
public class Section implements java.io.Serializable,TreeNode {

	private String id;
	private Integer version;
	private District district;
	private String name;
	private String address;
	private Set<Project> projects = new HashSet<Project>(0);
	private Set<Smsubcompany> smsubcompanies = new HashSet<Smsubcompany>(0);
	private Set<OwnerGroup> ownerGroups = new HashSet<OwnerGroup>(0);
    private Set<PoolBuild> poolBuilds = new HashSet<PoolBuild>(0);

	public Section() {
	}

    public Section(District district){
        this.district = district;
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

	@Version
	@Column(name = "VERSION")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICTID",nullable = false)
    @NotNull
	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
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

	@Column(name = "ADDRESS", length = 200)
	@Size(max = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
	public Set<Smsubcompany> getSmsubcompanies() {
		return this.smsubcompanies;
	}

	public void setSmsubcompanies(Set<Smsubcompany> smsubcompanies) {
		this.smsubcompanies = smsubcompanies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
	public Set<OwnerGroup> getOwnerGroups() {
		return this.ownerGroups;
	}

	public void setOwnerGroups(Set<OwnerGroup> ownerGroups) {
		this.ownerGroups = ownerGroups;
	}

    @Transient
    public List<Project> getProjectList(){
        return new ArrayList<Project>(getProjects());
    }

    @Override
    @Transient
    public TreeNode getChildAt(int childIndex) {
        return getProjectList().get(childIndex);
    }

    @Override
    @Transient
    public int getChildCount() {
        return getProjects().size();
    }

    @Override
    @Transient
    public TreeNode getParent() {
        return getDistrict();
    }

    @Override
    @Transient
    public int getIndex(TreeNode node) {
        return getProjectList().indexOf(node);
    }

    @Override
    @Transient
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    @Transient
    public boolean isLeaf() {
        return getProjects().isEmpty();
    }

    @Override
    @Transient
    public Enumeration children() {
        return Iterators.asEnumeration(getProjects().iterator());
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
    public Set<PoolBuild> getPoolBuilds() {
        return poolBuilds;
    }

    public void setPoolBuilds(Set<PoolBuild> poolBuilds) {
        this.poolBuilds = poolBuilds;
    }
}