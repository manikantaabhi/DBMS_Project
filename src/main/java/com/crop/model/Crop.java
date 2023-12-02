package com.crop.model;

public class Crop {
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public byte[] getCropData() {
		return cropData;
	}
	public void setCropData(byte[] cropData) {
		this.cropData = cropData;
	}
	private String cropName;
	private byte[] cropData;
}
