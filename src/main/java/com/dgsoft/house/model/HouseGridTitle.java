package com.dgsoft.house.model;
// Generated Jul 12, 2013 11:32:23 AM by Hibernate Tools 4.0.0

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HouseGridTitle generated by hbm2java
 */
@Entity
@Table(name = "HOUSE_GRID_TITLE", catalog = "HOUSE_INFO")
public class HouseGridTitle implements java.io.Serializable {

	private String id;
	private BuildGridMap buildGridMap;
	private int order;
	private String title;
	private int colspan;

	public HouseGridTitle() {
	}

	public HouseGridTitle(BuildGridMap buildGridMap, int order,
			String title, int colspan) {
		this.buildGridMap = buildGridMap;
		this.order = order;
		this.title = title;
		this.colspan = colspan;
	}

    public HouseGridTitle(BuildGridMap buildGridMap, int colspan, String title) {
        this.buildGridMap = buildGridMap;
        this.colspan = colspan;
        this.title = title;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRILD_ID", nullable = false)
	@NotNull
	public BuildGridMap getBuildGridMap() {
		return this.buildGridMap;
	}

	public void setBuildGridMap(BuildGridMap buildGridMap) {
		this.buildGridMap = buildGridMap;
	}

	@Column(name = "_ORDER", nullable = false)
	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Column(name = "TITLE", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "COLSPAN", nullable = false)
	public int getColspan() {
		return this.colspan;
	}

	public void setColspan(int colspan) {
		this.colspan = colspan;
	}

}
