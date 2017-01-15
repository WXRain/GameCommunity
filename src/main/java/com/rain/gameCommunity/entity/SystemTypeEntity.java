package com.rain.gameCommunity.entity;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository("SystemTypeEntity")
public class SystemTypeEntity implements Serializable {

	// 系统类型编号
	private int systemTypeNum;

	// 系统类型名称
	private String name;

	// 内存
	private String memory;

	// 处理器
	private String CPU;

	// 声卡
	private String voice;

	// 显卡
	private String display;

	public SystemTypeEntity() {
		super();
	}

	public SystemTypeEntity(int systemTypeNum, String name, String memory, String cPU, String voice, String display) {
		super();
		this.systemTypeNum = systemTypeNum;
		this.name = name;
		this.memory = memory;
		CPU = cPU;
		this.voice = voice;
		this.display = display;
	}

	/**
	 * @return the systemTypeNum
	 */
	public int getSystemTypeNum() {
		return systemTypeNum;
	}

	/**
	 * @param systemTypeNum
	 *            the systemTypeNum to set
	 */
	public void setSystemTypeNum(int systemTypeNum) {
		this.systemTypeNum = systemTypeNum;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the memory
	 */
	public String getMemory() {
		return memory;
	}

	/**
	 * @param memory
	 *            the memory to set
	 */
	public void setMemory(String memory) {
		this.memory = memory;
	}

	/**
	 * @return the cPU
	 */
	public String getCPU() {
		return CPU;
	}

	/**
	 * @param cPU
	 *            the cPU to set
	 */
	public void setCPU(String cPU) {
		CPU = cPU;
	}

	/**
	 * @return the voice
	 */
	public String getVoice() {
		return voice;
	}

	/**
	 * @param voice
	 *            the voice to set
	 */
	public void setVoice(String voice) {
		this.voice = voice;
	}

	/**
	 * @return the display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @param display
	 *            the display to set
	 */
	public void setDisplay(String display) {
		this.display = display;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SystemTypeEntity [systemTypeNum=" + systemTypeNum + ", name=" + name + ", memory=" + memory + ", CPU="
				+ CPU + ", voice=" + voice + ", display=" + display + "]";
	}

}
