package com.rain.gameCommunity.entity;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
/**
 * 
 * @author wangxinyu
 *
 */
@Repository
public class SystemSupportEntity implements Serializable {

	// 系统支持ID
	private int id;
	
	// 系统支持名
	private String systemName;

	// 内存
	private String memoria;

	// 支持系统
	private String system;

	// 磁盘空间
	private String disk;

	// 声卡
	private String voice;

	// 是否需要网络
	private String network;

	// CPU
	private String cpu;

	// 显卡
	private String display;

	// 备注
	private String note;

	/**
	 * @return the systemTypeNum
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param systemTypeNum
	 *            the systemTypeNum to set
	 */
	public void setSystemTypeNum(int id) {
		this.id = id;
	}

	/**
	 * @return the memoria
	 */
	public String getMemoria() {
		return memoria;
	}

	/**
	 * @param memoria
	 *            the memoria to set
	 */
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	/**
	 * @return the system
	 */
	public String getSystem() {
		return system;
	}

	/**
	 * @param system
	 *            the system to set
	 */
	public void setSystem(String system) {
		this.system = system;
	}

	/**
	 * @return the disk
	 */
	public String getDisk() {
		return disk;
	}

	/**
	 * @param disk
	 *            the disk to set
	 */
	public void setDisk(String disk) {
		this.disk = disk;
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
	 * @return the network
	 */
	public String isNetwork() {
		return network;
	}

	/**
	 * @param network
	 *            the network to set
	 */
	public void setNetwork(String network) {
		this.network = network;
	}

	/**
	 * @return the cpu
	 */
	public String getCpu() {
		return cpu;
	}

	/**
	 * @param cpu
	 *            the cpu to set
	 */
	public void setCpu(String cpu) {
		this.cpu = cpu;
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

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */


	public SystemSupportEntity() {
	}
	
	

	public SystemSupportEntity(int id, String systemName, String memoria, String system, String disk, String voice,
			String network, String cpu, String display, String note) {
		super();
		this.id = id;
		this.systemName = systemName;
		this.memoria = memoria;
		this.system = system;
		this.disk = disk;
		this.voice = voice;
		this.network = network;
		this.cpu = cpu;
		this.display = display;
		this.note = note;
	}

	@Override
	public String toString() {
		return "SystemSupportEntity [id=" + id + ", systemName=" + systemName + ", memoria=" + memoria + ", system="
				+ system + ", disk=" + disk + ", voice=" + voice + ", network=" + network + ", cpu=" + cpu
				+ ", display=" + display + ", note=" + note + "]";
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public void setId(int id) {
		this.id = id;
	}

}
