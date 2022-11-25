package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.ProductDescription;
import com.notimplement.happygear.model.dto.ProductDescriptionDto;

public class ProductDescriptionMapper {
	public static ProductDescriptionDto toProductDescriptionDto(ProductDescription des) {
		ProductDescriptionDto dto = new ProductDescriptionDto();
		dto.setProductId(des.getProductId());
		dto.setCategoryId(des.getDesCategory().getCategoryId());
		dto.setKeycap(des.getKeycap());
		dto.setSwitchKeyBoard(des.getSwitchKeyBoard());
		dto.setTypeKeyboard(des.getTypeKeyboard());
		dto.setConnect(des.getConnect());
		dto.setLed(des.getLed());
		dto.setFreigh(des.getFreigh());
		dto.setItemDimension(des.getItemDimension());
		dto.setCpu(des.getCpu());
		dto.setRam(des.getRam());
		dto.setOperatingSystem(des.getOperatingSystem());
		dto.setBattery(des.getBattery());
		dto.setHardDisk(des.getHardDisk());
		dto.setGraphicCard(des.getGraphicCard());
		dto.setKeyBoard(des.getKeyBoard());
		dto.setAudio(des.getAudio());
		dto.setWifi(des.getWifi());
		dto.setBluetooth(des.getBluetooth());
		dto.setColor(des.getColor());
		dto.setFrameRate(des.getFrameRate());
		dto.setScreenSize(des.getScreenSize());
		dto.setScreenType(des.getScreenType());
		return dto;
		
	}
}
