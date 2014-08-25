package com.dgsoft.common.system.model;
// Generated Apr 28, 2013 11:02:59 AM by Hibernate Tools 4.0.0

import com.dgsoft.common.OrderBeanComparator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * WordCategory generated by hbm2java
 */
@Entity
@Table(name = "WORD_CATEGORY",catalog = "DB_PLAT_SYSTEM")
public class WordCategory implements java.io.Serializable {

	private String id;
	private String name;
	private String memo;
	private boolean system;
	private Set<Word> words = new HashSet<Word>(0);



	public WordCategory() {
	}

	public WordCategory(String id, String name, boolean system) {
		this.id = id;
		this.name = name;
		this.system = system;
	}
	public WordCategory(String id, String name, String memo, boolean system,
			Set<Word> words) {
		this.id = id;
		this.name = name;
		this.memo = memo;
		this.system = system;
		this.words = words;
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

	@Column(name = "MEMO", length = 100)
	@Size(max = 100)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "SYSTEM", nullable = false)
	public boolean isSystem() {
		return this.system;
	}

	public void setSystem(boolean system) {
		this.system = system;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "wordCategory",orphanRemoval = true, cascade =CascadeType.ALL)
	public Set<Word> getWords() {
		return this.words;
	}

	public void setWords(Set<Word> words) {
		this.words = words;
	}

    @Transient
    public List<Word> getWordList(){
        List<Word> result = new ArrayList<Word>(getWords());
        Collections.sort(result, OrderBeanComparator.getInstance());
        return result;
    }
}
