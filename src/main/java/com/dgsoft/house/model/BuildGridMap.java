package com.dgsoft.house.model;
// Generated Jul 12, 2013 11:32:23 AM by Hibernate Tools 4.0.0

import org.hibernate.annotations.GenericGenerator;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * BuildGridMapEditor generated by hbm2java
 */
@Entity
@Table(name = "BUILD_GRID_MAP", catalog = "HOUSE_INFO",uniqueConstraints = {@UniqueConstraint(columnNames = {
        "BUILD_ID", "_ORDER"})})
public class BuildGridMap implements java.io.Serializable {

    private String id;
    private String name;
    private int order;
    private Set<GridRow> gridRows = new HashSet<GridRow>(0);
    private Set<HouseGridTitle> houseGridTitles = new HashSet<HouseGridTitle>(0);
    private Build build;

    public BuildGridMap() {
    }

    public BuildGridMap(Build build, String name, int order) {
        this.build = build;
        this.name = name;
        this.order = order;
    }

    public BuildGridMap(Build build) {
        this.build = build;
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

    @Column(name = "_ORDER", nullable = false)
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buildGridMap", orphanRemoval = true, cascade = {CascadeType.ALL})
    public Set<GridRow> getGridRows() {
        return this.gridRows;
    }

    public void setGridRows(Set<GridRow> gridRows) {
        this.gridRows = gridRows;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buildGridMap", orphanRemoval = true, cascade = {CascadeType.ALL})
    public Set<HouseGridTitle> getHouseGridTitles() {
        return this.houseGridTitles;
    }

    public void setHouseGridTitles(Set<HouseGridTitle> houseGridTitles) {
        this.houseGridTitles = houseGridTitles;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUILD_ID", nullable = false)
    @NotNull
    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    @Transient
    public List<HouseGridTitle> getHouseGridTitleList() {
        List<HouseGridTitle> result = new ArrayList<HouseGridTitle>(getHouseGridTitles());
        Collections.sort(result, new Comparator<HouseGridTitle>() {
            @Override
            public int compare(HouseGridTitle o1, HouseGridTitle o2) {
                return new Integer(o1.getOrder()).compareTo(o2.getOrder());
            }
        });
        return result;
    }

    @Transient
    public List<HouseGridTitle> getHouseGridUnitList(){
        List<HouseGridTitle> result = getHouseGridTitleList();
        if (!result.isEmpty())
            result.remove(0);
        return result;
    }

    @Transient
    public List<GridRow> getGridRowList() {
        List<GridRow> result = new ArrayList<GridRow>(getGridRows());
        Collections.sort(result, new Comparator<GridRow>() {
            @Override
            public int compare(GridRow o1, GridRow o2) {
                return new Integer(o1.getOrder()).compareTo(o2.getOrder());
            }
        });
        return result;
    }

    @Transient
    public List<Integer> getColList() {
        List<Integer> result = new ArrayList<Integer>();
        for (HouseGridTitle title : getHouseGridTitles()) {
            for (int i = 0; i < title.getColspan(); i++) {
                result.add(i);
            }
        }
        return result;
    }

    @Transient
    public List<Integer> getUnitColList() {
        List<Integer> result = getColList();
        if (!result.isEmpty())
            result.remove(0);
        return result;
    }

    @Transient
    public int getHouseCount(){
        int result = 0;
        for (GridRow gridRow: getGridRows()){
            for(GridBlock block: gridRow.getGridBlocks()){
                if (block.getHouse() != null){
                    result ++;
                }
            }
        }
        return result;
    }

}
