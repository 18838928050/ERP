/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

public class CodeRule {
	public static final String MANUAL = "MANUAL";
	public static final String AUTO_PREFIX = "AUTO_PREFIX";
	public static final String AUTO_TYPE_CODE = "AUTO_TYPE_CODE";
	public static final String AUTO_YEAR = "AUTO_YEAR";
	public static final String AUTO_MONTH = "AUTO_MONTH";
	public static final String AUTO_DATE = "AUTO_DATE";
	public static final int BASE = 1;
	public static final int BASE_CHILD = 2;
	public static final int BILL = 3;
	public static final String TSR_UNIFY = "UNIFY";
	public static final String TSR_INDEPENDENCE = "INDEPENDENCE";
	private long id;
	private String dataCode;
	private int dataType = 1;
	private String title;
	private String generateRule = "MANUAL";
	private String prefix;
	private String separator;
	private int numberLength = 0;
	private String enabled = "Y";
	private String tallySetRule;
	private String printFoot;

	public String getPrintFoot() {
		return this.printFoot;
	}

	public void setPrintFoot(String printFoot) {
		this.printFoot = printFoot;
	}

	public String getTallySetRule() {
		return this.tallySetRule;
	}

	public void setTallySetRule(String tallySetRule) {
		this.tallySetRule = tallySetRule;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getDataCode() {
		return this.dataCode;
	}

	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}

	public int getDataType() {
		return this.dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public String getGenerateRule() {
		return this.generateRule;
	}

	public void setGenerateRule(String generateRule) {
		this.generateRule = generateRule;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumberLength() {
		return this.numberLength;
	}

	public void setNumberLength(int numberLength) {
		this.numberLength = numberLength;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSeparator() {
		return this.separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}